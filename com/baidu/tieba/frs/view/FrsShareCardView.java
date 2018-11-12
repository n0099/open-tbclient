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
    private LinearLayout aGg;
    private TextView bLs;
    private Context context;
    private EditText eaM;
    private HeadImageView eaN;
    private TextView eaO;
    private TextView eaP;
    private ShareFromFrsMsgData eaQ;

    public EditText getChatMsgView() {
        return this.eaM;
    }

    public void L(String str, boolean z) {
        if (this.eaN != null) {
            this.eaN.startLoad(str, 15, false);
        }
    }

    public FrsShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        cn(context);
    }

    public FrsShareCardView(Context context) {
        super(context);
        this.context = context;
        cn(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.eaN.setPageId(bdUniqueId);
    }

    private void cn(Context context) {
        LayoutInflater.from(context).inflate(e.h.frs_share_card_view, this);
        setOrientation(1);
        this.aGg = (LinearLayout) findViewById(e.g.share_content);
        this.bLs = (TextView) findViewById(e.g.frs_card_name);
        this.eaM = (EditText) findViewById(e.g.chat_msg);
        this.eaN = (HeadImageView) findViewById(e.g.frs_card_img);
        this.eaP = (TextView) findViewById(e.g.frs_card_member_num);
        this.eaO = (TextView) findViewById(e.g.frs_card_post_num);
        al.c(this.bLs, e.d.cp_cont_b, 1);
        al.c(this.eaM, e.d.cp_cont_b, 2);
        this.eaM.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.eaM.setPadding(context.getResources().getDimensionPixelSize(e.C0200e.ds20), 0, 0, 0);
        aGm();
    }

    public void aGm() {
        this.aGg.setFocusable(true);
        this.aGg.setFocusableInTouchMode(true);
        this.aGg.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.eaM != null) {
            return k.a(this.eaM.getText(), null);
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
        this.eaQ = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.bLs.setText(fu(this.eaQ.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.eaQ.getImageUrl());
        this.eaN.startLoad(this.eaQ.getImageUrl(), 15, false);
        this.eaP.setText(ao.N(this.eaQ.getMemberNum()));
        this.eaO.setText(ao.N(this.eaQ.getPostNum()));
    }

    private String fu(String str) {
        return ao.o(str, 18) + this.context.getString(e.j.forum);
    }
}
