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
    private EditText dZs;
    private HeadImageView dZt;
    private TextView dZu;
    private TextView dZv;
    private ShareFromFrsMsgData dZw;

    public EditText getChatMsgView() {
        return this.dZs;
    }

    public void L(String str, boolean z) {
        if (this.dZt != null) {
            this.dZt.startLoad(str, 15, false);
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
        this.dZt.setPageId(bdUniqueId);
    }

    private void cs(Context context) {
        LayoutInflater.from(context).inflate(e.h.frs_share_card_view, this);
        setOrientation(1);
        this.aFq = (LinearLayout) findViewById(e.g.share_content);
        this.bKH = (TextView) findViewById(e.g.frs_card_name);
        this.dZs = (EditText) findViewById(e.g.chat_msg);
        this.dZt = (HeadImageView) findViewById(e.g.frs_card_img);
        this.dZv = (TextView) findViewById(e.g.frs_card_member_num);
        this.dZu = (TextView) findViewById(e.g.frs_card_post_num);
        al.c(this.bKH, e.d.cp_cont_b, 1);
        al.c(this.dZs, e.d.cp_cont_b, 2);
        this.dZs.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.dZs.setPadding(context.getResources().getDimensionPixelSize(e.C0175e.ds20), 0, 0, 0);
        aGO();
    }

    public void aGO() {
        this.aFq.setFocusable(true);
        this.aFq.setFocusableInTouchMode(true);
        this.aFq.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dZs != null) {
            return k.a(this.dZs.getText(), null);
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
        this.dZw = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.bKH.setText(fu(this.dZw.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.dZw.getImageUrl());
        this.dZt.startLoad(this.dZw.getImageUrl(), 15, false);
        this.dZv.setText(ao.L(this.dZw.getMemberNum()));
        this.dZu.setText(ao.L(this.dZw.getPostNum()));
    }

    private String fu(String str) {
        return ao.o(str, 18) + this.context.getString(e.j.forum);
    }
}
