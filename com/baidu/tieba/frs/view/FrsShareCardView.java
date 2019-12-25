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
/* loaded from: classes6.dex */
public class FrsShareCardView extends LinearLayout {
    private Context context;
    private TextView cpT;
    private EditText gLu;
    private HeadImageView gLv;
    private TextView gLw;
    private TextView gLx;
    private ShareFromFrsMsgData gLy;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.gLu;
    }

    public void am(String str, boolean z) {
        if (this.gLv != null) {
            this.gLv.startLoad(str, 15, false);
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
        this.gLv.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.cpT = (TextView) findViewById(R.id.frs_card_name);
        this.gLu = (EditText) findViewById(R.id.chat_msg);
        this.gLv = (HeadImageView) findViewById(R.id.frs_card_img);
        this.gLx = (TextView) findViewById(R.id.frs_card_member_num);
        this.gLw = (TextView) findViewById(R.id.frs_card_post_num);
        am.setViewTextColor(this.cpT, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gLu, R.color.cp_cont_b, 2);
        this.gLu.setHintTextColor(am.getColor(R.color.cp_cont_e));
        this.gLu.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        bJg();
    }

    public void bJg() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.gLu != null) {
            return k.charSequence2String(this.gLu.getText(), null);
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
        this.gLy = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.cpT.setText(getShortName(this.gLy.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.gLy.getImageUrl());
        this.gLv.startLoad(this.gLy.getImageUrl(), 15, false);
        this.gLx.setText(aq.numFormatOver10000(this.gLy.getMemberNum()));
        this.gLw.setText(aq.numFormatOver10000(this.gLy.getPostNum()));
    }

    private String getShortName(String str) {
        return aq.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
