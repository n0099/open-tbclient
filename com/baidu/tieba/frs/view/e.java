package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e extends LinearLayout {
    private LinearLayout bCu;
    private TextView bMV;
    private Context context;
    private EditText dZg;
    private HeadImageView dZh;
    private TextView dZi;
    private TextView dZj;
    private ShareFromFrsMsgData dZk;

    public EditText getChatMsgView() {
        return this.dZg;
    }

    public void G(String str, boolean z) {
        if (this.dZh != null) {
            this.dZh.startLoad(str, 15, false);
        }
    }

    public e(Context context) {
        super(context);
        this.context = context;
        bA(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dZh.setPageId(bdUniqueId);
    }

    private void bA(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_share_card_view, this);
        setOrientation(1);
        this.bCu = (LinearLayout) findViewById(d.g.share_content);
        this.bMV = (TextView) findViewById(d.g.frs_card_name);
        this.dZg = (EditText) findViewById(d.g.chat_msg);
        this.dZh = (HeadImageView) findViewById(d.g.frs_card_img);
        this.dZj = (TextView) findViewById(d.g.frs_card_member_num);
        this.dZi = (TextView) findViewById(d.g.frs_card_post_num);
        aj.e(this.bMV, d.C0141d.cp_cont_b, 1);
        aj.e(this.dZg, d.C0141d.cp_cont_b, 2);
        this.dZg.setHintTextColor(aj.getColor(d.C0141d.cp_cont_e));
        this.dZg.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        aAV();
    }

    public void aAV() {
        this.bCu.setFocusable(true);
        this.bCu.setFocusableInTouchMode(true);
        this.bCu.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dZg != null) {
            return k.a(this.dZg.getText(), null);
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
        this.dZk = shareFromFrsMsgData;
        Ea();
    }

    private void Ea() {
        this.bMV.setText(ew(this.dZk.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.dZk.getImageUrl());
        this.dZh.startLoad(this.dZk.getImageUrl(), 15, false);
        this.dZj.setText(am.H(this.dZk.getMemberNum()));
        this.dZi.setText(am.H(this.dZk.getPostNum()));
    }

    private String ew(String str) {
        return am.k(str, 18) + this.context.getString(d.j.forum);
    }
}
