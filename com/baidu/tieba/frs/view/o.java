package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class o extends LinearLayout {
    private LinearLayout aDV;
    private TextView aKH;
    private EditText bDz;
    private HeadImageView bRF;
    private TextView bRG;
    private TextView bRH;
    private ShareFromFrsMsgData bRI;
    private Context context;

    public EditText getChatMsgView() {
        return this.bDz;
    }

    public void G(String str, boolean z) {
        if (this.bRF != null) {
            this.bRF.c(str, 15, false);
        }
    }

    public o(Context context) {
        super(context);
        this.context = context;
        aN(context);
    }

    private void aN(Context context) {
        LayoutInflater.from(context).inflate(r.h.frs_share_card_view, this);
        setOrientation(1);
        this.aDV = (LinearLayout) findViewById(r.g.share_content);
        this.aKH = (TextView) findViewById(r.g.frs_card_name);
        this.bDz = (EditText) findViewById(r.g.chat_msg);
        this.bRF = (HeadImageView) findViewById(r.g.frs_card_img);
        this.bRH = (TextView) findViewById(r.g.frs_card_member_num);
        this.bRG = (TextView) findViewById(r.g.frs_card_post_num);
        ar.c(this.aKH, r.d.cp_cont_b, 1);
        ar.c(this.bDz, r.d.cp_cont_b, 2);
        this.bDz.setHintTextColor(ar.getColor(r.d.cp_cont_e));
        this.bDz.setPadding(context.getResources().getDimensionPixelSize(r.e.ds20), 0, 0, 0);
        Yp();
    }

    public void Yp() {
        this.aDV.setFocusable(true);
        this.aDV.setFocusableInTouchMode(true);
        this.aDV.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bDz != null) {
            return com.baidu.adp.lib.util.j.a(this.bDz.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bRI = shareFromFrsMsgData;
        wg();
    }

    private void wg() {
        this.aKH.setText(dH(this.bRI.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.bRI.getImageUrl());
        this.bRF.c(this.bRI.getImageUrl(), 15, false);
        this.bRH.setText(av.y(this.bRI.getMemberNum()));
        this.bRG.setText(av.y(this.bRI.getPostNum()));
    }

    private String dH(String str) {
        return String.valueOf(av.j(str, 18)) + this.context.getString(r.j.forum);
    }
}
