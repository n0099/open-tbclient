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
    private LinearLayout aJG;
    private TextView bPh;
    private Context context;
    private EditText ehp;
    private HeadImageView ehq;
    private TextView ehr;
    private TextView ehs;
    private ShareFromFrsMsgData eht;

    public EditText getChatMsgView() {
        return this.ehp;
    }

    public void N(String str, boolean z) {
        if (this.ehq != null) {
            this.ehq.startLoad(str, 15, false);
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
        this.ehq.setPageId(bdUniqueId);
    }

    private void cr(Context context) {
        LayoutInflater.from(context).inflate(e.h.frs_share_card_view, this);
        setOrientation(1);
        this.aJG = (LinearLayout) findViewById(e.g.share_content);
        this.bPh = (TextView) findViewById(e.g.frs_card_name);
        this.ehp = (EditText) findViewById(e.g.chat_msg);
        this.ehq = (HeadImageView) findViewById(e.g.frs_card_img);
        this.ehs = (TextView) findViewById(e.g.frs_card_member_num);
        this.ehr = (TextView) findViewById(e.g.frs_card_post_num);
        al.c(this.bPh, e.d.cp_cont_b, 1);
        al.c(this.ehp, e.d.cp_cont_b, 2);
        this.ehp.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.ehp.setPadding(context.getResources().getDimensionPixelSize(e.C0210e.ds20), 0, 0, 0);
        aHY();
    }

    public void aHY() {
        this.aJG.setFocusable(true);
        this.aJG.setFocusableInTouchMode(true);
        this.aJG.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ehp != null) {
            return k.a(this.ehp.getText(), null);
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
        this.eht = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.bPh.setText(fM(this.eht.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.eht.getImageUrl());
        this.ehq.startLoad(this.eht.getImageUrl(), 15, false);
        this.ehs.setText(ao.U(this.eht.getMemberNum()));
        this.ehr.setText(ao.U(this.eht.getPostNum()));
    }

    private String fM(String str) {
        return ao.o(str, 18) + this.context.getString(e.j.forum);
    }
}
