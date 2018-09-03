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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class FrsShareCardView extends LinearLayout {
    private LinearLayout axD;
    private TextView bwl;
    private Context context;
    private EditText dKn;
    private HeadImageView dKo;
    private TextView dKp;
    private TextView dKq;
    private ShareFromFrsMsgData dKr;

    public EditText getChatMsgView() {
        return this.dKn;
    }

    public void D(String str, boolean z) {
        if (this.dKo != null) {
            this.dKo.startLoad(str, 15, false);
        }
    }

    public FrsShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        by(context);
    }

    public FrsShareCardView(Context context) {
        super(context);
        this.context = context;
        by(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.dKo.setPageId(bdUniqueId);
    }

    private void by(Context context) {
        LayoutInflater.from(context).inflate(f.h.frs_share_card_view, this);
        setOrientation(1);
        this.axD = (LinearLayout) findViewById(f.g.share_content);
        this.bwl = (TextView) findViewById(f.g.frs_card_name);
        this.dKn = (EditText) findViewById(f.g.chat_msg);
        this.dKo = (HeadImageView) findViewById(f.g.frs_card_img);
        this.dKq = (TextView) findViewById(f.g.frs_card_member_num);
        this.dKp = (TextView) findViewById(f.g.frs_card_post_num);
        am.c(this.bwl, f.d.cp_cont_b, 1);
        am.c(this.dKn, f.d.cp_cont_b, 2);
        this.dKn.setHintTextColor(am.getColor(f.d.cp_cont_e));
        this.dKn.setPadding(context.getResources().getDimensionPixelSize(f.e.ds20), 0, 0, 0);
        aBl();
    }

    public void aBl() {
        this.axD.setFocusable(true);
        this.axD.setFocusableInTouchMode(true);
        this.axD.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dKn != null) {
            return k.a(this.dKn.getText(), null);
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
        this.dKr = shareFromFrsMsgData;
        Ap();
    }

    private void Ap() {
        this.bwl.setText(eO(this.dKr.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.dKr.getImageUrl());
        this.dKo.startLoad(this.dKr.getImageUrl(), 15, false);
        this.dKq.setText(ap.F(this.dKr.getMemberNum()));
        this.dKp.setText(ap.F(this.dKr.getPostNum()));
    }

    private String eO(String str) {
        return ap.j(str, 18) + this.context.getString(f.j.forum);
    }
}
