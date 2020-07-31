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
    private EditText ilm;
    private HeadImageView iln;
    private TextView ilo;
    private TextView ilp;
    private ShareFromFrsMsgData ilq;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.ilm;
    }

    public void aF(String str, boolean z) {
        if (this.iln != null) {
            this.iln.startLoad(str, 15, false);
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
        this.iln.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.dpg = (TextView) findViewById(R.id.frs_card_name);
        this.ilm = (EditText) findViewById(R.id.chat_msg);
        this.iln = (HeadImageView) findViewById(R.id.frs_card_img);
        this.ilp = (TextView) findViewById(R.id.frs_card_member_num);
        this.ilo = (TextView) findViewById(R.id.frs_card_post_num);
        ao.setViewTextColor(this.dpg, R.color.cp_cont_b, 1);
        ao.setViewTextColor(this.ilm, R.color.cp_cont_b, 2);
        this.ilm.setHintTextColor(ao.getColor(R.color.cp_cont_e));
        this.ilm.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        ckj();
    }

    public void ckj() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.ilm != null) {
            return k.charSequence2String(this.ilm.getText(), null);
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
        this.ilq = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dpg.setText(getShortName(this.ilq.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.ilq.getImageUrl());
        this.iln.startLoad(this.ilq.getImageUrl(), 15, false);
        this.ilp.setText(as.numFormatOver10000(this.ilq.getMemberNum()));
        this.ilo.setText(as.numFormatOver10000(this.ilq.getPostNum()));
    }

    private String getShortName(String str) {
        return as.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
