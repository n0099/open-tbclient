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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class FrsShareCardView extends LinearLayout {
    private LinearLayout aya;
    private TextView bvD;
    private Context context;
    private EditText dHC;
    private HeadImageView dHD;
    private TextView dHE;
    private TextView dHF;
    private ShareFromFrsMsgData dHG;

    public EditText getChatMsgView() {
        return this.dHC;
    }

    public void E(String str, boolean z) {
        if (this.dHD != null) {
            this.dHD.startLoad(str, 15, false);
        }
    }

    public FrsShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        bx(context);
    }

    public FrsShareCardView(Context context) {
        super(context);
        this.context = context;
        bx(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dHD.setPageId(bdUniqueId);
    }

    private void bx(Context context) {
        LayoutInflater.from(context).inflate(d.i.frs_share_card_view, this);
        setOrientation(1);
        this.aya = (LinearLayout) findViewById(d.g.share_content);
        this.bvD = (TextView) findViewById(d.g.frs_card_name);
        this.dHC = (EditText) findViewById(d.g.chat_msg);
        this.dHD = (HeadImageView) findViewById(d.g.frs_card_img);
        this.dHF = (TextView) findViewById(d.g.frs_card_member_num);
        this.dHE = (TextView) findViewById(d.g.frs_card_post_num);
        am.c(this.bvD, d.C0142d.cp_cont_b, 1);
        am.c(this.dHC, d.C0142d.cp_cont_b, 2);
        this.dHC.setHintTextColor(am.getColor(d.C0142d.cp_cont_e));
        this.dHC.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        aAF();
    }

    public void aAF() {
        this.aya.setFocusable(true);
        this.aya.setFocusableInTouchMode(true);
        this.aya.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dHC != null) {
            return k.a(this.dHC.getText(), null);
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
        this.dHG = shareFromFrsMsgData;
        AB();
    }

    private void AB() {
        this.bvD.setText(eQ(this.dHG.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.dHG.getImageUrl());
        this.dHD.startLoad(this.dHG.getImageUrl(), 15, false);
        this.dHF.setText(ap.D(this.dHG.getMemberNum()));
        this.dHE.setText(ap.D(this.dHG.getPostNum()));
    }

    private String eQ(String str) {
        return ap.j(str, 18) + this.context.getString(d.k.forum);
    }
}
