package com.baidu.tieba.im.mygroup;

import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    protected TextView a;
    private EditText b;
    private BarImageView c;
    private TextView d;
    private ShareFromGameCenterMsgData e;

    public EditText getChatMsgView() {
        return this.b;
    }

    public a(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        com.baidu.adp.lib.e.b.a().a(context, com.baidu.tieba.v.game_to_group_share_dialog, this);
        setOrientation(1);
        this.b = (EditText) findViewById(com.baidu.tieba.u.game_to_group_share_chat_msg);
        this.c = (BarImageView) findViewById(com.baidu.tieba.u.game_to_group_share_img);
        this.d = (TextView) findViewById(com.baidu.tieba.u.game_to_group_share_desc);
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.b.setBackgroundResource(com.baidu.tieba.t.inputbox_share_1);
            this.b.setTextColor(context.getResources().getColor(com.baidu.tieba.r.cp_cont_b_1));
            this.d.setTextColor(context.getResources().getColor(com.baidu.tieba.r.dialog_bdalert_title_1));
        } else {
            this.b.setBackgroundResource(com.baidu.tieba.t.inputbox_share);
            this.b.setTextColor(context.getResources().getColor(com.baidu.tieba.r.cp_cont_b));
            this.d.setTextColor(context.getResources().getColor(com.baidu.tieba.r.dialog_bdalert_title));
        }
        this.b.setPadding(context.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds20), 0, 0, 0);
        this.a = (TextView) findViewById(com.baidu.tieba.u.game_to_group_share);
    }

    public String getLeaveMsg() {
        if (this.b != null) {
            return com.baidu.adp.lib.util.i.a(this.b.getText(), (String) null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromGameCenterMsgData shareFromGameCenterMsgData) {
        this.e = shareFromGameCenterMsgData;
        a();
    }

    private void a() {
        BdLog.e("mData.getImageUrl()的图片URL" + this.e.getShareSourceIcon());
        this.c.setTag(this.e.getShareSourceIcon());
        this.c.a(this.e.getShareSourceIcon(), 17, false);
        BdLog.e("mData.getContent()的Content" + this.e.getContent());
        this.d.setText(this.e.getContent());
        this.a.setText("来自" + this.e.getShareSource());
    }
}
