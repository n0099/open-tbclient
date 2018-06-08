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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class FrsShareCardView extends LinearLayout {
    private LinearLayout aUT;
    private TextView bui;
    private Context context;
    private EditText dEh;
    private HeadImageView dEi;
    private TextView dEj;
    private TextView dEk;
    private ShareFromFrsMsgData dEl;

    public EditText getChatMsgView() {
        return this.dEh;
    }

    public void D(String str, boolean z) {
        if (this.dEi != null) {
            this.dEi.startLoad(str, 15, false);
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
        this.dEi.setPageId(bdUniqueId);
    }

    private void by(Context context) {
        LayoutInflater.from(context).inflate(d.i.frs_share_card_view, this);
        setOrientation(1);
        this.aUT = (LinearLayout) findViewById(d.g.share_content);
        this.bui = (TextView) findViewById(d.g.frs_card_name);
        this.dEh = (EditText) findViewById(d.g.chat_msg);
        this.dEi = (HeadImageView) findViewById(d.g.frs_card_img);
        this.dEk = (TextView) findViewById(d.g.frs_card_member_num);
        this.dEj = (TextView) findViewById(d.g.frs_card_post_num);
        al.c(this.bui, d.C0141d.cp_cont_b, 1);
        al.c(this.dEh, d.C0141d.cp_cont_b, 2);
        this.dEh.setHintTextColor(al.getColor(d.C0141d.cp_cont_e));
        this.dEh.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        azY();
    }

    public void azY() {
        this.aUT.setFocusable(true);
        this.aUT.setFocusableInTouchMode(true);
        this.aUT.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dEh != null) {
            return k.a(this.dEh.getText(), null);
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
        this.dEl = shareFromFrsMsgData;
        Al();
    }

    private void Al() {
        this.bui.setText(eN(this.dEl.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.dEl.getImageUrl());
        this.dEi.startLoad(this.dEl.getImageUrl(), 15, false);
        this.dEk.setText(ao.C(this.dEl.getMemberNum()));
        this.dEj.setText(ao.C(this.dEl.getPostNum()));
    }

    private String eN(String str) {
        return ao.j(str, 18) + this.context.getString(d.k.forum);
    }
}
