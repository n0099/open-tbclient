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
    private TextView aDl;
    private EditText bdH;
    private HeadImageView bdI;
    private TextView bdJ;
    private TextView bdK;
    private ShareFromFrsMsgData bdL;
    private Context context;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bdH;
    }

    public void w(String str, boolean z) {
        if (this.bdI != null) {
            this.bdI.d(str, 15, false);
        }
    }

    public p(Context context) {
        super(context);
        this.context = context;
        at(context);
    }

    private void at(Context context) {
        LayoutInflater.from(context).inflate(i.g.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(i.f.share_content);
        this.aDl = (TextView) findViewById(i.f.frs_card_name);
        this.bdH = (EditText) findViewById(i.f.chat_msg);
        this.bdI = (HeadImageView) findViewById(i.f.frs_card_img);
        this.bdK = (TextView) findViewById(i.f.frs_card_member_num);
        this.bdJ = (TextView) findViewById(i.f.frs_card_post_num);
        an.b(this.aDl, i.c.cp_cont_b, 1);
        an.b(this.bdH, i.c.cp_cont_b, 2);
        this.bdH.setHintTextColor(an.getColor(i.c.cp_cont_e));
        this.bdH.setPadding(context.getResources().getDimensionPixelSize(i.d.ds20), 0, 0, 0);
        NZ();
    }

    public void NZ() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bdH != null) {
            return com.baidu.adp.lib.util.j.a(this.bdH.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bdL = shareFromFrsMsgData;
        vt();
    }

    private void vt() {
        this.aDl.setText(dq(this.bdL.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.bdL.getImageUrl());
        this.bdI.d(this.bdL.getImageUrl(), 15, false);
        this.bdK.setText(as.q(this.bdL.getMemberNum()));
        this.bdJ.setText(as.q(this.bdL.getPostNum()));
    }

    private String dq(String str) {
        return String.valueOf(as.i(str, 18)) + this.context.getString(i.h.forum);
    }
}
