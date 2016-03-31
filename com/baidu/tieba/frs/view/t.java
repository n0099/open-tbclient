package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class t extends LinearLayout {
    private LinearLayout aDv;
    private TextView aKg;
    private EditText bwN;
    private HeadImageView bwO;
    private TextView bwP;
    private TextView bwQ;
    private ShareFromFrsMsgData bwR;
    private Context context;

    public EditText getChatMsgView() {
        return this.bwN;
    }

    public void y(String str, boolean z) {
        if (this.bwO != null) {
            this.bwO.c(str, 15, false);
        }
    }

    public t(Context context) {
        super(context);
        this.context = context;
        aq(context);
    }

    private void aq(Context context) {
        LayoutInflater.from(context).inflate(t.h.frs_share_card_view, this);
        setOrientation(1);
        this.aDv = (LinearLayout) findViewById(t.g.share_content);
        this.aKg = (TextView) findViewById(t.g.frs_card_name);
        this.bwN = (EditText) findViewById(t.g.chat_msg);
        this.bwO = (HeadImageView) findViewById(t.g.frs_card_img);
        this.bwQ = (TextView) findViewById(t.g.frs_card_member_num);
        this.bwP = (TextView) findViewById(t.g.frs_card_post_num);
        at.b(this.aKg, t.d.cp_cont_b, 1);
        at.b(this.bwN, t.d.cp_cont_b, 2);
        this.bwN.setHintTextColor(at.getColor(t.d.cp_cont_e));
        this.bwN.setPadding(context.getResources().getDimensionPixelSize(t.e.ds20), 0, 0, 0);
        Uo();
    }

    public void Uo() {
        this.aDv.setFocusable(true);
        this.aDv.setFocusableInTouchMode(true);
        this.aDv.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bwN != null) {
            return com.baidu.adp.lib.util.j.a(this.bwN.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bwR = shareFromFrsMsgData;
        xo();
    }

    private void xo() {
        this.aKg.setText(dD(this.bwR.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.bwR.getImageUrl());
        this.bwO.c(this.bwR.getImageUrl(), 15, false);
        this.bwQ.setText(ay.A(this.bwR.getMemberNum()));
        this.bwP.setText(ay.A(this.bwR.getPostNum()));
    }

    private String dD(String str) {
        return String.valueOf(ay.j(str, 18)) + this.context.getString(t.j.forum);
    }
}
