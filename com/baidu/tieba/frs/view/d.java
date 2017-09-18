package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private LinearLayout aLH;
    private EditText cJr;
    private HeadImageView cJs;
    private TextView cJt;
    private TextView cJu;
    private ShareFromFrsMsgData cJv;
    private Context context;
    private TextView name;

    public EditText getChatMsgView() {
        return this.cJr;
    }

    public void L(String str, boolean z) {
        if (this.cJs != null) {
            this.cJs.c(str, 15, false);
        }
    }

    public d(Context context) {
        super(context);
        this.context = context;
        bt(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cJs.setPageId(bdUniqueId);
    }

    private void bt(Context context) {
        LayoutInflater.from(context).inflate(d.j.frs_share_card_view, this);
        setOrientation(1);
        this.aLH = (LinearLayout) findViewById(d.h.share_content);
        this.name = (TextView) findViewById(d.h.frs_card_name);
        this.cJr = (EditText) findViewById(d.h.chat_msg);
        this.cJs = (HeadImageView) findViewById(d.h.frs_card_img);
        this.cJu = (TextView) findViewById(d.h.frs_card_member_num);
        this.cJt = (TextView) findViewById(d.h.frs_card_post_num);
        aj.c(this.name, d.e.cp_cont_b, 1);
        aj.c(this.cJr, d.e.cp_cont_b, 2);
        this.cJr.setHintTextColor(aj.getColor(d.e.cp_cont_e));
        this.cJr.setPadding(context.getResources().getDimensionPixelSize(d.f.ds20), 0, 0, 0);
        amj();
    }

    public void amj() {
        this.aLH.setFocusable(true);
        this.aLH.setFocusableInTouchMode(true);
        this.aLH.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cJr != null) {
            return j.a(this.cJr.getText(), null);
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
        this.cJv = shareFromFrsMsgData;
        wO();
    }

    private void wO() {
        this.name.setText(dZ(this.cJv.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.cJv.getImageUrl());
        this.cJs.c(this.cJv.getImageUrl(), 15, false);
        this.cJu.setText(am.y(this.cJv.getMemberNum()));
        this.cJt.setText(am.y(this.cJv.getPostNum()));
    }

    private String dZ(String str) {
        return am.j(str, 18) + this.context.getString(d.l.forum);
    }
}
