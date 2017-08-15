package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private LinearLayout aMd;
    private EditText cCh;
    private HeadImageView cCi;
    private TextView cCj;
    private TextView cCk;
    private ShareFromFrsMsgData cCl;
    private Context context;
    private TextView name;

    public EditText getChatMsgView() {
        return this.cCh;
    }

    public void K(String str, boolean z) {
        if (this.cCi != null) {
            this.cCi.c(str, 15, false);
        }
    }

    public d(Context context) {
        super(context);
        this.context = context;
        bk(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cCi.setPageId(bdUniqueId);
    }

    private void bk(Context context) {
        LayoutInflater.from(context).inflate(d.j.frs_share_card_view, this);
        setOrientation(1);
        this.aMd = (LinearLayout) findViewById(d.h.share_content);
        this.name = (TextView) findViewById(d.h.frs_card_name);
        this.cCh = (EditText) findViewById(d.h.chat_msg);
        this.cCi = (HeadImageView) findViewById(d.h.frs_card_img);
        this.cCk = (TextView) findViewById(d.h.frs_card_member_num);
        this.cCj = (TextView) findViewById(d.h.frs_card_post_num);
        ai.c(this.name, d.e.cp_cont_b, 1);
        ai.c(this.cCh, d.e.cp_cont_b, 2);
        this.cCh.setHintTextColor(ai.getColor(d.e.cp_cont_e));
        this.cCh.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        akw();
    }

    public void akw() {
        this.aMd.setFocusable(true);
        this.aMd.setFocusableInTouchMode(true);
        this.aMd.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cCh != null) {
            return j.a(this.cCh.getText(), null);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cCl = shareFromFrsMsgData;
        wP();
    }

    private void wP() {
        this.name.setText(ed(this.cCl.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.cCl.getImageUrl());
        this.cCi.c(this.cCl.getImageUrl(), 15, false);
        this.cCk.setText(al.z(this.cCl.getMemberNum()));
        this.cCj.setText(al.z(this.cCl.getPostNum()));
    }

    private String ed(String str) {
        return al.j(str, 18) + this.context.getString(d.l.forum);
    }
}
