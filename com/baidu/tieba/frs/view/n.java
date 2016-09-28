package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class n extends LinearLayout {
    private LinearLayout aDM;
    private TextView aKy;
    private EditText chn;
    private HeadImageView cho;
    private TextView chp;
    private TextView chq;
    private ShareFromFrsMsgData chr;
    private Context context;

    public EditText getChatMsgView() {
        return this.chn;
    }

    public void F(String str, boolean z) {
        if (this.cho != null) {
            this.cho.c(str, 15, false);
        }
    }

    public n(Context context) {
        super(context);
        this.context = context;
        aC(context);
    }

    private void aC(Context context) {
        LayoutInflater.from(context).inflate(r.h.frs_share_card_view, this);
        setOrientation(1);
        this.aDM = (LinearLayout) findViewById(r.g.share_content);
        this.aKy = (TextView) findViewById(r.g.frs_card_name);
        this.chn = (EditText) findViewById(r.g.chat_msg);
        this.cho = (HeadImageView) findViewById(r.g.frs_card_img);
        this.chq = (TextView) findViewById(r.g.frs_card_member_num);
        this.chp = (TextView) findViewById(r.g.frs_card_post_num);
        av.c(this.aKy, r.d.cp_cont_b, 1);
        av.c(this.chn, r.d.cp_cont_b, 2);
        this.chn.setHintTextColor(av.getColor(r.d.cp_cont_e));
        this.chn.setPadding(context.getResources().getDimensionPixelSize(r.e.ds20), 0, 0, 0);
        agc();
    }

    public void agc() {
        this.aDM.setFocusable(true);
        this.aDM.setFocusableInTouchMode(true);
        this.aDM.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.chn != null) {
            return com.baidu.adp.lib.util.j.a(this.chn.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.chr = shareFromFrsMsgData;
        ws();
    }

    private void ws() {
        this.aKy.setText(dH(this.chr.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.chr.getImageUrl());
        this.cho.c(this.chr.getImageUrl(), 15, false);
        this.chq.setText(az.z(this.chr.getMemberNum()));
        this.chp.setText(az.z(this.chr.getPostNum()));
    }

    private String dH(String str) {
        return String.valueOf(az.j(str, 18)) + this.context.getString(r.j.forum);
    }
}
