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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsShareCardView extends LinearLayout {
    private LinearLayout bOF;
    private TextView bnr;
    private Context context;
    private EditText fYp;
    private HeadImageView fYq;
    private TextView fYr;
    private TextView fYs;
    private ShareFromFrsMsgData fYt;

    public EditText getChatMsgView() {
        return this.fYp;
    }

    public void am(String str, boolean z) {
        if (this.fYq != null) {
            this.fYq.startLoad(str, 15, false);
        }
    }

    public FrsShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        ap(context);
    }

    public FrsShareCardView(Context context) {
        super(context);
        this.context = context;
        ap(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.fYq.setPageId(bdUniqueId);
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.bOF = (LinearLayout) findViewById(R.id.share_content);
        this.bnr = (TextView) findViewById(R.id.frs_card_name);
        this.fYp = (EditText) findViewById(R.id.chat_msg);
        this.fYq = (HeadImageView) findViewById(R.id.frs_card_img);
        this.fYs = (TextView) findViewById(R.id.frs_card_member_num);
        this.fYr = (TextView) findViewById(R.id.frs_card_post_num);
        am.f(this.bnr, R.color.cp_cont_b, 1);
        am.f(this.fYp, R.color.cp_cont_b, 2);
        this.fYp.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.fYp.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        buE();
    }

    public void buE() {
        this.bOF.setFocusable(true);
        this.bOF.setFocusableInTouchMode(true);
        this.bOF.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fYp != null) {
            return k.a(this.fYp.getText(), null);
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
        this.fYt = shareFromFrsMsgData;
        JW();
    }

    private void JW() {
        this.bnr.setText(op(this.fYt.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.fYt.getImageUrl());
        this.fYq.startLoad(this.fYt.getImageUrl(), 15, false);
        this.fYs.setText(aq.aM(this.fYt.getMemberNum()));
        this.fYr.setText(aq.aM(this.fYt.getPostNum()));
    }

    private String op(String str) {
        return aq.i(str, 18) + this.context.getString(R.string.forum);
    }
}
