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
/* loaded from: classes2.dex */
public class FrsShareCardView extends LinearLayout {
    private LinearLayout aAJ;
    private TextView bCa;
    private Context context;
    private TextView dRA;
    private ShareFromFrsMsgData dRB;
    private EditText dRx;
    private HeadImageView dRy;
    private TextView dRz;

    public EditText getChatMsgView() {
        return this.dRx;
    }

    public void E(String str, boolean z) {
        if (this.dRy != null) {
            this.dRy.startLoad(str, 15, false);
        }
    }

    public FrsShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        cf(context);
    }

    public FrsShareCardView(Context context) {
        super(context);
        this.context = context;
        cf(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dRy.setPageId(bdUniqueId);
    }

    private void cf(Context context) {
        LayoutInflater.from(context).inflate(e.h.frs_share_card_view, this);
        setOrientation(1);
        this.aAJ = (LinearLayout) findViewById(e.g.share_content);
        this.bCa = (TextView) findViewById(e.g.frs_card_name);
        this.dRx = (EditText) findViewById(e.g.chat_msg);
        this.dRy = (HeadImageView) findViewById(e.g.frs_card_img);
        this.dRA = (TextView) findViewById(e.g.frs_card_member_num);
        this.dRz = (TextView) findViewById(e.g.frs_card_post_num);
        al.c(this.bCa, e.d.cp_cont_b, 1);
        al.c(this.dRx, e.d.cp_cont_b, 2);
        this.dRx.setHintTextColor(al.getColor(e.d.cp_cont_e));
        this.dRx.setPadding(context.getResources().getDimensionPixelSize(e.C0141e.ds20), 0, 0, 0);
        aDw();
    }

    public void aDw() {
        this.aAJ.setFocusable(true);
        this.aAJ.setFocusableInTouchMode(true);
        this.aAJ.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dRx != null) {
            return k.a(this.dRx.getText(), null);
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
        this.dRB = shareFromFrsMsgData;
        Bp();
    }

    private void Bp() {
        this.bCa.setText(fg(this.dRB.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.dRB.getImageUrl());
        this.dRy.startLoad(this.dRB.getImageUrl(), 15, false);
        this.dRA.setText(ao.J(this.dRB.getMemberNum()));
        this.dRz.setText(ao.J(this.dRB.getPostNum()));
    }

    private String fg(String str) {
        return ao.o(str, 18) + this.context.getString(e.j.forum);
    }
}
