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
    private LinearLayout aMV;
    private TextView bmc;
    private Context context;
    private EditText duU;
    private HeadImageView duV;
    private TextView duW;
    private TextView duX;
    private ShareFromFrsMsgData duY;

    public EditText getChatMsgView() {
        return this.duU;
    }

    public void D(String str, boolean z) {
        if (this.duV != null) {
            this.duV.startLoad(str, 15, false);
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
        this.duV.setPageId(bdUniqueId);
    }

    private void bo(Context context) {
        LayoutInflater.from(context).inflate(d.i.frs_share_card_view, this);
        setOrientation(1);
        this.aMV = (LinearLayout) findViewById(d.g.share_content);
        this.bmc = (TextView) findViewById(d.g.frs_card_name);
        this.duU = (EditText) findViewById(d.g.chat_msg);
        this.duV = (HeadImageView) findViewById(d.g.frs_card_img);
        this.duX = (TextView) findViewById(d.g.frs_card_member_num);
        this.duW = (TextView) findViewById(d.g.frs_card_post_num);
        ak.c(this.bmc, d.C0126d.cp_cont_b, 1);
        ak.c(this.duU, d.C0126d.cp_cont_b, 2);
        this.duU.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        this.duU.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        avP();
    }

    public void avP() {
        this.aMV.setFocusable(true);
        this.aMV.setFocusableInTouchMode(true);
        this.aMV.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.duU != null) {
            return k.a(this.duU.getText(), null);
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
        this.duY = shareFromFrsMsgData;
        wK();
    }

    private void wK() {
        this.bmc.setText(eo(this.duY.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.duY.getImageUrl());
        this.duV.startLoad(this.duY.getImageUrl(), 15, false);
        this.duX.setText(an.z(this.duY.getMemberNum()));
        this.duW.setText(an.z(this.duY.getPostNum()));
    }

    private String eo(String str) {
        return an.j(str, 18) + this.context.getString(d.k.forum);
    }
}
