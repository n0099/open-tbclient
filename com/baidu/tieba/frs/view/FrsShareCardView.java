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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class FrsShareCardView extends LinearLayout {
    private Context context;
    private TextView eli;
    private EditText jKp;
    private HeadImageView jKq;
    private TextView jKr;
    private TextView jKs;
    private ShareFromFrsMsgData jKt;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.jKp;
    }

    public void aQ(String str, boolean z) {
        if (this.jKq != null) {
            this.jKq.startLoad(str, 15, false);
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
        this.jKq.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.eli = (TextView) findViewById(R.id.frs_card_name);
        this.jKp = (EditText) findViewById(R.id.chat_msg);
        this.jKq = (HeadImageView) findViewById(R.id.frs_card_img);
        this.jKs = (TextView) findViewById(R.id.frs_card_member_num);
        this.jKr = (TextView) findViewById(R.id.frs_card_post_num);
        ao.setViewTextColor(this.eli, R.color.CAM_X0105, 1);
        ao.setViewTextColor(this.jKp, R.color.CAM_X0105, 2);
        this.jKp.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        this.jKp.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cLt();
    }

    public void cLt() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jKp != null) {
            return k.charSequence2String(this.jKp.getText(), null);
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
        this.jKt = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.eli.setText(getShortName(this.jKt.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.jKt.getImageUrl());
        this.jKq.startLoad(this.jKt.getImageUrl(), 15, false);
        this.jKs.setText(at.numFormatOver10000(this.jKt.getMemberNum()));
        this.jKr.setText(at.numFormatOver10000(this.jKt.getPostNum()));
    }

    private String getShortName(String str) {
        return at.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
