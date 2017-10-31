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
public class d extends LinearLayout {
    private LinearLayout aLG;
    private TextView aTH;
    private EditText cTh;
    private HeadImageView cTi;
    private TextView cTj;
    private TextView cTk;
    private ShareFromFrsMsgData cTl;
    private Context context;

    public EditText getChatMsgView() {
        return this.cTh;
    }

    public void G(String str, boolean z) {
        if (this.cTi != null) {
            this.cTi.startLoad(str, 15, false);
        }
    }

    public d(Context context) {
        super(context);
        this.context = context;
        br(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cTi.setPageId(bdUniqueId);
    }

    private void br(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_share_card_view, this);
        setOrientation(1);
        this.aLG = (LinearLayout) findViewById(d.g.share_content);
        this.aTH = (TextView) findViewById(d.g.frs_card_name);
        this.cTh = (EditText) findViewById(d.g.chat_msg);
        this.cTi = (HeadImageView) findViewById(d.g.frs_card_img);
        this.cTk = (TextView) findViewById(d.g.frs_card_member_num);
        this.cTj = (TextView) findViewById(d.g.frs_card_post_num);
        aj.c(this.aTH, d.C0080d.cp_cont_b, 1);
        aj.c(this.cTh, d.C0080d.cp_cont_b, 2);
        this.cTh.setHintTextColor(aj.getColor(d.C0080d.cp_cont_e));
        this.cTh.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        aoT();
    }

    public void aoT() {
        this.aLG.setFocusable(true);
        this.aLG.setFocusableInTouchMode(true);
        this.aLG.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cTh != null) {
            return k.a(this.cTh.getText(), null);
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
        this.cTl = shareFromFrsMsgData;
        wn();
    }

    private void wn() {
        this.aTH.setText(dX(this.cTl.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.cTl.getImageUrl());
        this.cTi.startLoad(this.cTl.getImageUrl(), 15, false);
        this.cTk.setText(am.y(this.cTl.getMemberNum()));
        this.cTj.setText(am.y(this.cTl.getPostNum()));
    }

    private String dX(String str) {
        return am.j(str, 18) + this.context.getString(d.j.forum);
    }
}
