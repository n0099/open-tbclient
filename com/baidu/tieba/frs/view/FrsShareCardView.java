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
    private LinearLayout aKl;
    private TextView bPW;
    private Context context;
    private EditText ekN;
    private HeadImageView ekO;
    private TextView ekP;
    private TextView ekQ;
    private ShareFromFrsMsgData ekR;

    public EditText getChatMsgView() {
        return this.ekN;
    }

    public void M(String str, boolean z) {
        if (this.ekO != null) {
            this.ekO.startLoad(str, 15, false);
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
        this.ekO.setPageId(bdUniqueId);
    }

    private void cr(Context context) {
        LayoutInflater.from(context).inflate(e.h.frs_share_card_view, this);
        setOrientation(1);
        this.aKl = (LinearLayout) findViewById(e.g.share_content);
        this.bPW = (TextView) findViewById(e.g.frs_card_name);
        this.ekN = (EditText) findViewById(e.g.chat_msg);
        this.ekO = (HeadImageView) findViewById(e.g.frs_card_img);
        this.ekQ = (TextView) findViewById(e.g.frs_card_member_num);
        this.ekP = (TextView) findViewById(e.g.frs_card_post_num);
        al.c(this.bPW, e.d.cp_cont_b, 1);
        al.c(this.ekN, e.d.cp_cont_b, 2);
        this.ekN.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.ekN.setPadding(context.getResources().getDimensionPixelSize(e.C0210e.ds20), 0, 0, 0);
        aJl();
    }

    public void aJl() {
        this.aKl.setFocusable(true);
        this.aKl.setFocusableInTouchMode(true);
        this.aKl.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ekN != null) {
            return k.a(this.ekN.getText(), null);
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
        this.ekR = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.bPW.setText(ga(this.ekR.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.ekR.getImageUrl());
        this.ekO.startLoad(this.ekR.getImageUrl(), 15, false);
        this.ekQ.setText(ao.V(this.ekR.getMemberNum()));
        this.ekP.setText(ao.V(this.ekR.getPostNum()));
    }

    private String ga(String str) {
        return ao.o(str, 18) + this.context.getString(e.j.forum);
    }
}
