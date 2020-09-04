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
/* loaded from: classes20.dex */
public class MultiImageTextBottomView extends LinearLayout {
    private com.baidu.adp.lib.b.b jfH;
    private TbImageView jhD;
    private int jhE;
    private String jhF;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jfH = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextBottomView.this.jfH != null) {
                    MultiImageTextBottomView.this.jfH.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.jhD = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.jhD.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.bottom_title);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0719a c0719a, View view, final int i) {
        if (c0719a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0719a.title)) {
                str = c0719a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0719a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0719a != null && !StringUtils.isNull(c0719a.url)) {
                            be.bju().b(tbPageContext, new String[]{c0719a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "official_msg_ck", "click", 1, "fid", c0719a.fid);
                                com.baidu.tieba.im.data.d Lh = com.baidu.tieba.im.util.e.Lh(MultiImageTextBottomView.this.jhF);
                                if (Lh != null) {
                                    TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "message_open_detail", "click", 1, "task_type", Lh.jlZ, "task_id", Lh.taskId, "loc", "" + MultiImageTextBottomView.this.jhE);
                                    if ((c0719a.userType == 1 || c0719a.userType == 3) && !"0".equals(Lh.taskId)) {
                                        com.baidu.tieba.im.b.a.cIn().Lb(Lh.taskId);
                                    }
                                }
                                aq aqVar = new aq("official_message_open_detail");
                                aqVar.u("msg_id", c0719a.jwu / 100);
                                aqVar.dD("official_id", c0719a.jwv);
                                aqVar.ai("official_type", c0719a.jww);
                                aqVar.u("operate_time", System.currentTimeMillis() / 1000);
                                aqVar.u("task_id", c0719a.taskId);
                                aqVar.dD("obj_params1", c0719a.url);
                                TiebaStatic.log(aqVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0719a.src)) {
                this.jhD.setTag(c0719a.src);
                this.jhD.startLoad(c0719a.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.jhD.setBackgroundDrawable(null);
        this.jhD.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jfH = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.jhE = i;
    }

    public void setTaskInfo(String str) {
        this.jhF = str;
    }

    public void qk(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.jhD.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.common_color_10039, 1, skinType);
    }
}
