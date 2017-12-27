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
    private LinearLayout bAj;
    private TextView bKL;
    private Context context;
    private EditText dQe;
    private HeadImageView dQf;
    private TextView dQg;
    private TextView dQh;
    private ShareFromFrsMsgData dQi;

    public EditText getChatMsgView() {
        return this.dQe;
    }

    public void J(String str, boolean z) {
        if (this.dQf != null) {
            this.dQf.startLoad(str, 15, false);
        }
    }

    public e(Context context) {
        super(context);
        this.context = context;
        bE(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dQf.setPageId(bdUniqueId);
    }

    private void bE(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_share_card_view, this);
        setOrientation(1);
        this.bAj = (LinearLayout) findViewById(d.g.share_content);
        this.bKL = (TextView) findViewById(d.g.frs_card_name);
        this.dQe = (EditText) findViewById(d.g.chat_msg);
        this.dQf = (HeadImageView) findViewById(d.g.frs_card_img);
        this.dQh = (TextView) findViewById(d.g.frs_card_member_num);
        this.dQg = (TextView) findViewById(d.g.frs_card_post_num);
        aj.e(this.bKL, d.C0108d.cp_cont_b, 1);
        aj.e(this.dQe, d.C0108d.cp_cont_b, 2);
        this.dQe.setHintTextColor(aj.getColor(d.C0108d.cp_cont_e));
        this.dQe.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        ayt();
    }

    public void ayt() {
        this.bAj.setFocusable(true);
        this.bAj.setFocusableInTouchMode(true);
        this.bAj.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dQe != null) {
            return k.a(this.dQe.getText(), null);
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
        this.dQi = shareFromFrsMsgData;
        DN();
    }

    private void DN() {
        this.bKL.setText(eg(this.dQi.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.dQi.getImageUrl());
        this.dQf.startLoad(this.dQi.getImageUrl(), 15, false);
        this.dQh.setText(am.G(this.dQi.getMemberNum()));
        this.dQg.setText(am.G(this.dQi.getPostNum()));
    }

    private String eg(String str) {
        return am.k(str, 18) + this.context.getString(d.j.forum);
    }
}
