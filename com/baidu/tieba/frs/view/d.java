package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private LinearLayout aKN;
    private Context context;
    private EditText cyP;
    private HeadImageView cyQ;
    private TextView cyR;
    private TextView cyS;
    private ShareFromFrsMsgData cyT;
    private TextView name;

    public EditText getChatMsgView() {
        return this.cyP;
    }

    public void K(String str, boolean z) {
        if (this.cyQ != null) {
            this.cyQ.c(str, 15, false);
        }
    }

    public d(Context context) {
        super(context);
        this.context = context;
        bk(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cyQ.setPageId(bdUniqueId);
    }

    private void bk(Context context) {
        LayoutInflater.from(context).inflate(d.j.frs_share_card_view, this);
        setOrientation(1);
        this.aKN = (LinearLayout) findViewById(d.h.share_content);
        this.name = (TextView) findViewById(d.h.frs_card_name);
        this.cyP = (EditText) findViewById(d.h.chat_msg);
        this.cyQ = (HeadImageView) findViewById(d.h.frs_card_img);
        this.cyS = (TextView) findViewById(d.h.frs_card_member_num);
        this.cyR = (TextView) findViewById(d.h.frs_card_post_num);
        ai.c(this.name, d.e.cp_cont_b, 1);
        ai.c(this.cyP, d.e.cp_cont_b, 2);
        this.cyP.setHintTextColor(ai.getColor(d.e.cp_cont_e));
        this.cyP.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        ajD();
    }

    public void ajD() {
        this.aKN.setFocusable(true);
        this.aKN.setFocusableInTouchMode(true);
        this.aKN.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cyP != null) {
            return j.a(this.cyP.getText(), null);
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
        this.cyT = shareFromFrsMsgData;
        wG();
    }

    private void wG() {
        this.name.setText(dX(this.cyT.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.cyT.getImageUrl());
        this.cyQ.c(this.cyT.getImageUrl(), 15, false);
        this.cyS.setText(al.z(this.cyT.getMemberNum()));
        this.cyR.setText(al.z(this.cyT.getPostNum()));
    }

    private String dX(String str) {
        return al.j(str, 18) + this.context.getString(d.l.forum);
    }
}
