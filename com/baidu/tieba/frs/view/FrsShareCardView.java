package com.baidu.tieba.frs.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class FrsShareCardView extends LinearLayout {
    private LinearLayout bFu;
    private Context context;
    private TextView dfo;
    private HeadImageView fAa;
    private TextView fAb;
    private TextView fAc;
    private ShareFromFrsMsgData fAd;
    private EditText fzZ;

    public EditText getChatMsgView() {
        return this.fzZ;
    }

    public void ag(String str, boolean z) {
        if (this.fAa != null) {
            this.fAa.startLoad(str, 15, false);
        }
    }

    public FrsShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        aX(context);
    }

    public FrsShareCardView(Context context) {
        super(context);
        this.context = context;
        aX(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.fAa.setPageId(bdUniqueId);
    }

    private void aX(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_share_card_view, this);
        setOrientation(1);
        this.bFu = (LinearLayout) findViewById(d.g.share_content);
        this.dfo = (TextView) findViewById(d.g.frs_card_name);
        this.fzZ = (EditText) findViewById(d.g.chat_msg);
        this.fAa = (HeadImageView) findViewById(d.g.frs_card_img);
        this.fAc = (TextView) findViewById(d.g.frs_card_member_num);
        this.fAb = (TextView) findViewById(d.g.frs_card_post_num);
        al.d(this.dfo, d.C0236d.cp_cont_b, 1);
        al.d(this.fzZ, d.C0236d.cp_cont_b, 2);
        this.fzZ.setHintTextColor(al.getColor(d.C0236d.cp_cont_e));
        this.fzZ.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        bki();
    }

    public void bki() {
        this.bFu.setFocusable(true);
        this.bFu.setFocusableInTouchMode(true);
        this.bFu.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fzZ != null) {
            return k.a(this.fzZ.getText(), null);
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
        this.fAd = shareFromFrsMsgData;
        GR();
    }

    private void GR() {
        this.dfo.setText(mM(this.fAd.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.fAd.getImageUrl());
        this.fAa.startLoad(this.fAd.getImageUrl(), 15, false);
        this.fAc.setText(ap.ax(this.fAd.getMemberNum()));
        this.fAb.setText(ap.ax(this.fAd.getPostNum()));
    }

    private String mM(String str) {
        return ap.o(str, 18) + this.context.getString(d.j.forum);
    }
}
