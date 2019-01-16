package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class FrsShareCardView extends LinearLayout {
    private LinearLayout aKk;
    private TextView bPV;
    private Context context;
    private EditText ekM;
    private HeadImageView ekN;
    private TextView ekO;
    private TextView ekP;
    private ShareFromFrsMsgData ekQ;

    public EditText getChatMsgView() {
        return this.ekM;
    }

    public void M(String str, boolean z) {
        if (this.ekN != null) {
            this.ekN.startLoad(str, 15, false);
        }
    }

    public FrsShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        cr(context);
    }

    public FrsShareCardView(Context context) {
        super(context);
        this.context = context;
        cr(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.ekN.setPageId(bdUniqueId);
    }

    private void cr(Context context) {
        LayoutInflater.from(context).inflate(e.h.frs_share_card_view, this);
        setOrientation(1);
        this.aKk = (LinearLayout) findViewById(e.g.share_content);
        this.bPV = (TextView) findViewById(e.g.frs_card_name);
        this.ekM = (EditText) findViewById(e.g.chat_msg);
        this.ekN = (HeadImageView) findViewById(e.g.frs_card_img);
        this.ekP = (TextView) findViewById(e.g.frs_card_member_num);
        this.ekO = (TextView) findViewById(e.g.frs_card_post_num);
        al.c(this.bPV, e.d.cp_cont_b, 1);
        al.c(this.ekM, e.d.cp_cont_b, 2);
        this.ekM.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.ekM.setPadding(context.getResources().getDimensionPixelSize(e.C0210e.ds20), 0, 0, 0);
        aJl();
    }

    public void aJl() {
        this.aKk.setFocusable(true);
        this.aKk.setFocusableInTouchMode(true);
        this.aKk.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ekM != null) {
            return k.a(this.ekM.getText(), null);
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
        this.ekQ = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.bPV.setText(ga(this.ekQ.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.ekQ.getImageUrl());
        this.ekN.startLoad(this.ekQ.getImageUrl(), 15, false);
        this.ekP.setText(ao.V(this.ekQ.getMemberNum()));
        this.ekO.setText(ao.V(this.ekQ.getPostNum()));
    }

    private String ga(String str) {
        return ao.o(str, 18) + this.context.getString(e.j.forum);
    }
}
