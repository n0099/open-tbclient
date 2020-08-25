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
/* loaded from: classes16.dex */
public class FrsShareCardView extends LinearLayout {
    private Context context;
    private TextView dzi;
    private EditText izr;
    private HeadImageView izs;
    private TextView izt;
    private TextView izu;
    private ShareFromFrsMsgData izv;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.izr;
    }

    public void aJ(String str, boolean z) {
        if (this.izs != null) {
            this.izs.startLoad(str, 15, false);
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
        this.izs.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.dzi = (TextView) findViewById(R.id.frs_card_name);
        this.izr = (EditText) findViewById(R.id.chat_msg);
        this.izs = (HeadImageView) findViewById(R.id.frs_card_img);
        this.izu = (TextView) findViewById(R.id.frs_card_member_num);
        this.izt = (TextView) findViewById(R.id.frs_card_post_num);
        ap.setViewTextColor(this.dzi, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.izr, R.color.cp_cont_b, 2);
        this.izr.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        this.izr.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cuN();
    }

    public void cuN() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.izr != null) {
            return k.charSequence2String(this.izr.getText(), null);
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
        this.izv = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dzi.setText(getShortName(this.izv.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.izv.getImageUrl());
        this.izs.startLoad(this.izv.getImageUrl(), 15, false);
        this.izu.setText(at.numFormatOver10000(this.izv.getMemberNum()));
        this.izt.setText(at.numFormatOver10000(this.izv.getPostNum()));
    }

    private String getShortName(String str) {
        return at.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
