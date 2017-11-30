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
    private LinearLayout aMp;
    private TextView aWQ;
    private Context context;
    private EditText dcJ;
    private HeadImageView dcK;
    private TextView dcL;
    private TextView dcM;
    private ShareFromFrsMsgData dcN;

    public EditText getChatMsgView() {
        return this.dcJ;
    }

    public void H(String str, boolean z) {
        if (this.dcK != null) {
            this.dcK.startLoad(str, 15, false);
        }
    }

    public d(Context context) {
        super(context);
        this.context = context;
        bw(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dcK.setPageId(bdUniqueId);
    }

    private void bw(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_share_card_view, this);
        setOrientation(1);
        this.aMp = (LinearLayout) findViewById(d.g.share_content);
        this.aWQ = (TextView) findViewById(d.g.frs_card_name);
        this.dcJ = (EditText) findViewById(d.g.chat_msg);
        this.dcK = (HeadImageView) findViewById(d.g.frs_card_img);
        this.dcM = (TextView) findViewById(d.g.frs_card_member_num);
        this.dcL = (TextView) findViewById(d.g.frs_card_post_num);
        aj.c(this.aWQ, d.C0082d.cp_cont_b, 1);
        aj.c(this.dcJ, d.C0082d.cp_cont_b, 2);
        this.dcJ.setHintTextColor(aj.getColor(d.C0082d.cp_cont_e));
        this.dcJ.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        ard();
    }

    public void ard() {
        this.aMp.setFocusable(true);
        this.aMp.setFocusableInTouchMode(true);
        this.aMp.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dcJ != null) {
            return k.a(this.dcJ.getText(), null);
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
        this.dcN = shareFromFrsMsgData;
        wr();
    }

    private void wr() {
        this.aWQ.setText(dZ(this.dcN.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.dcN.getImageUrl());
        this.dcK.startLoad(this.dcN.getImageUrl(), 15, false);
        this.dcM.setText(am.y(this.dcN.getMemberNum()));
        this.dcL.setText(am.y(this.dcN.getPostNum()));
    }

    private String dZ(String str) {
        return am.j(str, 18) + this.context.getString(d.j.forum);
    }
}
