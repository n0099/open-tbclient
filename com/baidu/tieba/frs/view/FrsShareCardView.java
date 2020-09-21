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
/* loaded from: classes21.dex */
public class FrsShareCardView extends LinearLayout {
    private Context context;
    private TextView dBn;
    private EditText iGS;
    private HeadImageView iGT;
    private TextView iGU;
    private TextView iGV;
    private ShareFromFrsMsgData iGW;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.iGS;
    }

    public void aJ(String str, boolean z) {
        if (this.iGT != null) {
            this.iGT.startLoad(str, 15, false);
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
        this.iGT.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.dBn = (TextView) findViewById(R.id.frs_card_name);
        this.iGS = (EditText) findViewById(R.id.chat_msg);
        this.iGT = (HeadImageView) findViewById(R.id.frs_card_img);
        this.iGV = (TextView) findViewById(R.id.frs_card_member_num);
        this.iGU = (TextView) findViewById(R.id.frs_card_post_num);
        ap.setViewTextColor(this.dBn, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.iGS, R.color.cp_cont_b, 2);
        this.iGS.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        this.iGS.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cyh();
    }

    public void cyh() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.iGS != null) {
            return k.charSequence2String(this.iGS.getText(), null);
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
        this.iGW = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dBn.setText(getShortName(this.iGW.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.iGW.getImageUrl());
        this.iGT.startLoad(this.iGW.getImageUrl(), 15, false);
        this.iGV.setText(at.numFormatOver10000(this.iGW.getMemberNum()));
        this.iGU.setText(at.numFormatOver10000(this.iGW.getPostNum()));
    }

    private String getShortName(String str) {
        return at.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
