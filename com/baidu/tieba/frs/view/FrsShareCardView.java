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
/* loaded from: classes9.dex */
public class FrsShareCardView extends LinearLayout {
    private Context context;
    private TextView dez;
    private EditText hRK;
    private HeadImageView hRL;
    private TextView hRM;
    private TextView hRN;
    private ShareFromFrsMsgData hRO;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.hRK;
    }

    public void aF(String str, boolean z) {
        if (this.hRL != null) {
            this.hRL.startLoad(str, 15, false);
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
        this.hRL.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.dez = (TextView) findViewById(R.id.frs_card_name);
        this.hRK = (EditText) findViewById(R.id.chat_msg);
        this.hRL = (HeadImageView) findViewById(R.id.frs_card_img);
        this.hRN = (TextView) findViewById(R.id.frs_card_member_num);
        this.hRM = (TextView) findViewById(R.id.frs_card_post_num);
        am.setViewTextColor(this.dez, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.hRK, R.color.cp_cont_b, 2);
        this.hRK.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.hRK.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cdm();
    }

    public void cdm() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.hRK != null) {
            return k.charSequence2String(this.hRK.getText(), null);
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
        this.hRO = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dez.setText(getShortName(this.hRO.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.hRO.getImageUrl());
        this.hRL.startLoad(this.hRO.getImageUrl(), 15, false);
        this.hRN.setText(aq.numFormatOver10000(this.hRO.getMemberNum()));
        this.hRM.setText(aq.numFormatOver10000(this.hRO.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
