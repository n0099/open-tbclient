package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class p extends LinearLayout {
    private TextView aDa;
    private ShareFromFrsMsgData bdA;
    private EditText bdw;
    private HeadImageView bdx;
    private TextView bdy;
    private TextView bdz;
    private Context context;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bdw;
    }

    public void w(String str, boolean z) {
        if (this.bdx != null) {
            this.bdx.d(str, 15, false);
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
        this.aDa = (TextView) findViewById(i.f.frs_card_name);
        this.bdw = (EditText) findViewById(i.f.chat_msg);
        this.bdx = (HeadImageView) findViewById(i.f.frs_card_img);
        this.bdz = (TextView) findViewById(i.f.frs_card_member_num);
        this.bdy = (TextView) findViewById(i.f.frs_card_post_num);
        am.b(this.aDa, i.c.cp_cont_b, 1);
        am.b(this.bdw, i.c.cp_cont_b, 2);
        this.bdw.setHintTextColor(am.getColor(i.c.cp_cont_e));
        this.bdw.setPadding(context.getResources().getDimensionPixelSize(i.d.ds20), 0, 0, 0);
        Od();
    }

    public void Od() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bdw != null) {
            return com.baidu.adp.lib.util.j.a(this.bdw.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bdA = shareFromFrsMsgData;
        vw();
    }

    private void vw() {
        this.aDa.setText(dp(this.bdA.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.bdA.getImageUrl());
        this.bdx.d(this.bdA.getImageUrl(), 15, false);
        this.bdz.setText(ar.s(this.bdA.getMemberNum()));
        this.bdy.setText(ar.s(this.bdA.getPostNum()));
    }

    private String dp(String str) {
        return String.valueOf(ar.i(str, 18)) + this.context.getString(i.h.forum);
    }
}
