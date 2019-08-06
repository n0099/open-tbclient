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
    private LinearLayout bOg;
    private TextView bmT;
    private Context context;
    private TextView fWA;
    private TextView fWB;
    private ShareFromFrsMsgData fWC;
    private EditText fWy;
    private HeadImageView fWz;

    public EditText getChatMsgView() {
        return this.fWy;
    }

    public void am(String str, boolean z) {
        if (this.fWz != null) {
            this.fWz.startLoad(str, 15, false);
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
        this.fWz.setPageId(bdUniqueId);
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.bOg = (LinearLayout) findViewById(R.id.share_content);
        this.bmT = (TextView) findViewById(R.id.frs_card_name);
        this.fWy = (EditText) findViewById(R.id.chat_msg);
        this.fWz = (HeadImageView) findViewById(R.id.frs_card_img);
        this.fWB = (TextView) findViewById(R.id.frs_card_member_num);
        this.fWA = (TextView) findViewById(R.id.frs_card_post_num);
        am.f(this.bmT, R.color.cp_cont_b, 1);
        am.f(this.fWy, R.color.cp_cont_b, 2);
        this.fWy.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.fWy.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        btQ();
    }

    public void btQ() {
        this.bOg.setFocusable(true);
        this.bOg.setFocusableInTouchMode(true);
        this.bOg.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fWy != null) {
            return k.a(this.fWy.getText(), null);
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
        this.fWC = shareFromFrsMsgData;
        JS();
    }

    private void JS() {
        this.bmT.setText(om(this.fWC.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.fWC.getImageUrl());
        this.fWz.startLoad(this.fWC.getImageUrl(), 15, false);
        this.fWB.setText(aq.aM(this.fWC.getMemberNum()));
        this.fWA.setText(aq.aM(this.fWC.getPostNum()));
    }

    private String om(String str) {
        return aq.i(str, 18) + this.context.getString(R.string.forum);
    }
}
