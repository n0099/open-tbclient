package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class o extends LinearLayout {
    private LinearLayout aEC;
    private TextView aLq;
    private EditText bXp;
    private HeadImageView cmv;
    private TextView cmw;
    private TextView cmx;
    private ShareFromFrsMsgData cmy;
    private Context context;

    public EditText getChatMsgView() {
        return this.bXp;
    }

    public void F(String str, boolean z) {
        if (this.cmv != null) {
            this.cmv.c(str, 15, false);
        }
    }

    public o(Context context) {
        super(context);
        this.context = context;
        aO(context);
    }

    private void aO(Context context) {
        LayoutInflater.from(context).inflate(r.h.frs_share_card_view, this);
        setOrientation(1);
        this.aEC = (LinearLayout) findViewById(r.g.share_content);
        this.aLq = (TextView) findViewById(r.g.frs_card_name);
        this.bXp = (EditText) findViewById(r.g.chat_msg);
        this.cmv = (HeadImageView) findViewById(r.g.frs_card_img);
        this.cmx = (TextView) findViewById(r.g.frs_card_member_num);
        this.cmw = (TextView) findViewById(r.g.frs_card_post_num);
        at.c(this.aLq, r.d.cp_cont_b, 1);
        at.c(this.bXp, r.d.cp_cont_b, 2);
        this.bXp.setHintTextColor(at.getColor(r.d.cp_cont_e));
        this.bXp.setPadding(context.getResources().getDimensionPixelSize(r.e.ds20), 0, 0, 0);
        adV();
    }

    public void adV() {
        this.aEC.setFocusable(true);
        this.aEC.setFocusableInTouchMode(true);
        this.aEC.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bXp != null) {
            return com.baidu.adp.lib.util.j.a(this.bXp.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cmy = shareFromFrsMsgData;
        ww();
    }

    private void ww() {
        this.aLq.setText(dJ(this.cmy.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.cmy.getImageUrl());
        this.cmv.c(this.cmy.getImageUrl(), 15, false);
        this.cmx.setText(ax.y(this.cmy.getMemberNum()));
        this.cmw.setText(ax.y(this.cmy.getPostNum()));
    }

    private String dJ(String str) {
        return String.valueOf(ax.j(str, 18)) + this.context.getString(r.j.forum);
    }
}
