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
    private TextView cTr;
    private Context context;
    private EditText hCe;
    private HeadImageView hCf;
    private TextView hCg;
    private TextView hCh;
    private ShareFromFrsMsgData hCi;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.hCe;
    }

    public void as(String str, boolean z) {
        if (this.hCf != null) {
            this.hCf.startLoad(str, 15, false);
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
        this.hCf.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.cTr = (TextView) findViewById(R.id.frs_card_name);
        this.hCe = (EditText) findViewById(R.id.chat_msg);
        this.hCf = (HeadImageView) findViewById(R.id.frs_card_img);
        this.hCh = (TextView) findViewById(R.id.frs_card_member_num);
        this.hCg = (TextView) findViewById(R.id.frs_card_post_num);
        am.setViewTextColor(this.cTr, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.hCe, R.color.cp_cont_b, 2);
        this.hCe.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.hCe.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        bWH();
    }

    public void bWH() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.hCe != null) {
            return k.charSequence2String(this.hCe.getText(), null);
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
        this.hCi = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.cTr.setText(getShortName(this.hCi.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.hCi.getImageUrl());
        this.hCf.startLoad(this.hCi.getImageUrl(), 15, false);
        this.hCh.setText(aq.numFormatOver10000(this.hCi.getMemberNum()));
        this.hCg.setText(aq.numFormatOver10000(this.hCi.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
