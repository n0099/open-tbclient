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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class FrsShareCardView extends LinearLayout {
    private Context context;
    private TextView enq;
    private EditText jRA;
    private HeadImageView jRB;
    private TextView jRC;
    private TextView jRD;
    private ShareFromFrsMsgData jRE;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.jRA;
    }

    public void aP(String str, boolean z) {
        if (this.jRB != null) {
            this.jRB.startLoad(str, 15, false);
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
        this.jRB.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.enq = (TextView) findViewById(R.id.frs_card_name);
        this.jRA = (EditText) findViewById(R.id.chat_msg);
        this.jRB = (HeadImageView) findViewById(R.id.frs_card_img);
        this.jRD = (TextView) findViewById(R.id.frs_card_member_num);
        this.jRC = (TextView) findViewById(R.id.frs_card_post_num);
        ap.setViewTextColor(this.enq, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.jRA, R.color.CAM_X0105, 2);
        this.jRA.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        this.jRA.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cNo();
    }

    public void cNo() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jRA != null) {
            return k.charSequence2String(this.jRA.getText(), null);
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
        this.jRE = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.enq.setText(getShortName(this.jRE.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.jRE.getImageUrl());
        this.jRB.startLoad(this.jRE.getImageUrl(), 15, false);
        this.jRD.setText(au.numFormatOver10000(this.jRE.getMemberNum()));
        this.jRC.setText(au.numFormatOver10000(this.jRE.getPostNum()));
    }

    private String getShortName(String str) {
        return au.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
