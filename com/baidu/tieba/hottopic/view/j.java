package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class j extends LinearLayout {
    private TextView aEp;
    private TextView agd;
    private TbImageView bGf;
    private ShareFromTopicMsgData bGg;
    private EditText bkR;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bkR;
    }

    public void x(String str, boolean z) {
        if (this.bGf != null) {
            this.bGf.d(str, z ? 17 : 18, false);
        }
    }

    public j(Context context) {
        super(context);
        as(context);
    }

    private void as(Context context) {
        LayoutInflater.from(context).inflate(n.g.thread_to_group_share_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(n.f.share_content);
        this.agd = (TextView) findViewById(n.f.share_title_view);
        this.bkR = (EditText) findViewById(n.f.chat_msg);
        this.bGf = (TbImageView) findViewById(n.f.chat_group_img);
        this.aEp = (TextView) findViewById(n.f.chat_group_desc);
        as.b(this.agd, n.c.cp_cont_b, 1);
        as.b(this.bkR, n.c.cp_cont_b, 2);
        as.b(this.aEp, n.c.cp_cont_f, 1);
        this.bkR.setHintTextColor(as.getColor(n.c.cp_cont_e));
        this.bkR.setPadding(context.getResources().getDimensionPixelSize(n.d.ds20), 0, 0, 0);
        Qb();
    }

    public void Qb() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bkR != null) {
            return com.baidu.adp.lib.util.j.a(this.bkR.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromTopicMsgData shareFromTopicMsgData) {
        this.bGg = shareFromTopicMsgData;
        wd();
    }

    private void wd() {
        this.agd.setText(this.bGg.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.bGg.getImageUrl());
        this.bGf.setTag(this.bGg.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.bGg.getContent());
        this.aEp.setText(this.bGg.getContent());
    }
}
