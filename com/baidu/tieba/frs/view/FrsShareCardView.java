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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class FrsShareCardView extends LinearLayout {
    private Context context;
    private TextView dNo;
    private EditText iVI;
    private HeadImageView iVJ;
    private TextView iVK;
    private TextView iVL;
    private ShareFromFrsMsgData iVM;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.iVI;
    }

    public void aN(String str, boolean z) {
        if (this.iVJ != null) {
            this.iVJ.startLoad(str, 15, false);
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
        this.iVJ.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.dNo = (TextView) findViewById(R.id.frs_card_name);
        this.iVI = (EditText) findViewById(R.id.chat_msg);
        this.iVJ = (HeadImageView) findViewById(R.id.frs_card_img);
        this.iVL = (TextView) findViewById(R.id.frs_card_member_num);
        this.iVK = (TextView) findViewById(R.id.frs_card_post_num);
        ap.setViewTextColor(this.dNo, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.iVI, R.color.cp_cont_b, 2);
        this.iVI.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        this.iVI.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cBE();
    }

    public void cBE() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.iVI != null) {
            return k.charSequence2String(this.iVI.getText(), null);
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
        this.iVM = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dNo.setText(getShortName(this.iVM.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.iVM.getImageUrl());
        this.iVJ.startLoad(this.iVM.getImageUrl(), 15, false);
        this.iVL.setText(at.numFormatOver10000(this.iVM.getMemberNum()));
        this.iVK.setText(at.numFormatOver10000(this.iVM.getPostNum()));
    }

    private String getShortName(String str) {
        return at.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
