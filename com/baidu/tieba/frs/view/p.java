package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class p extends LinearLayout {
    private TextView aCf;
    private EditText bem;
    private HeadImageView ben;
    private TextView beo;
    private TextView bep;
    private ShareFromFrsMsgData beq;
    private Context context;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bem;
    }

    public void w(String str, boolean z) {
        if (this.ben != null) {
            this.ben.d(str, 15, false);
        }
    }

    public p(Context context) {
        super(context);
        this.context = context;
        as(context);
    }

    private void as(Context context) {
        LayoutInflater.from(context).inflate(i.g.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(i.f.share_content);
        this.aCf = (TextView) findViewById(i.f.frs_card_name);
        this.bem = (EditText) findViewById(i.f.chat_msg);
        this.ben = (HeadImageView) findViewById(i.f.frs_card_img);
        this.bep = (TextView) findViewById(i.f.frs_card_member_num);
        this.beo = (TextView) findViewById(i.f.frs_card_post_num);
        an.b(this.aCf, i.c.cp_cont_b, 1);
        an.b(this.bem, i.c.cp_cont_b, 2);
        this.bem.setHintTextColor(an.getColor(i.c.cp_cont_e));
        this.bem.setPadding(context.getResources().getDimensionPixelSize(i.d.ds20), 0, 0, 0);
        Ov();
    }

    public void Ov() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bem != null) {
            return com.baidu.adp.lib.util.j.a(this.bem.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.beq = shareFromFrsMsgData;
        vx();
    }

    private void vx() {
        this.aCf.setText(dq(this.beq.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.beq.getImageUrl());
        this.ben.d(this.beq.getImageUrl(), 15, false);
        this.bep.setText(as.q(this.beq.getMemberNum()));
        this.beo.setText(as.q(this.beq.getPostNum()));
    }

    private String dq(String str) {
        return String.valueOf(as.i(str, 18)) + this.context.getString(i.h.forum);
    }
}
