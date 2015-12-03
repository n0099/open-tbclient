package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class p extends LinearLayout {
    private TextView aER;
    private EditText bkR;
    private HeadImageView bkS;
    private TextView bkT;
    private TextView bkU;
    private ShareFromFrsMsgData bkV;
    private Context context;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.bkR;
    }

    public void x(String str, boolean z) {
        if (this.bkS != null) {
            this.bkS.d(str, 15, false);
        }
    }

    public p(Context context) {
        super(context);
        this.context = context;
        as(context);
    }

    private void as(Context context) {
        LayoutInflater.from(context).inflate(n.g.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(n.f.share_content);
        this.aER = (TextView) findViewById(n.f.frs_card_name);
        this.bkR = (EditText) findViewById(n.f.chat_msg);
        this.bkS = (HeadImageView) findViewById(n.f.frs_card_img);
        this.bkU = (TextView) findViewById(n.f.frs_card_member_num);
        this.bkT = (TextView) findViewById(n.f.frs_card_post_num);
        as.b(this.aER, n.c.cp_cont_b, 1);
        as.b(this.bkR, n.c.cp_cont_b, 2);
        this.bkR.setHintTextColor(as.getColor(n.c.cp_cont_e));
        this.bkR.setPadding(context.getResources().getDimensionPixelSize(n.d.ds20), 0, 0, 0);
        Qb();
    }

    public void Qb() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bkR != null) {
            return com.baidu.adp.lib.util.j.a(this.bkR.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.bkV = shareFromFrsMsgData;
        wd();
    }

    private void wd() {
        this.aER.setText(dA(this.bkV.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.bkV.getImageUrl());
        this.bkS.d(this.bkV.getImageUrl(), 15, false);
        this.bkU.setText(ax.w(this.bkV.getMemberNum()));
        this.bkT.setText(ax.w(this.bkV.getPostNum()));
    }

    private String dA(String str) {
        return String.valueOf(ax.i(str, 18)) + this.context.getString(n.i.forum);
    }
}
