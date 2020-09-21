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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.chat.a;
/* loaded from: classes25.dex */
public class MultiImageTextBottomView extends LinearLayout {
    private com.baidu.adp.lib.b.b jon;
    private TbImageView jqj;
    private int jqk;
    private String jql;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jon = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextBottomView.this.jon != null) {
                    MultiImageTextBottomView.this.jon.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.jqj = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.jqj.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.bottom_title);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0716a c0716a, View view, final int i) {
        if (c0716a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0716a.title)) {
                str = c0716a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0716a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0716a != null && !StringUtils.isNull(c0716a.url)) {
                            be.bkp().b(tbPageContext, new String[]{c0716a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "official_msg_ck", "click", 1, "fid", c0716a.fid);
                                com.baidu.tieba.im.data.d LJ = com.baidu.tieba.im.util.e.LJ(MultiImageTextBottomView.this.jql);
                                if (LJ != null) {
                                    TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "message_open_detail", "click", 1, "task_type", LJ.juD, "task_id", LJ.taskId, "loc", "" + MultiImageTextBottomView.this.jqk);
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

    public void reset() {
        this.mTitle.setText("");
        this.jqj.setBackgroundDrawable(null);
        this.jqj.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jon = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.jqk = i;
    }

    public void setTaskInfo(String str) {
        this.jql = str;
    }

    public void qs(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.jqj.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.common_color_10039, 1, skinType);
    }
}
