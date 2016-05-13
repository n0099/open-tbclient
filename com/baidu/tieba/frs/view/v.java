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
public class v extends LinearLayout {
    private TextView aGp;
    private LinearLayout azz;
    private HeadImageView bwA;
    private TextView bwB;
    private TextView bwC;
    private ShareFromFrsMsgData bwD;
    private EditText bwz;
    private Context context;

    public EditText getChatMsgView() {
        return this.bwz;
    }

    public void z(String str, boolean z) {
        if (this.bwA != null) {
            this.bwA.c(str, 15, false);
        }
    }

    public v(Context context) {
        super(context);
        this.context = context;
        ar(context);
    }

    private void ar(Context context) {
        LayoutInflater.from(context).inflate(t.h.frs_share_card_view, this);
        setOrientation(1);
        this.azz = (LinearLayout) findViewById(t.g.share_content);
        this.aGp = (TextView) findViewById(t.g.frs_card_name);
        this.bwz = (EditText) findViewById(t.g.chat_msg);
        this.bwA = (HeadImageView) findViewById(t.g.frs_card_img);
        this.bwC = (TextView) findViewById(t.g.frs_card_member_num);
        this.bwB = (TextView) findViewById(t.g.frs_card_post_num);
        at.c(this.aGp, t.d.cp_cont_b, 1);
        at.c(this.bwz, t.d.cp_cont_b, 2);
        this.bwz.setHintTextColor(at.getColor(t.d.cp_cont_e));
        this.bwz.setPadding(context.getResources().getDimensionPixelSize(t.e.ds20), 0, 0, 0);
        Uo();
    }

    public void Uo() {
        this.azz.setFocusable(true);
        this.azz.setFocusableInTouchMode(true);
        this.azz.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bwz != null) {
            return com.baidu.adp.lib.util.j.a(this.bwz.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bwD = shareFromFrsMsgData;
        uY();
    }

    private void uY() {
        this.aGp.setText(dA(this.bwD.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.bwD.getImageUrl());
        this.bwA.c(this.bwD.getImageUrl(), 15, false);
        this.bwC.setText(ay.B(this.bwD.getMemberNum()));
        this.bwB.setText(ay.B(this.bwD.getPostNum()));
    }

    private String dA(String str) {
        return String.valueOf(ay.j(str, 18)) + this.context.getString(t.j.forum);
    }
}
