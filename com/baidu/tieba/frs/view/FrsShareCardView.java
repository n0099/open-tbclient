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
    private TextView bFm;
    private Context context;
    private EditText fWT;
    private HeadImageView fWU;
    private TextView fWV;
    private TextView fWW;
    private ShareFromFrsMsgData fWX;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.fWT;
    }

    public void ai(String str, boolean z) {
        if (this.fWU != null) {
            this.fWU.startLoad(str, 15, false);
        }
    }

    public FrsShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        initUI(context);
    }

    public FrsShareCardView(Context context) {
        super(context);
        this.context = context;
        initUI(context);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.fWU.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.bFm = (TextView) findViewById(R.id.frs_card_name);
        this.fWT = (EditText) findViewById(R.id.chat_msg);
        this.fWU = (HeadImageView) findViewById(R.id.frs_card_img);
        this.fWW = (TextView) findViewById(R.id.frs_card_member_num);
        this.fWV = (TextView) findViewById(R.id.frs_card_post_num);
        am.setViewTextColor(this.bFm, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fWT, R.color.cp_cont_b, 2);
        this.fWT.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.fWT.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        brE();
    }

    public void brE() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.fWT != null) {
            return k.charSequence2String(this.fWT.getText(), null);
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
        this.fWX = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.bFm.setText(getShortName(this.fWX.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.fWX.getImageUrl());
        this.fWU.startLoad(this.fWX.getImageUrl(), 15, false);
        this.fWW.setText(aq.numFormatOver10000(this.fWX.getMemberNum()));
        this.fWV.setText(aq.numFormatOver10000(this.fWX.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
