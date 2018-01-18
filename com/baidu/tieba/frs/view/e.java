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
/* loaded from: classes2.dex */
public class e extends LinearLayout {
    private LinearLayout bAs;
    private TextView bKT;
    private Context context;
    private EditText dUS;
    private HeadImageView dUT;
    private TextView dUU;
    private TextView dUV;
    private ShareFromFrsMsgData dUW;

    public EditText getChatMsgView() {
        return this.dUS;
    }

    public void J(String str, boolean z) {
        if (this.dUT != null) {
            this.dUT.startLoad(str, 15, false);
        }
    }

    public e(Context context) {
        super(context);
        this.context = context;
        bE(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dUT.setPageId(bdUniqueId);
    }

    private void bE(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_share_card_view, this);
        setOrientation(1);
        this.bAs = (LinearLayout) findViewById(d.g.share_content);
        this.bKT = (TextView) findViewById(d.g.frs_card_name);
        this.dUS = (EditText) findViewById(d.g.chat_msg);
        this.dUT = (HeadImageView) findViewById(d.g.frs_card_img);
        this.dUV = (TextView) findViewById(d.g.frs_card_member_num);
        this.dUU = (TextView) findViewById(d.g.frs_card_post_num);
        aj.e(this.bKT, d.C0107d.cp_cont_b, 1);
        aj.e(this.dUS, d.C0107d.cp_cont_b, 2);
        this.dUS.setHintTextColor(aj.getColor(d.C0107d.cp_cont_e));
        this.dUS.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        azy();
    }

    public void azy() {
        this.bAs.setFocusable(true);
        this.bAs.setFocusableInTouchMode(true);
        this.bAs.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dUS != null) {
            return k.a(this.dUS.getText(), null);
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
        this.dUW = shareFromFrsMsgData;
        DE();
    }

    private void DE() {
        this.bKT.setText(eg(this.dUW.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.dUW.getImageUrl());
        this.dUT.startLoad(this.dUW.getImageUrl(), 15, false);
        this.dUV.setText(am.H(this.dUW.getMemberNum()));
        this.dUU.setText(am.H(this.dUW.getPostNum()));
    }

    private String eg(String str) {
        return am.k(str, 18) + this.context.getString(d.j.forum);
    }
}
