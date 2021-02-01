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
/* loaded from: classes2.dex */
public class FrsShareCardView extends LinearLayout {
    private Context context;
    private TextView enq;
    private EditText jRm;
    private HeadImageView jRn;
    private TextView jRo;
    private TextView jRp;
    private ShareFromFrsMsgData jRq;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.jRm;
    }

    public void aP(String str, boolean z) {
        if (this.jRn != null) {
            this.jRn.startLoad(str, 15, false);
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
        this.jRn.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.enq = (TextView) findViewById(R.id.frs_card_name);
        this.jRm = (EditText) findViewById(R.id.chat_msg);
        this.jRn = (HeadImageView) findViewById(R.id.frs_card_img);
        this.jRp = (TextView) findViewById(R.id.frs_card_member_num);
        this.jRo = (TextView) findViewById(R.id.frs_card_post_num);
        ap.setViewTextColor(this.enq, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.jRm, R.color.CAM_X0105, 2);
        this.jRm.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        this.jRm.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cNh();
    }

    public void cNh() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jRm != null) {
            return k.charSequence2String(this.jRm.getText(), null);
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
        this.jRq = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.enq.setText(getShortName(this.jRq.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.jRq.getImageUrl());
        this.jRn.startLoad(this.jRq.getImageUrl(), 15, false);
        this.jRp.setText(au.numFormatOver10000(this.jRq.getMemberNum()));
        this.jRo.setText(au.numFormatOver10000(this.jRq.getPostNum()));
    }

    private String getShortName(String str) {
        return au.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
