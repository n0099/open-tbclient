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
    private LinearLayout bCr;
    private TextView bMS;
    private Context context;
    private EditText dYP;
    private HeadImageView dYQ;
    private TextView dYR;
    private TextView dYS;
    private ShareFromFrsMsgData dYT;

    public EditText getChatMsgView() {
        return this.dYP;
    }

    public void G(String str, boolean z) {
        if (this.dYQ != null) {
            this.dYQ.startLoad(str, 15, false);
        }
    }

    public e(Context context) {
        super(context);
        this.context = context;
        bA(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dYQ.setPageId(bdUniqueId);
    }

    private void bA(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_share_card_view, this);
        setOrientation(1);
        this.bCr = (LinearLayout) findViewById(d.g.share_content);
        this.bMS = (TextView) findViewById(d.g.frs_card_name);
        this.dYP = (EditText) findViewById(d.g.chat_msg);
        this.dYQ = (HeadImageView) findViewById(d.g.frs_card_img);
        this.dYS = (TextView) findViewById(d.g.frs_card_member_num);
        this.dYR = (TextView) findViewById(d.g.frs_card_post_num);
        aj.e(this.bMS, d.C0141d.cp_cont_b, 1);
        aj.e(this.dYP, d.C0141d.cp_cont_b, 2);
        this.dYP.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        this.dYP.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        aAT();
    }

    public void aAT() {
        this.bCr.setFocusable(true);
        this.bCr.setFocusableInTouchMode(true);
        this.bCr.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dYP != null) {
            return k.a(this.dYP.getText(), null);
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
        this.dYT = shareFromFrsMsgData;
        DZ();
    }

    private void DZ() {
        this.bMS.setText(ew(this.dYT.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.dYT.getImageUrl());
        this.dYQ.startLoad(this.dYT.getImageUrl(), 15, false);
        this.dYS.setText(am.H(this.dYT.getMemberNum()));
        this.dYR.setText(am.H(this.dYT.getPostNum()));
    }

    private String ew(String str) {
        return am.k(str, 18) + this.context.getString(d.j.forum);
    }
}
