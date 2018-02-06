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
    private LinearLayout bCE;
    private TextView bNf;
    private Context context;
    private EditText dZb;
    private HeadImageView dZc;
    private TextView dZd;
    private TextView dZe;
    private ShareFromFrsMsgData dZf;

    public EditText getChatMsgView() {
        return this.dZb;
    }

    public void H(String str, boolean z) {
        if (this.dZc != null) {
            this.dZc.startLoad(str, 15, false);
        }
    }

    public e(Context context) {
        super(context);
        this.context = context;
        bA(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dZc.setPageId(bdUniqueId);
    }

    private void bA(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_share_card_view, this);
        setOrientation(1);
        this.bCE = (LinearLayout) findViewById(d.g.share_content);
        this.bNf = (TextView) findViewById(d.g.frs_card_name);
        this.dZb = (EditText) findViewById(d.g.chat_msg);
        this.dZc = (HeadImageView) findViewById(d.g.frs_card_img);
        this.dZe = (TextView) findViewById(d.g.frs_card_member_num);
        this.dZd = (TextView) findViewById(d.g.frs_card_post_num);
        aj.e(this.bNf, d.C0140d.cp_cont_b, 1);
        aj.e(this.dZb, d.C0140d.cp_cont_b, 2);
        this.dZb.setHintTextColor(aj.getColor(d.C0140d.cp_cont_e));
        this.dZb.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        aAU();
    }

    public void aAU() {
        this.bCE.setFocusable(true);
        this.bCE.setFocusableInTouchMode(true);
        this.bCE.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dZb != null) {
            return k.a(this.dZb.getText(), null);
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
        this.dZf = shareFromFrsMsgData;
        Ea();
    }

    private void Ea() {
        this.bNf.setText(ew(this.dZf.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.dZf.getImageUrl());
        this.dZc.startLoad(this.dZf.getImageUrl(), 15, false);
        this.dZe.setText(am.H(this.dZf.getMemberNum()));
        this.dZd.setText(am.H(this.dZf.getPostNum()));
    }

    private String ew(String str) {
        return am.k(str, 18) + this.context.getString(d.j.forum);
    }
}
