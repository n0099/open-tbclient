package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends LinearLayout {
    private LinearLayout aMt;
    private TextView aWS;
    private Context context;
    private EditText ddQ;
    private HeadImageView ddR;
    private TextView ddS;
    private TextView ddT;
    private ShareFromFrsMsgData ddU;

    public EditText getChatMsgView() {
        return this.ddQ;
    }

    public void I(String str, boolean z) {
        if (this.ddR != null) {
            this.ddR.startLoad(str, 15, false);
        }
    }

    public e(Context context) {
        super(context);
        this.context = context;
        bt(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.ddR.setPageId(bdUniqueId);
    }

    private void bt(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_share_card_view, this);
        setOrientation(1);
        this.aMt = (LinearLayout) findViewById(d.g.share_content);
        this.aWS = (TextView) findViewById(d.g.frs_card_name);
        this.ddQ = (EditText) findViewById(d.g.chat_msg);
        this.ddR = (HeadImageView) findViewById(d.g.frs_card_img);
        this.ddT = (TextView) findViewById(d.g.frs_card_member_num);
        this.ddS = (TextView) findViewById(d.g.frs_card_post_num);
        aj.c(this.aWS, d.C0096d.cp_cont_b, 1);
        aj.c(this.ddQ, d.C0096d.cp_cont_b, 2);
        this.ddQ.setHintTextColor(aj.getColor(d.C0096d.cp_cont_e));
        this.ddQ.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        arn();
    }

    public void arn() {
        this.aMt.setFocusable(true);
        this.aMt.setFocusableInTouchMode(true);
        this.aMt.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ddQ != null) {
            return k.a(this.ddQ.getText(), null);
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
        this.ddU = shareFromFrsMsgData;
        wp();
    }

    private void wp() {
        this.aWS.setText(dZ(this.ddU.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.ddU.getImageUrl());
        this.ddR.startLoad(this.ddU.getImageUrl(), 15, false);
        this.ddT.setText(am.y(this.ddU.getMemberNum()));
        this.ddS.setText(am.y(this.ddU.getPostNum()));
    }

    private String dZ(String str) {
        return am.j(str, 18) + this.context.getString(d.j.forum);
    }
}
