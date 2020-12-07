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
    private EditText jCr;
    private HeadImageView jCs;
    private TextView jCt;
    private TextView jCu;
    private ShareFromFrsMsgData jCv;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.jCr;
    }

    public void aQ(String str, boolean z) {
        if (this.jCs != null) {
            this.jCs.startLoad(str, 15, false);
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
        this.jCs.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.egV = (TextView) findViewById(R.id.frs_card_name);
        this.jCr = (EditText) findViewById(R.id.chat_msg);
        this.jCs = (HeadImageView) findViewById(R.id.frs_card_img);
        this.jCu = (TextView) findViewById(R.id.frs_card_member_num);
        this.jCt = (TextView) findViewById(R.id.frs_card_post_num);
        ap.setViewTextColor(this.egV, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.jCr, R.color.CAM_X0105, 2);
        this.jCr.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        this.jCr.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cMg();
    }

    public void cMg() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jCr != null) {
            return k.charSequence2String(this.jCr.getText(), null);
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
        this.jCv = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.egV.setText(getShortName(this.jCv.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.jCv.getImageUrl());
        this.jCs.startLoad(this.jCv.getImageUrl(), 15, false);
        this.jCu.setText(au.numFormatOver10000(this.jCv.getMemberNum()));
        this.jCt.setText(au.numFormatOver10000(this.jCv.getPostNum()));
    }

    private String getShortName(String str) {
        return au.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
