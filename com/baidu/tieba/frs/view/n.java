package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class n extends LinearLayout {
    private LinearLayout aAr;
    private TextView aGR;
    private EditText bUf;
    private HeadImageView bUg;
    private TextView bUh;
    private TextView bUi;
    private ShareFromFrsMsgData bUj;
    private Context context;

    public EditText getChatMsgView() {
        return this.bUf;
    }

    public void A(String str, boolean z) {
        if (this.bUg != null) {
            this.bUg.c(str, 15, false);
        }
    }

    public n(Context context) {
        super(context);
        this.context = context;
        ar(context);
    }

    private void ar(Context context) {
        LayoutInflater.from(context).inflate(u.h.frs_share_card_view, this);
        setOrientation(1);
        this.aAr = (LinearLayout) findViewById(u.g.share_content);
        this.aGR = (TextView) findViewById(u.g.frs_card_name);
        this.bUf = (EditText) findViewById(u.g.chat_msg);
        this.bUg = (HeadImageView) findViewById(u.g.frs_card_img);
        this.bUi = (TextView) findViewById(u.g.frs_card_member_num);
        this.bUh = (TextView) findViewById(u.g.frs_card_post_num);
        av.c(this.aGR, u.d.cp_cont_b, 1);
        av.c(this.bUf, u.d.cp_cont_b, 2);
        this.bUf.setHintTextColor(av.getColor(u.d.cp_cont_e));
        this.bUf.setPadding(context.getResources().getDimensionPixelSize(u.e.ds20), 0, 0, 0);
        aaB();
    }

    public void aaB() {
        this.aAr.setFocusable(true);
        this.aAr.setFocusableInTouchMode(true);
        this.aAr.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bUf != null) {
            return com.baidu.adp.lib.util.j.a(this.bUf.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bUj = shareFromFrsMsgData;
        uY();
    }

    private void uY() {
        this.aGR.setText(dD(this.bUj.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.bUj.getImageUrl());
        this.bUg.c(this.bUj.getImageUrl(), 15, false);
        this.bUi.setText(ba.D(this.bUj.getMemberNum()));
        this.bUh.setText(ba.D(this.bUj.getPostNum()));
    }

    private String dD(String str) {
        return String.valueOf(ba.j(str, 18)) + this.context.getString(u.j.forum);
    }
}
