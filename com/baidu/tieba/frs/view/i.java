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
    private LinearLayout ame;
    private EditText cjG;
    private HeadImageView cjH;
    private TextView cjI;
    private TextView cjJ;
    private ShareFromFrsMsgData cjK;
    private Context context;
    private TextView name;

    public EditText getChatMsgView() {
        return this.cjG;
    }

    public void D(String str, boolean z) {
        if (this.cjH != null) {
            this.cjH.c(str, 15, false);
        }
    }

    public i(Context context) {
        super(context);
        this.context = context;
        bp(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.cjH.setPageId(bdUniqueId);
    }

    private void bp(Context context) {
        LayoutInflater.from(context).inflate(w.j.frs_share_card_view, this);
        setOrientation(1);
        this.ame = (LinearLayout) findViewById(w.h.share_content);
        this.name = (TextView) findViewById(w.h.frs_card_name);
        this.cjG = (EditText) findViewById(w.h.chat_msg);
        this.cjH = (HeadImageView) findViewById(w.h.frs_card_img);
        this.cjJ = (TextView) findViewById(w.h.frs_card_member_num);
        this.cjI = (TextView) findViewById(w.h.frs_card_post_num);
        aq.c(this.name, w.e.cp_cont_b, 1);
        aq.c(this.cjG, w.e.cp_cont_b, 2);
        this.cjG.setHintTextColor(aq.getColor(w.e.cp_cont_e));
        this.cjG.setPadding(context.getResources().getDimensionPixelSize(w.f.ds20), 0, 0, 0);
        aem();
    }

    public void aem() {
        this.ame.setFocusable(true);
        this.ame.setFocusableInTouchMode(true);
        this.ame.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.cjG != null) {
            return com.baidu.adp.lib.util.j.a(this.cjG.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.cjK = shareFromFrsMsgData;
        we();
    }

    private void we() {
        this.name.setText(dA(this.cjK.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.cjK.getImageUrl());
        this.cjH.c(this.cjK.getImageUrl(), 15, false);
        this.cjJ.setText(au.x(this.cjK.getMemberNum()));
        this.cjI.setText(au.x(this.cjK.getPostNum()));
    }

    private String dA(String str) {
        return String.valueOf(au.j(str, 18)) + this.context.getString(w.l.forum);
    }
}
