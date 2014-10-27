package com.baidu.tieba.im.mygroup;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private EditText bfh;
    private BarImageView bfi;
    private BarImageView bfj;
    private TextView bfk;
    protected TextView bfl;
    private ShareFromGameCenterMsgData bfm;

    public EditText getChatMsgView() {
        return this.bfh;
    }

    public a(Context context) {
        super(context);
        ad(context);
    }

    private void ad(Context context) {
        com.baidu.adp.lib.g.b.ek().inflate(context, w.game_to_group_share_dialog, this);
        setOrientation(1);
        this.bfh = (EditText) findViewById(v.game_to_group_share_chat_msg);
        this.bfi = (BarImageView) findViewById(v.game_to_group_share_img);
        this.bfj = (BarImageView) findViewById(v.game_to_group_share_icon);
        this.bfk = (TextView) findViewById(v.game_to_group_share_desc);
        aw.h((View) this.bfh, u.inputbox_share);
        aw.b(this.bfh, com.baidu.tieba.s.cp_cont_b, 2);
        this.bfh.setHintTextColor(aw.getColor(com.baidu.tieba.s.cp_cont_e));
        aw.b(this.bfk, com.baidu.tieba.s.cp_cont_f, 1);
        this.bfh.setPadding(context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds20), 0, 0, 0);
        this.bfl = (TextView) findViewById(v.game_to_group_share);
        aw.b(this.bfl, com.baidu.tieba.s.cp_cont_c, 1);
    }

    public String getLeaveMsg() {
        if (this.bfh != null) {
            return com.baidu.adp.lib.util.l.a(this.bfh.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.bfm = shareFromGameCenterMsgData;
        nx();
    }

    private void nx() {
        this.bfi.setTag(this.bfm.getImageUrl());
        this.bfi.c(this.bfm.getImageUrl(), 17, false);
        this.bfj.setTag(this.bfm.getShareSourceIcon());
        this.bfj.c(this.bfm.getShareSourceIcon(), 17, false);
        this.bfk.setText(this.bfm.getContent());
        this.bfl.setText("来自" + this.bfm.getShareSource());
    }
}
