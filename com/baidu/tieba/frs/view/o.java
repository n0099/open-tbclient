package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class o extends LinearLayout {
    private LinearLayout aIA;
    private ShareFromFrsMsgData cgA;
    private EditText cgw;
    private HeadImageView cgx;
    private TextView cgy;
    private TextView cgz;
    private Context context;
    private TextView name;

    public EditText getChatMsgView() {
        return this.cgw;
    }

    public void G(String str, boolean z) {
        if (this.cgx != null) {
            this.cgx.c(str, 15, false);
        }
    }

    public o(Context context) {
        super(context);
        this.context = context;
        bm(context);
    }

    private void bm(Context context) {
        LayoutInflater.from(context).inflate(w.j.frs_share_card_view, this);
        setOrientation(1);
        this.aIA = (LinearLayout) findViewById(w.h.share_content);
        this.name = (TextView) findViewById(w.h.frs_card_name);
        this.cgw = (EditText) findViewById(w.h.chat_msg);
        this.cgx = (HeadImageView) findViewById(w.h.frs_card_img);
        this.cgz = (TextView) findViewById(w.h.frs_card_member_num);
        this.cgy = (TextView) findViewById(w.h.frs_card_post_num);
        aq.c(this.name, w.e.cp_cont_b, 1);
        aq.c(this.cgw, w.e.cp_cont_b, 2);
        this.cgw.setHintTextColor(aq.getColor(w.e.cp_cont_e));
        this.cgw.setPadding(context.getResources().getDimensionPixelSize(w.f.ds20), 0, 0, 0);
        afA();
    }

    public void afA() {
        this.aIA.setFocusable(true);
        this.aIA.setFocusableInTouchMode(true);
        this.aIA.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cgw != null) {
            return com.baidu.adp.lib.util.j.a(this.cgw.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cgA = shareFromFrsMsgData;
        wU();
    }

    private void wU() {
        this.name.setText(dF(this.cgA.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.cgA.getImageUrl());
        this.cgx.c(this.cgA.getImageUrl(), 15, false);
        this.cgz.setText(au.w(this.cgA.getMemberNum()));
        this.cgy.setText(au.w(this.cgA.getPostNum()));
    }

    private String dF(String str) {
        return String.valueOf(au.j(str, 18)) + this.context.getString(w.l.forum);
    }
}
