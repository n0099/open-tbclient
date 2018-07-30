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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class FrsShareCardView extends LinearLayout {
    private LinearLayout axG;
    private TextView bwj;
    private Context context;
    private EditText dKr;
    private HeadImageView dKs;
    private TextView dKt;
    private TextView dKu;
    private ShareFromFrsMsgData dKv;

    public EditText getChatMsgView() {
        return this.dKr;
    }

    public void D(String str, boolean z) {
        if (this.dKs != null) {
            this.dKs.startLoad(str, 15, false);
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
        this.dKs.setPageId(bdUniqueId);
    }

    private void by(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_share_card_view, this);
        setOrientation(1);
        this.axG = (LinearLayout) findViewById(d.g.share_content);
        this.bwj = (TextView) findViewById(d.g.frs_card_name);
        this.dKr = (EditText) findViewById(d.g.chat_msg);
        this.dKs = (HeadImageView) findViewById(d.g.frs_card_img);
        this.dKu = (TextView) findViewById(d.g.frs_card_member_num);
        this.dKt = (TextView) findViewById(d.g.frs_card_post_num);
        am.c(this.bwj, d.C0140d.cp_cont_b, 1);
        am.c(this.dKr, d.C0140d.cp_cont_b, 2);
        this.dKr.setHintTextColor(am.getColor(d.C0140d.cp_cont_e));
        this.dKr.setPadding(context.getResources().getDimensionPixelSize(d.e.ds20), 0, 0, 0);
        aBo();
    }

    public void aBo() {
        this.axG.setFocusable(true);
        this.axG.setFocusableInTouchMode(true);
        this.axG.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.dKr != null) {
            return k.a(this.dKr.getText(), null);
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
        this.dKv = shareFromFrsMsgData;
        Ar();
    }

    private void Ar() {
        this.bwj.setText(eO(this.dKv.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.dKv.getImageUrl());
        this.dKs.startLoad(this.dKv.getImageUrl(), 15, false);
        this.dKu.setText(ap.F(this.dKv.getMemberNum()));
        this.dKt.setText(ap.F(this.dKv.getPostNum()));
    }

    private String eO(String str) {
        return ap.j(str, 18) + this.context.getString(d.j.forum);
    }
}
