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
    private LinearLayout aBh;
    private TextView aHI;
    private EditText bWf;
    private HeadImageView bWg;
    private TextView bWh;
    private TextView bWi;
    private ShareFromFrsMsgData bWj;
    private Context context;

    public EditText getChatMsgView() {
        return this.bWf;
    }

    public void A(String str, boolean z) {
        if (this.bWg != null) {
            this.bWg.c(str, 15, false);
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
        this.aBh = (LinearLayout) findViewById(u.g.share_content);
        this.aHI = (TextView) findViewById(u.g.frs_card_name);
        this.bWf = (EditText) findViewById(u.g.chat_msg);
        this.bWg = (HeadImageView) findViewById(u.g.frs_card_img);
        this.bWi = (TextView) findViewById(u.g.frs_card_member_num);
        this.bWh = (TextView) findViewById(u.g.frs_card_post_num);
        av.c(this.aHI, u.d.cp_cont_b, 1);
        av.c(this.bWf, u.d.cp_cont_b, 2);
        this.bWf.setHintTextColor(av.getColor(u.d.cp_cont_e));
        this.bWf.setPadding(context.getResources().getDimensionPixelSize(u.e.ds20), 0, 0, 0);
        abd();
    }

    public void abd() {
        this.aBh.setFocusable(true);
        this.aBh.setFocusableInTouchMode(true);
        this.aBh.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bWf != null) {
            return com.baidu.adp.lib.util.j.a(this.bWf.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bWj = shareFromFrsMsgData;
        uY();
    }

    private void uY() {
        this.aHI.setText(dC(this.bWj.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.bWj.getImageUrl());
        this.bWg.c(this.bWj.getImageUrl(), 15, false);
        this.bWi.setText(ba.y(this.bWj.getMemberNum()));
        this.bWh.setText(ba.y(this.bWj.getPostNum()));
    }

    private String dC(String str) {
        return String.valueOf(ba.j(str, 18)) + this.context.getString(u.j.forum);
    }
}
