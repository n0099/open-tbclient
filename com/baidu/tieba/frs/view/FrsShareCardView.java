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
/* loaded from: classes22.dex */
public class FrsShareCardView extends LinearLayout {
    private Context context;
    private TextView egV;
    private EditText jCt;
    private HeadImageView jCu;
    private TextView jCv;
    private TextView jCw;
    private ShareFromFrsMsgData jCx;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.jCt;
    }

    public void aQ(String str, boolean z) {
        if (this.jCu != null) {
            this.jCu.startLoad(str, 15, false);
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
        this.jCu.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.egV = (TextView) findViewById(R.id.frs_card_name);
        this.jCt = (EditText) findViewById(R.id.chat_msg);
        this.jCu = (HeadImageView) findViewById(R.id.frs_card_img);
        this.jCw = (TextView) findViewById(R.id.frs_card_member_num);
        this.jCv = (TextView) findViewById(R.id.frs_card_post_num);
        ap.setViewTextColor(this.egV, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.jCt, R.color.CAM_X0105, 2);
        this.jCt.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        this.jCt.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cMh();
    }

    public void cMh() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jCt != null) {
            return k.charSequence2String(this.jCt.getText(), null);
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
        this.jCx = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.egV.setText(getShortName(this.jCx.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.jCx.getImageUrl());
        this.jCu.startLoad(this.jCx.getImageUrl(), 15, false);
        this.jCw.setText(au.numFormatOver10000(this.jCx.getMemberNum()));
        this.jCv.setText(au.numFormatOver10000(this.jCx.getPostNum()));
    }

    private String getShortName(String str) {
        return au.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
