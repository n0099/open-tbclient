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
    private LinearLayout aJI;
    private TextView bPk;
    private Context context;
    private EditText ekg;
    private HeadImageView ekh;
    private TextView eki;
    private TextView ekj;
    private ShareFromFrsMsgData ekk;

    public EditText getChatMsgView() {
        return this.ekg;
    }

    public void N(String str, boolean z) {
        if (this.ekh != null) {
            this.ekh.startLoad(str, 15, false);
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
        this.ekh.setPageId(bdUniqueId);
    }

    private void cr(Context context) {
        LayoutInflater.from(context).inflate(e.h.frs_share_card_view, this);
        setOrientation(1);
        this.aJI = (LinearLayout) findViewById(e.g.share_content);
        this.bPk = (TextView) findViewById(e.g.frs_card_name);
        this.ekg = (EditText) findViewById(e.g.chat_msg);
        this.ekh = (HeadImageView) findViewById(e.g.frs_card_img);
        this.ekj = (TextView) findViewById(e.g.frs_card_member_num);
        this.eki = (TextView) findViewById(e.g.frs_card_post_num);
        al.c(this.bPk, e.d.cp_cont_b, 1);
        al.c(this.ekg, e.d.cp_cont_b, 2);
        this.ekg.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.ekg.setPadding(context.getResources().getDimensionPixelSize(e.C0210e.ds20), 0, 0, 0);
        aIN();
    }

    public void aIN() {
        this.aJI.setFocusable(true);
        this.aJI.setFocusableInTouchMode(true);
        this.aJI.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ekg != null) {
            return k.a(this.ekg.getText(), null);
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
        this.ekk = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.bPk.setText(fN(this.ekk.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.ekk.getImageUrl());
        this.ekh.startLoad(this.ekk.getImageUrl(), 15, false);
        this.ekj.setText(ao.V(this.ekk.getMemberNum()));
        this.eki.setText(ao.V(this.ekk.getPostNum()));
    }

    private String fN(String str) {
        return ao.o(str, 18) + this.context.getString(e.j.forum);
    }
}
