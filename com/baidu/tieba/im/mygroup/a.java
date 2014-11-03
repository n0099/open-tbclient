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
    private ShareFromGameCenterMsgData bfA;
    private EditText bfv;
    private BarImageView bfw;
    private BarImageView bfx;
    private TextView bfy;
    protected TextView bfz;

    public EditText getChatMsgView() {
        return this.bfv;
    }

    public a(Context context) {
        super(context);
        ad(context);
    }

    private void ad(Context context) {
        com.baidu.adp.lib.g.b.ek().inflate(context, w.game_to_group_share_dialog, this);
        setOrientation(1);
        this.bfv = (EditText) findViewById(v.game_to_group_share_chat_msg);
        this.bfw = (BarImageView) findViewById(v.game_to_group_share_img);
        this.bfx = (BarImageView) findViewById(v.game_to_group_share_icon);
        this.bfy = (TextView) findViewById(v.game_to_group_share_desc);
        aw.h((View) this.bfv, u.inputbox_share);
        aw.b(this.bfv, com.baidu.tieba.s.cp_cont_b, 2);
        this.bfv.setHintTextColor(aw.getColor(com.baidu.tieba.s.cp_cont_e));
        aw.b(this.bfy, com.baidu.tieba.s.cp_cont_f, 1);
        this.bfv.setPadding(context.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds20), 0, 0, 0);
        this.bfz = (TextView) findViewById(v.game_to_group_share);
        aw.b(this.bfz, com.baidu.tieba.s.cp_cont_c, 1);
    }

    public String getLeaveMsg() {
        if (this.bfv != null) {
            return com.baidu.adp.lib.util.l.a(this.bfv.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.bfA = shareFromGameCenterMsgData;
        nx();
    }

    private void nx() {
        this.bfw.setTag(this.bfA.getImageUrl());
        this.bfw.c(this.bfA.getImageUrl(), 17, false);
        this.bfx.setTag(this.bfA.getShareSourceIcon());
        this.bfx.c(this.bfA.getShareSourceIcon(), 17, false);
        this.bfy.setText(this.bfA.getContent());
        this.bfz.setText("来自" + this.bfA.getShareSource());
    }
}
