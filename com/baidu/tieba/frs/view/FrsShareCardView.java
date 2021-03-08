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
    private TextView eoT;
    private EditText jTj;
    private HeadImageView jTk;
    private TextView jTl;
    private TextView jTm;
    private ShareFromFrsMsgData jTn;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.jTj;
    }

    public void aP(String str, boolean z) {
        if (this.jTk != null) {
            this.jTk.startLoad(str, 15, false);
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
        this.jTk.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.eoT = (TextView) findViewById(R.id.frs_card_name);
        this.jTj = (EditText) findViewById(R.id.chat_msg);
        this.jTk = (HeadImageView) findViewById(R.id.frs_card_img);
        this.jTm = (TextView) findViewById(R.id.frs_card_member_num);
        this.jTl = (TextView) findViewById(R.id.frs_card_post_num);
        ap.setViewTextColor(this.eoT, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.jTj, R.color.CAM_X0105, 2);
        this.jTj.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        this.jTj.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cNu();
    }

    public void cNu() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jTj != null) {
            return k.charSequence2String(this.jTj.getText(), null);
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
        this.jTn = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.eoT.setText(getShortName(this.jTn.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.jTn.getImageUrl());
        this.jTk.startLoad(this.jTn.getImageUrl(), 15, false);
        this.jTm.setText(au.numFormatOver10000(this.jTn.getMemberNum()));
        this.jTl.setText(au.numFormatOver10000(this.jTn.getPostNum()));
    }

    private String getShortName(String str) {
        return au.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
