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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes25.dex */
public class MultiImageTextTopView extends RelativeLayout {
    private TextView fKk;
    private com.baidu.adp.lib.b.b jon;
    private TbImageView jqj;
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
        this.jon = null;
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_top_view, (ViewGroup) this, true);
        this.jqj = (TbImageView) findViewById(R.id.top_content_pic);
        this.jqj.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.top_title);
        this.fKk = (TextView) findViewById(R.id.show_time);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextTopView.this.jon != null) {
                    MultiImageTextTopView.this.jon.onItemViewLongClick(view, 9, MultiImageTextTopView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0716a c0716a, View view, final int i) {
        setPadding((int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30), (int) this.mContext.getResources().getDimension(R.dimen.ds30));
        if (c0716a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0716a.title)) {
                str = c0716a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0716a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextTopView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0716a != null && !StringUtils.isNull(c0716a.url)) {
                            be.bkp().b(tbPageContext, new String[]{c0716a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "official_msg_ck", "click", 1, "fid", c0716a.fid);
                                com.baidu.tieba.im.data.d LJ = com.baidu.tieba.im.util.e.LJ(c0716a.jql);
                                if (LJ != null) {
                                    TiebaStatic.eventStat(MultiImageTextTopView.this.mContext, "message_open_detail", "click", 1, "task_type", LJ.juD, "task_id", LJ.taskId, "loc", "0");
                                    if ((c0716a.userType == 1 || c0716a.userType == 3) && !"0".equals(LJ.taskId)) {
                                        com.baidu.tieba.im.b.a.cLT().LD(LJ.taskId);
                                    }
                                }
                                aq aqVar = new aq("official_message_open_detail");
                                aqVar.u("msg_id", c0716a.jEW / 100);
                                aqVar.dF("official_id", c0716a.jEX);
                                aqVar.ai("official_type", c0716a.jEY);
                                aqVar.u("operate_time", System.currentTimeMillis() / 1000);
                                aqVar.u("task_id", c0716a.taskId);
                                aqVar.dF("obj_params1", c0716a.url);
                                TiebaStatic.log(aqVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0716a.src)) {
                this.jqj.setTag(c0716a.src);
                this.jqj.startLoad(c0716a.src, 10, false);
            }
        }
    }

    public void setTime(String str) {
        if (TextUtils.isEmpty(str)) {
            this.fKk.setVisibility(8);
            this.fKk.setText("");
            return;
        }
        this.fKk.setVisibility(0);
        this.fKk.setText(str);
    }

    public void reset() {
        this.mTitle.setText("");
        this.jqj.setBackgroundDrawable(null);
        this.jqj.setImageDrawable(null);
        this.fKk.setVisibility(8);
        this.fKk.setText("");
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jon = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void qs(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.jqj.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_g, 1, skinType);
        ap.setViewTextColor(this.fKk, R.color.common_color_10067, 1, skinType);
    }
}
