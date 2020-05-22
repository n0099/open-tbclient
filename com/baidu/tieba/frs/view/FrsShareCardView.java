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
    private EditText hQX;
    private HeadImageView hQY;
    private TextView hQZ;
    private TextView hRa;
    private ShareFromFrsMsgData hRb;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.hQX;
    }

    public void aF(String str, boolean z) {
        if (this.hQY != null) {
            this.hQY.startLoad(str, 15, false);
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
        this.hQY.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.dez = (TextView) findViewById(R.id.frs_card_name);
        this.hQX = (EditText) findViewById(R.id.chat_msg);
        this.hQY = (HeadImageView) findViewById(R.id.frs_card_img);
        this.hRa = (TextView) findViewById(R.id.frs_card_member_num);
        this.hQZ = (TextView) findViewById(R.id.frs_card_post_num);
        am.setViewTextColor(this.dez, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.hQX, R.color.cp_cont_b, 2);
        this.hQX.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.hQX.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cde();
    }

    public void cde() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.hQX != null) {
            return k.charSequence2String(this.hQX.getText(), null);
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
        this.hRb = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dez.setText(getShortName(this.hRb.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.hRb.getImageUrl());
        this.hQY.startLoad(this.hRb.getImageUrl(), 15, false);
        this.hRa.setText(aq.numFormatOver10000(this.hRb.getMemberNum()));
        this.hQZ.setText(aq.numFormatOver10000(this.hRb.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
