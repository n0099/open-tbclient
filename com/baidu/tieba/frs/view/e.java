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
    private LinearLayout aMw;
    private TextView aWW;
    private Context context;
    private EditText ddU;
    private HeadImageView ddV;
    private TextView ddW;
    private TextView ddX;
    private ShareFromFrsMsgData ddY;

    public EditText getChatMsgView() {
        return this.ddU;
    }

    public void I(String str, boolean z) {
        if (this.ddV != null) {
            this.ddV.startLoad(str, 15, false);
        }
    }

    public e(Context context) {
        super(context);
        this.context = context;
        bt(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.ddV.setPageId(bdUniqueId);
    }

    private void bt(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_share_card_view, this);
        setOrientation(1);
        this.aMw = (LinearLayout) findViewById(d.g.share_content);
        this.aWW = (TextView) findViewById(d.g.frs_card_name);
        this.ddU = (EditText) findViewById(d.g.chat_msg);
        this.ddV = (HeadImageView) findViewById(d.g.frs_card_img);
        this.ddX = (TextView) findViewById(d.g.frs_card_member_num);
        this.ddW = (TextView) findViewById(d.g.frs_card_post_num);
        aj.c(this.aWW, d.C0095d.cp_cont_b, 1);
        aj.c(this.ddU, d.C0095d.cp_cont_b, 2);
        this.ddU.setHintTextColor(aj.getColor(d.C0095d.cp_cont_e));
        this.ddU.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        arn();
    }

    public void arn() {
        this.aMw.setFocusable(true);
        this.aMw.setFocusableInTouchMode(true);
        this.aMw.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ddU != null) {
            return k.a(this.ddU.getText(), null);
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
        this.ddY = shareFromFrsMsgData;
        wp();
    }

    private void wp() {
        this.aWW.setText(dZ(this.ddY.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.ddY.getImageUrl());
        this.ddV.startLoad(this.ddY.getImageUrl(), 15, false);
        this.ddX.setText(am.y(this.ddY.getMemberNum()));
        this.ddW.setText(am.y(this.ddY.getPostNum()));
    }

    private String dZ(String str) {
        return am.j(str, 18) + this.context.getString(d.j.forum);
    }
}
