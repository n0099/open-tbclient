package com.baidu.tieba.frs.acrossForum;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ac extends LinearLayout {
    private LinearLayout aEC;
    private TextView aKM;
    private EditText bXp;
    private TbImageView bXq;
    private TextView title;

    public EditText getChatMsgView() {
        return this.bXp;
    }

    public void F(String str, boolean z) {
        if (this.bXq != null) {
            this.bXq.c(str, z ? 17 : 18, false);
        }
    }

    public ac(Context context) {
        super(context);
        aO(context);
    }

    private void aO(Context context) {
        LayoutInflater.from(context).inflate(r.h.thread_to_group_share_view, this);
        setOrientation(1);
        this.aEC = (LinearLayout) findViewById(r.g.share_content);
        this.title = (TextView) findViewById(r.g.share_title_view);
        this.bXp = (EditText) findViewById(r.g.chat_msg);
        this.bXq = (TbImageView) findViewById(r.g.chat_group_img);
        this.aKM = (TextView) findViewById(r.g.chat_group_desc);
        at.c(this.title, r.d.cp_cont_b, 1);
        at.c(this.bXp, r.d.cp_cont_b, 2);
        at.c(this.aKM, r.d.cp_cont_f, 1);
        this.bXp.setHintTextColor(at.getColor(r.d.cp_cont_e));
        this.bXp.setPadding(context.getResources().getDimensionPixelSize(r.e.ds20), 0, 0, 0);
        adV();
    }

    public void adV() {
        this.aEC.setFocusable(true);
        this.aEC.setFocusableInTouchMode(true);
        this.aEC.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.bXp != null) {
            return com.baidu.adp.lib.util.j.a(this.bXp.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromPBMsgData shareFromPBMsgData) {
        if (shareFromPBMsgData != null) {
            this.title.setText(shareFromPBMsgData.getTitle());
            this.bXq.setTag(shareFromPBMsgData.getImageUrl());
            this.aKM.setText(shareFromPBMsgData.getContent());
        }
    }
}
