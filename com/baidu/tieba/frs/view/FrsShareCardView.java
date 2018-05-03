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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class FrsShareCardView extends LinearLayout {
    private LinearLayout aMU;
    private TextView blN;
    private Context context;
    private EditText dtM;
    private HeadImageView dtN;
    private TextView dtO;
    private TextView dtP;
    private ShareFromFrsMsgData dtQ;

    public EditText getChatMsgView() {
        return this.dtM;
    }

    public void D(String str, boolean z) {
        if (this.dtN != null) {
            this.dtN.startLoad(str, 15, false);
        }
    }

    public FrsShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        bo(context);
    }

    public FrsShareCardView(Context context) {
        super(context);
        this.context = context;
        bo(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dtN.setPageId(bdUniqueId);
    }

    private void bo(Context context) {
        LayoutInflater.from(context).inflate(d.i.frs_share_card_view, this);
        setOrientation(1);
        this.aMU = (LinearLayout) findViewById(d.g.share_content);
        this.blN = (TextView) findViewById(d.g.frs_card_name);
        this.dtM = (EditText) findViewById(d.g.chat_msg);
        this.dtN = (HeadImageView) findViewById(d.g.frs_card_img);
        this.dtP = (TextView) findViewById(d.g.frs_card_member_num);
        this.dtO = (TextView) findViewById(d.g.frs_card_post_num);
        ak.c(this.blN, d.C0126d.cp_cont_b, 1);
        ak.c(this.dtM, d.C0126d.cp_cont_b, 2);
        this.dtM.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        this.dtM.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        avQ();
    }

    public void avQ() {
        this.aMU.setFocusable(true);
        this.aMU.setFocusableInTouchMode(true);
        this.aMU.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dtM != null) {
            return k.a(this.dtM.getText(), null);
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
        this.dtQ = shareFromFrsMsgData;
        wL();
    }

    private void wL() {
        this.blN.setText(eo(this.dtQ.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.dtQ.getImageUrl());
        this.dtN.startLoad(this.dtQ.getImageUrl(), 15, false);
        this.dtP.setText(an.z(this.dtQ.getMemberNum()));
        this.dtO.setText(an.z(this.dtQ.getPostNum()));
    }

    private String eo(String str) {
        return an.j(str, 18) + this.context.getString(d.k.forum);
    }
}
