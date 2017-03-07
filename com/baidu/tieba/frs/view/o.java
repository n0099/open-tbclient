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
    private LinearLayout aIi;
    private EditText cfF;
    private HeadImageView cfG;
    private TextView cfH;
    private TextView cfI;
    private ShareFromFrsMsgData cfJ;
    private Context context;
    private TextView name;

    public EditText getChatMsgView() {
        return this.cfF;
    }

    public void G(String str, boolean z) {
        if (this.cfG != null) {
            this.cfG.c(str, 15, false);
        }
    }

    public o(Context context) {
        super(context);
        this.context = context;
        bs(context);
    }

    private void bs(Context context) {
        LayoutInflater.from(context).inflate(w.j.frs_share_card_view, this);
        setOrientation(1);
        this.aIi = (LinearLayout) findViewById(w.h.share_content);
        this.name = (TextView) findViewById(w.h.frs_card_name);
        this.cfF = (EditText) findViewById(w.h.chat_msg);
        this.cfG = (HeadImageView) findViewById(w.h.frs_card_img);
        this.cfI = (TextView) findViewById(w.h.frs_card_member_num);
        this.cfH = (TextView) findViewById(w.h.frs_card_post_num);
        aq.c(this.name, w.e.cp_cont_b, 1);
        aq.c(this.cfF, w.e.cp_cont_b, 2);
        this.cfF.setHintTextColor(aq.getColor(w.e.cp_cont_e));
        this.cfF.setPadding(context.getResources().getDimensionPixelSize(w.f.ds20), 0, 0, 0);
        aeF();
    }

    public void aeF() {
        this.aIi.setFocusable(true);
        this.aIi.setFocusableInTouchMode(true);
        this.aIi.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cfF != null) {
            return com.baidu.adp.lib.util.j.a(this.cfF.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cfJ = shareFromFrsMsgData;
        wy();
    }

    private void wy() {
        this.name.setText(dz(this.cfJ.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.cfJ.getImageUrl());
        this.cfG.c(this.cfJ.getImageUrl(), 15, false);
        this.cfI.setText(au.w(this.cfJ.getMemberNum()));
        this.cfH.setText(au.w(this.cfJ.getPostNum()));
    }

    private String dz(String str) {
        return String.valueOf(au.j(str, 18)) + this.context.getString(w.l.forum);
    }
}
