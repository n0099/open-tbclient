package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class o extends LinearLayout {
    private LinearLayout aCL;
    private EditText bYj;
    private HeadImageView bYk;
    private TextView bYl;
    private TextView bYm;
    private ShareFromFrsMsgData bYn;
    private Context context;
    private TextView name;

    public EditText getChatMsgView() {
        return this.bYj;
    }

    public void F(String str, boolean z) {
        if (this.bYk != null) {
            this.bYk.c(str, 15, false);
        }
    }

    public o(Context context) {
        super(context);
        this.context = context;
        aT(context);
    }

    private void aT(Context context) {
        LayoutInflater.from(context).inflate(r.j.frs_share_card_view, this);
        setOrientation(1);
        this.aCL = (LinearLayout) findViewById(r.h.share_content);
        this.name = (TextView) findViewById(r.h.frs_card_name);
        this.bYj = (EditText) findViewById(r.h.chat_msg);
        this.bYk = (HeadImageView) findViewById(r.h.frs_card_img);
        this.bYm = (TextView) findViewById(r.h.frs_card_member_num);
        this.bYl = (TextView) findViewById(r.h.frs_card_post_num);
        ap.c(this.name, r.e.cp_cont_b, 1);
        ap.c(this.bYj, r.e.cp_cont_b, 2);
        this.bYj.setHintTextColor(ap.getColor(r.e.cp_cont_e));
        this.bYj.setPadding(context.getResources().getDimensionPixelSize(r.f.ds20), 0, 0, 0);
        adF();
    }

    public void adF() {
        this.aCL.setFocusable(true);
        this.aCL.setFocusableInTouchMode(true);
        this.aCL.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bYj != null) {
            return com.baidu.adp.lib.util.j.a(this.bYj.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bYn = shareFromFrsMsgData;
        wb();
    }

    private void wb() {
        this.name.setText(dF(this.bYn.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.bYn.getImageUrl());
        this.bYk.c(this.bYn.getImageUrl(), 15, false);
        this.bYm.setText(at.w(this.bYn.getMemberNum()));
        this.bYl.setText(at.w(this.bYn.getPostNum()));
    }

    private String dF(String str) {
        return String.valueOf(at.j(str, 18)) + this.context.getString(r.l.forum);
    }
}
