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
    private LinearLayout bFw;
    private Context context;
    private TextView dfk;
    private TextView fAa;
    private TextView fAb;
    private ShareFromFrsMsgData fAc;
    private EditText fzY;
    private HeadImageView fzZ;

    public EditText getChatMsgView() {
        return this.fzY;
    }

    public void ag(String str, boolean z) {
        if (this.fzZ != null) {
            this.fzZ.startLoad(str, 15, false);
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
        this.fzZ.setPageId(bdUniqueId);
    }

    private void aX(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_share_card_view, this);
        setOrientation(1);
        this.bFw = (LinearLayout) findViewById(d.g.share_content);
        this.dfk = (TextView) findViewById(d.g.frs_card_name);
        this.fzY = (EditText) findViewById(d.g.chat_msg);
        this.fzZ = (HeadImageView) findViewById(d.g.frs_card_img);
        this.fAb = (TextView) findViewById(d.g.frs_card_member_num);
        this.fAa = (TextView) findViewById(d.g.frs_card_post_num);
        al.d(this.dfk, d.C0277d.cp_cont_b, 1);
        al.d(this.fzY, d.C0277d.cp_cont_b, 2);
        this.fzY.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        this.fzY.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        bkh();
    }

    public void bkh() {
        this.bFw.setFocusable(true);
        this.bFw.setFocusableInTouchMode(true);
        this.bFw.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fzY != null) {
            return k.a(this.fzY.getText(), null);
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
        this.fAc = shareFromFrsMsgData;
        GR();
    }

    private void GR() {
        this.dfk.setText(mM(this.fAc.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.fAc.getImageUrl());
        this.fzZ.startLoad(this.fAc.getImageUrl(), 15, false);
        this.fAb.setText(ap.ax(this.fAc.getMemberNum()));
        this.fAa.setText(ap.ax(this.fAc.getPostNum()));
    }

    private String mM(String str) {
        return ap.o(str, 18) + this.context.getString(d.j.forum);
    }
}
