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
/* loaded from: classes2.dex */
public class e extends LinearLayout {
    private LinearLayout bAA;
    private TextView bLb;
    private Context context;
    private EditText dVn;
    private HeadImageView dVo;
    private TextView dVp;
    private TextView dVq;
    private ShareFromFrsMsgData dVr;

    public EditText getChatMsgView() {
        return this.dVn;
    }

    public void J(String str, boolean z) {
        if (this.dVo != null) {
            this.dVo.startLoad(str, 15, false);
        }
    }

    public e(Context context) {
        super(context);
        this.context = context;
        bB(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dVo.setPageId(bdUniqueId);
    }

    private void bB(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_share_card_view, this);
        setOrientation(1);
        this.bAA = (LinearLayout) findViewById(d.g.share_content);
        this.bLb = (TextView) findViewById(d.g.frs_card_name);
        this.dVn = (EditText) findViewById(d.g.chat_msg);
        this.dVo = (HeadImageView) findViewById(d.g.frs_card_img);
        this.dVq = (TextView) findViewById(d.g.frs_card_member_num);
        this.dVp = (TextView) findViewById(d.g.frs_card_post_num);
        aj.e(this.bLb, d.C0108d.cp_cont_b, 1);
        aj.e(this.dVn, d.C0108d.cp_cont_b, 2);
        this.dVn.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
        this.dVn.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        azD();
    }

    public void azD() {
        this.bAA.setFocusable(true);
        this.bAA.setFocusableInTouchMode(true);
        this.bAA.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dVn != null) {
            return k.a(this.dVn.getText(), null);
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
        this.dVr = shareFromFrsMsgData;
        DG();
    }

    private void DG() {
        this.bLb.setText(ek(this.dVr.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.dVr.getImageUrl());
        this.dVo.startLoad(this.dVr.getImageUrl(), 15, false);
        this.dVq.setText(am.H(this.dVr.getMemberNum()));
        this.dVp.setText(am.H(this.dVr.getPostNum()));
    }

    private String ek(String str) {
        return am.k(str, 18) + this.context.getString(d.j.forum);
    }
}
