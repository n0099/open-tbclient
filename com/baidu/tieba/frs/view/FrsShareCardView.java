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
/* loaded from: classes22.dex */
public class FrsShareCardView extends LinearLayout {
    private Context context;
    private TextView dVL;
    private EditText jif;
    private HeadImageView jig;
    private TextView jih;
    private TextView jii;
    private ShareFromFrsMsgData jij;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.jif;
    }

    public void aP(String str, boolean z) {
        if (this.jig != null) {
            this.jig.startLoad(str, 15, false);
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
        this.jig.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.dVL = (TextView) findViewById(R.id.frs_card_name);
        this.jif = (EditText) findViewById(R.id.chat_msg);
        this.jig = (HeadImageView) findViewById(R.id.frs_card_img);
        this.jii = (TextView) findViewById(R.id.frs_card_member_num);
        this.jih = (TextView) findViewById(R.id.frs_card_post_num);
        ap.setViewTextColor(this.dVL, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.jif, R.color.cp_cont_b, 2);
        this.jif.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        this.jif.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cEL();
    }

    public void cEL() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jif != null) {
            return k.charSequence2String(this.jif.getText(), null);
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
        this.jij = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dVL.setText(getShortName(this.jij.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.jij.getImageUrl());
        this.jig.startLoad(this.jij.getImageUrl(), 15, false);
        this.jii.setText(at.numFormatOver10000(this.jij.getMemberNum()));
        this.jih.setText(at.numFormatOver10000(this.jij.getPostNum()));
    }

    private String getShortName(String str) {
        return at.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
