package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
/* loaded from: classes20.dex */
public class ShareCardView extends LinearLayout {
    private TbImageView fsj;
    private TextView jTC;
    private ShareFromTopicMsgData jTD;
    private EditText joP;
    private LinearLayout mRootView;
    private TextView title;

    public EditText getChatMsgView() {
        return this.joP;
    }

    public void aP(String str, boolean z) {
        if (this.fsj != null) {
            this.fsj.startLoad(str, z ? 17 : 18, false);
        }
    }

    public ShareCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI(context);
    }

    public ShareCardView(Context context) {
        super(context);
        initUI(context);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.thread_to_group_share_view, this);
        setOrientation(1);
        this.mRootView = (LinearLayout) findViewById(R.id.share_content);
        this.title = (TextView) findViewById(R.id.share_title_view);
        this.joP = (EditText) findViewById(R.id.chat_msg);
        this.fsj = (TbImageView) findViewById(R.id.chat_group_img);
        this.jTC = (TextView) findViewById(R.id.chat_group_desc);
        ap.setViewTextColor(this.title, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.joP, R.color.CAM_X0105, 2);
        ap.setViewTextColor(this.jTC, R.color.CAM_X0106, 1);
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

    public void setData(ShareFromTopicMsgData shareFromTopicMsgData) {
        this.jTD = shareFromTopicMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.jTD.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.jTD.getImageUrl());
        this.fsj.setTag(this.jTD.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.jTD.getContent());
        this.jTC.setText(this.jTD.getContent());
    }
}
