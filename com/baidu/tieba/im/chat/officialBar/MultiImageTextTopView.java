package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes20.dex */
public class MultiImageTextTopView extends RelativeLayout {
    private TextView fvC;
    private com.baidu.adp.lib.b.b iQE;
    private TbImageView iSA;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextTopView(Context context) {
        this(context, null);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiImageTextTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iQE = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.iSA = (TbImageView) findViewById(R.id.top_content_pic);
        this.iSA.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.top_title);
        this.fvC = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.iQE != null) {
                    MultiImageTextTopView.this.iQE.onItemViewLongClick(view, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0667a c0667a, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30));
        if (c0667a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0667a.title)) {
                str = c0667a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0667a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0667a != null && !StringUtils.isNull(c0667a.url)) {
                            bd.baV().b(tbPageContext, new String[]{c0667a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, "fid", c0667a.fid);
                                com.baidu.tieba.im.data.d Io = com.baidu.tieba.im.util.e.Io(c0667a.iSC);
                                if (Io != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", Io.iWU, "task_id", Io.taskId, "loc", "0");
                                    if ((c0667a.userType == 1 || c0667a.userType == 3) && !"0".equals(Io.taskId)) {
                                        com.baidu.tieba.im.b.a.cxv().Ii(Io.taskId);
                                    }
                                }
                                ap apVar = new ap("official_message_open_detail");
                                apVar.t("msg_id", c0667a.jho / 100);
                                apVar.dn("official_id", c0667a.jhp);
                                apVar.ah("official_type", c0667a.jhq);
                                apVar.t("operate_time", System.currentTimeMillis() / 1000);
                                apVar.t("task_id", c0667a.taskId);
                                apVar.dn("obj_params1", c0667a.url);
                                TiebaStatic.log(apVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0667a.src)) {
                this.iSA.setTag(c0667a.src);
                this.iSA.startLoad(c0667a.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fvC.setVisibility(8);
            this.fvC.setText("");
            return;
        }
        this.fvC.setVisibility(0);
        this.fvC.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.iSA.setBackgroundDrawable(null);
        this.iSA.setImageDrawable(null);
        this.fvC.setVisibility(8);
        this.fvC.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.iQE = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void pC(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.iSA.setAutoChangeStyle(z);
        ao.setViewTextColor(this.mTitle, R.color.cp_cont_g, 1, skinType);
        ao.setViewTextColor(this.fvC, R.color.common_color_10067, 1, skinType);
    }
}
