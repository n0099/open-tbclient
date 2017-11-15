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
    private LinearLayout aLO;
    private TextView aTP;
    private EditText cTB;
    private HeadImageView cTC;
    private TextView cTD;
    private TextView cTE;
    private ShareFromFrsMsgData cTF;
    private Context context;

    public EditText getChatMsgView() {
        return this.cTB;
    }

    public void G(String str, boolean z) {
        if (this.cTC != null) {
            this.cTC.startLoad(str, 15, false);
        }
    }

    public d(Context context) {
        super(context);
        this.context = context;
        br(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cTC.setPageId(bdUniqueId);
    }

    private void br(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_share_card_view, this);
        setOrientation(1);
        this.aLO = (LinearLayout) findViewById(d.g.share_content);
        this.aTP = (TextView) findViewById(d.g.frs_card_name);
        this.cTB = (EditText) findViewById(d.g.chat_msg);
        this.cTC = (HeadImageView) findViewById(d.g.frs_card_img);
        this.cTE = (TextView) findViewById(d.g.frs_card_member_num);
        this.cTD = (TextView) findViewById(d.g.frs_card_post_num);
        aj.c(this.aTP, d.C0080d.cp_cont_b, 1);
        aj.c(this.cTB, d.C0080d.cp_cont_b, 2);
        this.cTB.setHintTextColor(aj.getColor(d.C0080d.cp_cont_e));
        this.cTB.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        apj();
    }

    public void apj() {
        this.aLO.setFocusable(true);
        this.aLO.setFocusableInTouchMode(true);
        this.aLO.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cTB != null) {
            return k.a(this.cTB.getText(), null);
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
        this.cTF = shareFromFrsMsgData;
        wn();
    }

    private void wn() {
        this.aTP.setText(dX(this.cTF.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.cTF.getImageUrl());
        this.cTC.startLoad(this.cTF.getImageUrl(), 15, false);
        this.cTE.setText(am.y(this.cTF.getMemberNum()));
        this.cTD.setText(am.y(this.cTF.getPostNum()));
    }

    private String dX(String str) {
        return am.j(str, 18) + this.context.getString(d.j.forum);
    }
}
