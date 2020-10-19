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
/* loaded from: classes26.dex */
public class MultiImageTextBottomView extends LinearLayout {
    private com.baidu.adp.lib.b.b jDk;
    private TbImageView jFg;
    private int jFh;
    private String jFi;
    private Context mContext;
    private int mPosition;
    private TextView mTitle;

    public MultiImageTextBottomView(Context context) {
        this(context, null);
    }

    public MultiImageTextBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jDk = null;
        this.mContext = context;
        initView();
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MultiImageTextBottomView.this.jDk != null) {
                    MultiImageTextBottomView.this.jDk.onItemViewLongClick(view, 9, MultiImageTextBottomView.this.mPosition, 0L);
                    return false;
                }
                return false;
            }
        });
    }

    private void initView() {
        setOrientation(0);
        LayoutInflater.from(this.mContext).inflate(R.layout.msg_multi_pic_text_bottom_view, (ViewGroup) this, true);
        this.jFg = (TbImageView) findViewById(R.id.bottom_content_pic);
        this.jFg.setAutoChangeStyle(false);
        this.mTitle = (TextView) findViewById(R.id.bottom_title);
    }

    public void setData(final TbPageContext<?> tbPageContext, final a.C0734a c0734a, View view, final int i) {
        if (c0734a != null) {
            String str = "";
            if (!TextUtils.isEmpty(c0734a.title)) {
                str = c0734a.title;
            }
            this.mTitle.setText(str);
            if (!TextUtils.isEmpty(c0734a.url)) {
                setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.MultiImageTextBottomView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (c0734a != null && !StringUtils.isNull(c0734a.url)) {
                            be.bmY().b(tbPageContext, new String[]{c0734a.url});
                            if (i == 1) {
                                TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "official_msg_ck", "click", 1, "fid", c0734a.fid);
                                com.baidu.tieba.im.data.d My = com.baidu.tieba.im.util.e.My(MultiImageTextBottomView.this.jFi);
                                if (My != null) {
                                    TiebaStatic.eventStat(MultiImageTextBottomView.this.mContext, "message_open_detail", "click", 1, "task_type", My.jJA, "task_id", My.taskId, "loc", "" + MultiImageTextBottomView.this.jFh);
                                    if ((c0734a.userType == 1 || c0734a.userType == 3) && !"0".equals(My.taskId)) {
                                        com.baidu.tieba.im.b.a.cPB().Ms(My.taskId);
                                    }
                                }
                                aq aqVar = new aq("official_message_open_detail");
                                aqVar.u("msg_id", c0734a.jTT / 100);
                                aqVar.dK("official_id", c0734a.jTU);
                                aqVar.aj("official_type", c0734a.jTV);
                                aqVar.u("operate_time", System.currentTimeMillis() / 1000);
                                aqVar.u("task_id", c0734a.taskId);
                                aqVar.dK("obj_params1", c0734a.url);
                                TiebaStatic.log(aqVar);
                            }
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(c0734a.src)) {
                this.jFg.setTag(c0734a.src);
                this.jFg.startLoad(c0734a.src, 10, false);
            }
        }
    }

    public void reset() {
        this.mTitle.setText("");
        this.jFg.setBackgroundDrawable(null);
        this.jFg.setImageDrawable(null);
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        this.jDk = bVar;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void setStPosition(int i) {
        this.jFh = i;
    }

    public void setTaskInfo(String str) {
        this.jFi = str;
    }

    public void qY(boolean z) {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (!z) {
            skinType = 0;
        }
        this.jFg.setAutoChangeStyle(z);
        ap.setViewTextColor(this.mTitle, R.color.common_color_10039, 1, skinType);
    }
}
