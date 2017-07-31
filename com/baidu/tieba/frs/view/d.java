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
    private LinearLayout aMc;
    private EditText cAj;
    private HeadImageView cAk;
    private TextView cAl;
    private TextView cAm;
    private ShareFromFrsMsgData cAn;
    private Context context;
    private TextView name;

    public EditText getChatMsgView() {
        return this.cAj;
    }

    public void J(String str, boolean z) {
        if (this.cAk != null) {
            this.cAk.c(str, 15, false);
        }
    }

    public d(Context context) {
        super(context);
        this.context = context;
        bk(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cAk.setPageId(bdUniqueId);
    }

    private void bk(Context context) {
        LayoutInflater.from(context).inflate(d.j.frs_share_card_view, this);
        setOrientation(1);
        this.aMc = (LinearLayout) findViewById(d.h.share_content);
        this.name = (TextView) findViewById(d.h.frs_card_name);
        this.cAj = (EditText) findViewById(d.h.chat_msg);
        this.cAk = (HeadImageView) findViewById(d.h.frs_card_img);
        this.cAm = (TextView) findViewById(d.h.frs_card_member_num);
        this.cAl = (TextView) findViewById(d.h.frs_card_post_num);
        ai.c(this.name, d.e.cp_cont_b, 1);
        ai.c(this.cAj, d.e.cp_cont_b, 2);
        this.cAj.setHintTextColor(ai.getColor(d.e.cp_cont_e));
        this.cAj.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        ajQ();
    }

    public void ajQ() {
        this.aMc.setFocusable(true);
        this.aMc.setFocusableInTouchMode(true);
        this.aMc.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cAj != null) {
            return j.a(this.cAj.getText(), null);
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
        this.cAn = shareFromFrsMsgData;
        wP();
    }

    private void wP() {
        this.name.setText(ed(this.cAn.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.cAn.getImageUrl());
        this.cAk.c(this.cAn.getImageUrl(), 15, false);
        this.cAm.setText(al.z(this.cAn.getMemberNum()));
        this.cAl.setText(al.z(this.cAn.getPostNum()));
    }

    private String ed(String str) {
        return al.j(str, 18) + this.context.getString(d.l.forum);
    }
}
