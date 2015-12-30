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
    private TextView aGr;
    private EditText boI;
    private HeadImageView boJ;
    private TextView boK;
    private TextView boL;
    private ShareFromFrsMsgData boM;
    private Context context;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.boI;
    }

    public void x(String str, boolean z) {
        if (this.boJ != null) {
            this.boJ.d(str, 15, false);
        }
    }

    public p(Context context) {
        super(context);
        this.context = context;
        as(context);
    }

    private void as(Context context) {
        LayoutInflater.from(context).inflate(n.h.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(n.g.share_content);
        this.aGr = (TextView) findViewById(n.g.frs_card_name);
        this.boI = (EditText) findViewById(n.g.chat_msg);
        this.boJ = (HeadImageView) findViewById(n.g.frs_card_img);
        this.boL = (TextView) findViewById(n.g.frs_card_member_num);
        this.boK = (TextView) findViewById(n.g.frs_card_post_num);
        as.b(this.aGr, n.d.cp_cont_b, 1);
        as.b(this.boI, n.d.cp_cont_b, 2);
        this.boI.setHintTextColor(as.getColor(n.d.cp_cont_e));
        this.boI.setPadding(context.getResources().getDimensionPixelSize(n.e.ds20), 0, 0, 0);
        Qt();
    }

    public void Qt() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.boI != null) {
            return com.baidu.adp.lib.util.j.a(this.boI.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.boM = shareFromFrsMsgData;
        vN();
    }

    private void vN() {
        this.aGr.setText(dD(this.boM.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.boM.getImageUrl());
        this.boJ.d(this.boM.getImageUrl(), 15, false);
        this.boL.setText(ax.x(this.boM.getMemberNum()));
        this.boK.setText(ax.x(this.boM.getPostNum()));
    }

    private String dD(String str) {
        return String.valueOf(ax.i(str, 18)) + this.context.getString(n.j.forum);
    }
}
