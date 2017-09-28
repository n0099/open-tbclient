package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private LinearLayout aLj;
    private EditText cKh;
    private HeadImageView cKi;
    private TextView cKj;
    private TextView cKk;
    private ShareFromFrsMsgData cKl;
    private Context context;
    private TextView name;

    public EditText getChatMsgView() {
        return this.cKh;
    }

    public void I(String str, boolean z) {
        if (this.cKi != null) {
            this.cKi.c(str, 15, false);
        }
    }

    public d(Context context) {
        super(context);
        this.context = context;
        bs(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cKi.setPageId(bdUniqueId);
    }

    private void bs(Context context) {
        LayoutInflater.from(context).inflate(d.j.frs_share_card_view, this);
        setOrientation(1);
        this.aLj = (LinearLayout) findViewById(d.h.share_content);
        this.name = (TextView) findViewById(d.h.frs_card_name);
        this.cKh = (EditText) findViewById(d.h.chat_msg);
        this.cKi = (HeadImageView) findViewById(d.h.frs_card_img);
        this.cKk = (TextView) findViewById(d.h.frs_card_member_num);
        this.cKj = (TextView) findViewById(d.h.frs_card_post_num);
        aj.c(this.name, d.e.cp_cont_b, 1);
        aj.c(this.cKh, d.e.cp_cont_b, 2);
        this.cKh.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        this.cKh.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        amn();
    }

    public void amn() {
        this.aLj.setFocusable(true);
        this.aLj.setFocusableInTouchMode(true);
        this.aLj.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cKh != null) {
            return k.a(this.cKh.getText(), null);
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
        this.cKl = shareFromFrsMsgData;
        wn();
    }

    private void wn() {
        this.name.setText(dS(this.cKl.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.cKl.getImageUrl());
        this.cKi.c(this.cKl.getImageUrl(), 15, false);
        this.cKk.setText(am.x(this.cKl.getMemberNum()));
        this.cKj.setText(am.x(this.cKl.getPostNum()));
    }

    private String dS(String str) {
        return am.j(str, 18) + this.context.getString(d.l.forum);
    }
}
