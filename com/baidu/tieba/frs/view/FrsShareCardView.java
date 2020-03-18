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
    private TextView cuv;
    private EditText gSd;
    private HeadImageView gSe;
    private TextView gSf;
    private TextView gSg;
    private ShareFromFrsMsgData gSh;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.gSd;
    }

    public void am(String str, boolean z) {
        if (this.gSe != null) {
            this.gSe.startLoad(str, 15, false);
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
        this.gSe.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.cuv = (TextView) findViewById(R.id.frs_card_name);
        this.gSd = (EditText) findViewById(R.id.chat_msg);
        this.gSe = (HeadImageView) findViewById(R.id.frs_card_img);
        this.gSg = (TextView) findViewById(R.id.frs_card_member_num);
        this.gSf = (TextView) findViewById(R.id.frs_card_post_num);
        am.setViewTextColor(this.cuv, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gSd, R.color.cp_cont_b, 2);
        this.gSd.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.gSd.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        bMb();
    }

    public void bMb() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.gSd != null) {
            return k.charSequence2String(this.gSd.getText(), null);
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
        this.gSh = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.cuv.setText(getShortName(this.gSh.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.gSh.getImageUrl());
        this.gSe.startLoad(this.gSh.getImageUrl(), 15, false);
        this.gSg.setText(aq.numFormatOver10000(this.gSh.getMemberNum()));
        this.gSf.setText(aq.numFormatOver10000(this.gSh.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
