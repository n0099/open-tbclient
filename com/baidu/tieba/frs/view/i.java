package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class i extends LinearLayout {
    private LinearLayout amo;
    private EditText cds;
    private HeadImageView cdt;
    private TextView cdu;
    private TextView cdv;
    private ShareFromFrsMsgData cdw;
    private Context context;
    private TextView name;

    public EditText getChatMsgView() {
        return this.cds;
    }

    public void G(String str, boolean z) {
        if (this.cdt != null) {
            this.cdt.c(str, 15, false);
        }
    }

    public i(Context context) {
        super(context);
        this.context = context;
        bp(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cdt.setPageId(bdUniqueId);
    }

    private void bp(Context context) {
        LayoutInflater.from(context).inflate(w.j.frs_share_card_view, this);
        setOrientation(1);
        this.amo = (LinearLayout) findViewById(w.h.share_content);
        this.name = (TextView) findViewById(w.h.frs_card_name);
        this.cds = (EditText) findViewById(w.h.chat_msg);
        this.cdt = (HeadImageView) findViewById(w.h.frs_card_img);
        this.cdv = (TextView) findViewById(w.h.frs_card_member_num);
        this.cdu = (TextView) findViewById(w.h.frs_card_post_num);
        aq.c(this.name, w.e.cp_cont_b, 1);
        aq.c(this.cds, w.e.cp_cont_b, 2);
        this.cds.setHintTextColor(aq.getColor(w.e.cp_cont_e));
        this.cds.setPadding(context.getResources().getDimensionPixelSize(w.f.ds20), 0, 0, 0);
        adj();
    }

    public void adj() {
        this.amo.setFocusable(true);
        this.amo.setFocusableInTouchMode(true);
        this.amo.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cds != null) {
            return com.baidu.adp.lib.util.j.a(this.cds.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cdw = shareFromFrsMsgData;
        wh();
    }

    private void wh() {
        this.name.setText(dD(this.cdw.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.cdw.getImageUrl());
        this.cdt.c(this.cdw.getImageUrl(), 15, false);
        this.cdv.setText(au.x(this.cdw.getMemberNum()));
        this.cdu.setText(au.x(this.cdw.getPostNum()));
    }

    private String dD(String str) {
        return String.valueOf(au.j(str, 18)) + this.context.getString(w.l.forum);
    }
}
