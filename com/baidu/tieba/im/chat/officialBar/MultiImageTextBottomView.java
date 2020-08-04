package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
public class MultiImageTextBottomView extends LinearLayout {
    private com.baidu.adp.lib.b.b iQE;
    private TbImageView iSA;
    private int iSB;
    private String iSC;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iQE = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextBottomView.this.iQE != null) {
                    MultiImageTextBottomView.this.iQE.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.iSA = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.iSA.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.bottom_title);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0667a c0667a, View view, final int i) {
        if (c0667a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0667a.title)) {
                str = c0667a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0667a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0667a != null && !StringUtils.isNull(c0667a.url)) {
                            bd.baV().b(tbPageContext, new String[]{c0667a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "official_msg_ck", "click", 1, "fid", c0667a.fid);
                                com.baidu.tieba.im.data.d Io = com.baidu.tieba.im.util.e.Io(MultiImageTextBottomView.this.iSC);
                                if (Io != null) {
                                    TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "message_open_detail", "click", 1, "task_type", Io.iWU, "task_id", Io.taskId, "loc", "" + MultiImageTextBottomView.this.iSB);
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

    public void reset() {
        this.mTitle.setText("");
        this.iSA.setBackgroundDrawable(null);
        this.iSA.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.iQE = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.iSB = i;
    }

    public void setTaskInfo(String str) {
        this.iSC = str;
    }

    public void pC(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.iSA.setAutoChangeStyle(z);
        ao.setViewTextColor(this.mTitle, R.color.common_color_10039, 1, skinType);
    }
}
