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
    private LinearLayout aKW;
    private EditText cJV;
    private HeadImageView cJW;
    private TextView cJX;
    private TextView cJY;
    private ShareFromFrsMsgData cJZ;
    private Context context;
    private TextView name;

    public EditText getChatMsgView() {
        return this.cJV;
    }

    public void I(String str, boolean z) {
        if (this.cJW != null) {
            this.cJW.c(str, 15, false);
        }
    }

    public d(Context context) {
        super(context);
        this.context = context;
        br(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cJW.setPageId(bdUniqueId);
    }

    private void br(Context context) {
        LayoutInflater.from(context).inflate(d.j.frs_share_card_view, this);
        setOrientation(1);
        this.aKW = (LinearLayout) findViewById(d.h.share_content);
        this.name = (TextView) findViewById(d.h.frs_card_name);
        this.cJV = (EditText) findViewById(d.h.chat_msg);
        this.cJW = (HeadImageView) findViewById(d.h.frs_card_img);
        this.cJY = (TextView) findViewById(d.h.frs_card_member_num);
        this.cJX = (TextView) findViewById(d.h.frs_card_post_num);
        aj.c(this.name, d.e.cp_cont_b, 1);
        aj.c(this.cJV, d.e.cp_cont_b, 2);
        this.cJV.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        this.cJV.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        ami();
    }

    public void ami() {
        this.aKW.setFocusable(true);
        this.aKW.setFocusableInTouchMode(true);
        this.aKW.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cJV != null) {
            return k.a(this.cJV.getText(), null);
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
        this.cJZ = shareFromFrsMsgData;
        wg();
    }

    private void wg() {
        this.name.setText(dR(this.cJZ.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.cJZ.getImageUrl());
        this.cJW.c(this.cJZ.getImageUrl(), 15, false);
        this.cJY.setText(am.y(this.cJZ.getMemberNum()));
        this.cJX.setText(am.y(this.cJZ.getPostNum()));
    }

    private String dR(String str) {
        return am.j(str, 18) + this.context.getString(d.l.forum);
    }
}
