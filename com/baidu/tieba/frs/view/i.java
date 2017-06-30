package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class i extends LinearLayout {
    private LinearLayout aJF;
    private Context context;
    private EditText crG;
    private HeadImageView crH;
    private TextView crI;
    private TextView crJ;
    private ShareFromFrsMsgData crK;
    private TextView name;

    public EditText getChatMsgView() {
        return this.crG;
    }

    public void I(String str, boolean z) {
        if (this.crH != null) {
            this.crH.c(str, 15, false);
        }
    }

    public i(Context context) {
        super(context);
        this.context = context;
        bj(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.crH.setPageId(bdUniqueId);
    }

    private void bj(Context context) {
        LayoutInflater.from(context).inflate(w.j.frs_share_card_view, this);
        setOrientation(1);
        this.aJF = (LinearLayout) findViewById(w.h.share_content);
        this.name = (TextView) findViewById(w.h.frs_card_name);
        this.crG = (EditText) findViewById(w.h.chat_msg);
        this.crH = (HeadImageView) findViewById(w.h.frs_card_img);
        this.crJ = (TextView) findViewById(w.h.frs_card_member_num);
        this.crI = (TextView) findViewById(w.h.frs_card_post_num);
        as.c(this.name, w.e.cp_cont_b, 1);
        as.c(this.crG, w.e.cp_cont_b, 2);
        this.crG.setHintTextColor(as.getColor(w.e.cp_cont_e));
        this.crG.setPadding(context.getResources().getDimensionPixelSize(w.f.ds20), 0, 0, 0);
        aia();
    }

    public void aia() {
        this.aJF.setFocusable(true);
        this.aJF.setFocusableInTouchMode(true);
        this.aJF.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.crG != null) {
            return com.baidu.adp.lib.util.j.a(this.crG.getText(), null);
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -2);
    }

    public void setData(ShareFromFrsMsgData shareFromFrsMsgData) {
        this.crK = shareFromFrsMsgData;
        ww();
    }

    private void ww() {
        this.name.setText(dU(this.crK.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.crK.getImageUrl());
        this.crH.c(this.crK.getImageUrl(), 15, false);
        this.crJ.setText(aw.y(this.crK.getMemberNum()));
        this.crI.setText(aw.y(this.crK.getPostNum()));
    }

    private String dU(String str) {
        return String.valueOf(aw.j(str, 18)) + this.context.getString(w.l.forum);
    }
}
