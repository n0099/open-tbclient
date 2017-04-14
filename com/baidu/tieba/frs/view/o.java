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
    private LinearLayout aIy;
    private EditText cef;
    private HeadImageView ceg;
    private TextView ceh;
    private TextView cei;
    private ShareFromFrsMsgData cej;
    private Context context;
    private TextView name;

    public EditText getChatMsgView() {
        return this.cef;
    }

    public void G(String str, boolean z) {
        if (this.ceg != null) {
            this.ceg.c(str, 15, false);
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
        this.aIy = (LinearLayout) findViewById(w.h.share_content);
        this.name = (TextView) findViewById(w.h.frs_card_name);
        this.cef = (EditText) findViewById(w.h.chat_msg);
        this.ceg = (HeadImageView) findViewById(w.h.frs_card_img);
        this.cei = (TextView) findViewById(w.h.frs_card_member_num);
        this.ceh = (TextView) findViewById(w.h.frs_card_post_num);
        aq.c(this.name, w.e.cp_cont_b, 1);
        aq.c(this.cef, w.e.cp_cont_b, 2);
        this.cef.setHintTextColor(aq.getColor(w.e.cp_cont_e));
        this.cef.setPadding(context.getResources().getDimensionPixelSize(w.f.ds20), 0, 0, 0);
        aez();
    }

    public void aez() {
        this.aIy.setFocusable(true);
        this.aIy.setFocusableInTouchMode(true);
        this.aIy.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cef != null) {
            return com.baidu.adp.lib.util.j.a(this.cef.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cej = shareFromFrsMsgData;
        wU();
    }

    private void wU() {
        this.name.setText(dF(this.cej.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.cej.getImageUrl());
        this.ceg.c(this.cej.getImageUrl(), 15, false);
        this.cei.setText(au.w(this.cej.getMemberNum()));
        this.ceh.setText(au.w(this.cej.getPostNum()));
    }

    private String dF(String str) {
        return String.valueOf(au.j(str, 18)) + this.context.getString(w.l.forum);
    }
}
