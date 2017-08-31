package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private LinearLayout aLK;
    private TextView cIA;
    private ShareFromFrsMsgData cIB;
    private EditText cIx;
    private HeadImageView cIy;
    private TextView cIz;
    private Context context;
    private TextView name;

    public EditText getChatMsgView() {
        return this.cIx;
    }

    public void L(String str, boolean z) {
        if (this.cIy != null) {
            this.cIy.c(str, 15, false);
        }
    }

    public d(Context context) {
        super(context);
        this.context = context;
        bs(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cIy.setPageId(bdUniqueId);
    }

    private void bs(Context context) {
        LayoutInflater.from(context).inflate(d.j.frs_share_card_view, this);
        setOrientation(1);
        this.aLK = (LinearLayout) findViewById(d.h.share_content);
        this.name = (TextView) findViewById(d.h.frs_card_name);
        this.cIx = (EditText) findViewById(d.h.chat_msg);
        this.cIy = (HeadImageView) findViewById(d.h.frs_card_img);
        this.cIA = (TextView) findViewById(d.h.frs_card_member_num);
        this.cIz = (TextView) findViewById(d.h.frs_card_post_num);
        aj.c(this.name, d.e.cp_cont_b, 1);
        aj.c(this.cIx, d.e.cp_cont_b, 2);
        this.cIx.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        this.cIx.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        alY();
    }

    public void alY() {
        this.aLK.setFocusable(true);
        this.aLK.setFocusableInTouchMode(true);
        this.aLK.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cIx != null) {
            return j.a(this.cIx.getText(), null);
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
        this.cIB = shareFromFrsMsgData;
        wO();
    }

    private void wO() {
        this.name.setText(dZ(this.cIB.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.cIB.getImageUrl());
        this.cIy.c(this.cIB.getImageUrl(), 15, false);
        this.cIA.setText(am.y(this.cIB.getMemberNum()));
        this.cIz.setText(am.y(this.cIB.getPostNum()));
    }

    private String dZ(String str) {
        return am.j(str, 18) + this.context.getString(d.l.forum);
    }
}
