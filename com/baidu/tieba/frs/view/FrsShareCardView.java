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
/* loaded from: classes21.dex */
public class FrsShareCardView extends LinearLayout {
    private Context context;
    private TextView dZV;
    private EditText joP;
    private HeadImageView joQ;
    private TextView joR;
    private TextView joS;
    private ShareFromFrsMsgData joT;
    private LinearLayout mRootView;

    public EditText getChatMsgView() {
        return this.joP;
    }

    public void aP(String str, boolean z) {
        if (this.joQ != null) {
            this.joQ.startLoad(str, 15, false);
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
        this.joQ.setPageId(bdUniqueId);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_share_card_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.dZV = (TextView) findViewById(R.id.frs_card_name);
        this.joP = (EditText) findViewById(R.id.chat_msg);
        this.joQ = (HeadImageView) findViewById(R.id.frs_card_img);
        this.joS = (TextView) findViewById(R.id.frs_card_member_num);
        this.joR = (TextView) findViewById(R.id.frs_card_post_num);
        ap.setViewTextColor(this.dZV, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.joP, R.color.CAM_X0105, 2);
        this.joP.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        this.joP.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cGR();
    }

    public void cGR() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.joP != null) {
            return k.charSequence2String(this.joP.getText(), null);
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
        this.joT = shareFromFrsMsgData;
        updateUI();
    }

    private void updateUI() {
        this.dZV.setText(getShortName(this.joT.getName()));
        BdLog.e("mData.getImageUrl()的图片URL" + this.joT.getImageUrl());
        this.joQ.startLoad(this.joT.getImageUrl(), 15, false);
        this.joS.setText(au.numFormatOver10000(this.joT.getMemberNum()));
        this.joR.setText(au.numFormatOver10000(this.joT.getPostNum()));
    }

    private String getShortName(String str) {
        return au.cutString(str, 18) + this.context.getString(R.string.forum);
    }
}
