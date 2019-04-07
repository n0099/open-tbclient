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
    private LinearLayout bFy;
    private Context context;
    private TextView dfo;
    private EditText fzM;
    private HeadImageView fzN;
    private TextView fzO;
    private TextView fzP;
    private ShareFromFrsMsgData fzQ;

    public EditText getChatMsgView() {
        return this.fzM;
    }

    public void ag(String str, boolean z) {
        if (this.fzN != null) {
            this.fzN.startLoad(str, 15, false);
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
        this.fzN.setPageId(bdUniqueId);
    }

    private void aX(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_share_card_view, this);
        setOrientation(1);
        this.bFy = (LinearLayout) findViewById(d.g.share_content);
        this.dfo = (TextView) findViewById(d.g.frs_card_name);
        this.fzM = (EditText) findViewById(d.g.chat_msg);
        this.fzN = (HeadImageView) findViewById(d.g.frs_card_img);
        this.fzP = (TextView) findViewById(d.g.frs_card_member_num);
        this.fzO = (TextView) findViewById(d.g.frs_card_post_num);
        al.d(this.dfo, d.C0277d.cp_cont_b, 1);
        al.d(this.fzM, d.C0277d.cp_cont_b, 2);
        this.fzM.setHintTextColor(al.getColor(d.C0277d.cp_cont_e));
        this.fzM.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        bkf();
    }

    public void bkf() {
        this.bFy.setFocusable(true);
        this.bFy.setFocusableInTouchMode(true);
        this.bFy.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fzM != null) {
            return k.a(this.fzM.getText(), null);
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
        this.fzQ = shareFromFrsMsgData;
        GP();
    }

    private void GP() {
        this.dfo.setText(mN(this.fzQ.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.fzQ.getImageUrl());
        this.fzN.startLoad(this.fzQ.getImageUrl(), 15, false);
        this.fzP.setText(ap.ax(this.fzQ.getMemberNum()));
        this.fzO.setText(ap.ax(this.fzQ.getPostNum()));
    }

    private String mN(String str) {
        return ap.o(str, 18) + this.context.getString(d.j.forum);
    }
}
