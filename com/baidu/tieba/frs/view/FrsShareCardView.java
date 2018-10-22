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
    private LinearLayout aFq;
    private TextView bKH;
    private Context context;
    private EditText dZt;
    private HeadImageView dZu;
    private TextView dZv;
    private TextView dZw;
    private ShareFromFrsMsgData dZx;

    public EditText getChatMsgView() {
        return this.dZt;
    }

    public void L(String str, boolean z) {
        if (this.dZu != null) {
            this.dZu.startLoad(str, 15, false);
        }
    }

    public FrsShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        cs(context);
    }

    public FrsShareCardView(Context context) {
        super(context);
        this.context = context;
        cs(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dZu.setPageId(bdUniqueId);
    }

    private void cs(Context context) {
        LayoutInflater.from(context).inflate(e.h.frs_share_card_view, this);
        setOrientation(1);
        this.aFq = (LinearLayout) findViewById(e.g.share_content);
        this.bKH = (TextView) findViewById(e.g.frs_card_name);
        this.dZt = (EditText) findViewById(e.g.chat_msg);
        this.dZu = (HeadImageView) findViewById(e.g.frs_card_img);
        this.dZw = (TextView) findViewById(e.g.frs_card_member_num);
        this.dZv = (TextView) findViewById(e.g.frs_card_post_num);
        al.c(this.bKH, e.d.cp_cont_b, 1);
        al.c(this.dZt, e.d.cp_cont_b, 2);
        this.dZt.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.dZt.setPadding(context.getResources().getDimensionPixelSize(e.C0175e.ds20), 0, 0, 0);
        aGO();
    }

    public void aGO() {
        this.aFq.setFocusable(true);
        this.aFq.setFocusableInTouchMode(true);
        this.aFq.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dZt != null) {
            return k.a(this.dZt.getText(), null);
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
        this.dZx = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.bKH.setText(fu(this.dZx.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.dZx.getImageUrl());
        this.dZu.startLoad(this.dZx.getImageUrl(), 15, false);
        this.dZw.setText(ao.L(this.dZx.getMemberNum()));
        this.dZv.setText(ao.L(this.dZx.getPostNum()));
    }

    private String fu(String str) {
        return ao.o(str, 18) + this.context.getString(e.j.forum);
    }
}
