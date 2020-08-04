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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class FrsShareCardView extends LinearLayout {
    private Context context;
    private TextView dpg;
    private EditText ilo;
    private HeadImageView ilp;
    private TextView ilq;
    private TextView ilr;
    private ShareFromFrsMsgData ils;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.ilo;
    }

    public void aF(String str, boolean z) {
        if (this.ilp != null) {
            this.ilp.startLoad(str, 15, false);
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
        this.ilp.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.dpg = (TextView) findViewById(R.id.frs_card_name);
        this.ilo = (EditText) findViewById(R.id.chat_msg);
        this.ilp = (HeadImageView) findViewById(R.id.frs_card_img);
        this.ilr = (TextView) findViewById(R.id.frs_card_member_num);
        this.ilq = (TextView) findViewById(R.id.frs_card_post_num);
        ao.setViewTextColor(this.dpg, R.color.cp_cont_b, 1);
        ao.setViewTextColor(this.ilo, R.color.cp_cont_b, 2);
        this.ilo.setHintTextColor(ao.getColor(R.color.cp_cont_e));
        this.ilo.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        ckj();
    }

    public void ckj() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ilo != null) {
            return k.charSequence2String(this.ilo.getText(), null);
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
        this.ils = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dpg.setText(getShortName(this.ils.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.ils.getImageUrl());
        this.ilp.startLoad(this.ils.getImageUrl(), 15, false);
        this.ilr.setText(as.numFormatOver10000(this.ils.getMemberNum()));
        this.ilq.setText(as.numFormatOver10000(this.ils.getPostNum()));
    }

    private String getShortName(String str) {
        return as.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
