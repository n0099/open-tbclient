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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class n extends LinearLayout {
    private LinearLayout aEo;
    private TextView aKZ;
    private EditText chp;
    private HeadImageView chq;
    private TextView chr;
    private TextView chs;
    private ShareFromFrsMsgData cht;
    private Context context;

    public EditText getChatMsgView() {
        return this.chp;
    }

    public void E(String str, boolean z) {
        if (this.chq != null) {
            this.chq.c(str, 15, false);
        }
    }

    public n(Context context) {
        super(context);
        this.context = context;
        aE(context);
    }

    private void aE(Context context) {
        LayoutInflater.from(context).inflate(t.h.frs_share_card_view, this);
        setOrientation(1);
        this.aEo = (LinearLayout) findViewById(t.g.share_content);
        this.aKZ = (TextView) findViewById(t.g.frs_card_name);
        this.chp = (EditText) findViewById(t.g.chat_msg);
        this.chq = (HeadImageView) findViewById(t.g.frs_card_img);
        this.chs = (TextView) findViewById(t.g.frs_card_member_num);
        this.chr = (TextView) findViewById(t.g.frs_card_post_num);
        av.c(this.aKZ, t.d.cp_cont_b, 1);
        av.c(this.chp, t.d.cp_cont_b, 2);
        this.chp.setHintTextColor(av.getColor(t.d.cp_cont_e));
        this.chp.setPadding(context.getResources().getDimensionPixelSize(t.e.ds20), 0, 0, 0);
        afO();
    }

    public void afO() {
        this.aEo.setFocusable(true);
        this.aEo.setFocusableInTouchMode(true);
        this.aEo.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.chp != null) {
            return com.baidu.adp.lib.util.j.a(this.chp.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cht = shareFromFrsMsgData;
        wc();
    }

    private void wc() {
        this.aKZ.setText(dE(this.cht.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.cht.getImageUrl());
        this.chq.c(this.cht.getImageUrl(), 15, false);
        this.chs.setText(ba.y(this.cht.getMemberNum()));
        this.chr.setText(ba.y(this.cht.getPostNum()));
    }

    private String dE(String str) {
        return String.valueOf(ba.j(str, 18)) + this.context.getString(t.j.forum);
    }
}
