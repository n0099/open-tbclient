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
/* loaded from: classes7.dex */
public class FrsShareCardView extends LinearLayout {
    private Context context;
    private TextView cqf;
    private EditText gOI;
    private HeadImageView gOJ;
    private TextView gOK;
    private TextView gOL;
    private ShareFromFrsMsgData gOM;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.gOI;
    }

    public void am(String str, boolean z) {
        if (this.gOJ != null) {
            this.gOJ.startLoad(str, 15, false);
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
        this.gOJ.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.cqf = (TextView) findViewById(R.id.frs_card_name);
        this.gOI = (EditText) findViewById(R.id.chat_msg);
        this.gOJ = (HeadImageView) findViewById(R.id.frs_card_img);
        this.gOL = (TextView) findViewById(R.id.frs_card_member_num);
        this.gOK = (TextView) findViewById(R.id.frs_card_post_num);
        am.setViewTextColor(this.cqf, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gOI, R.color.cp_cont_b, 2);
        this.gOI.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.gOI.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        bKi();
    }

    public void bKi() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.gOI != null) {
            return k.charSequence2String(this.gOI.getText(), null);
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
        this.gOM = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.cqf.setText(getShortName(this.gOM.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.gOM.getImageUrl());
        this.gOJ.startLoad(this.gOM.getImageUrl(), 15, false);
        this.gOL.setText(aq.numFormatOver10000(this.gOM.getMemberNum()));
        this.gOK.setText(aq.numFormatOver10000(this.gOM.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
