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
    private TbImageView eSz;
    private EditText iGS;
    private TextView jly;
    private ShareFromTopicMsgData jlz;
    private LinearLayout mRootView;
    private TextView title;

    public EditText getChatMsgView() {
        return this.iGS;
    }

    public void aJ(String str, boolean z) {
        if (this.eSz != null) {
            this.eSz.startLoad(str, z ? 17 : 18, false);
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
        this.iGS = (EditText) findViewById(R.id.chat_msg);
        this.eSz = (TbImageView) findViewById(R.id.chat_group_img);
        this.jly = (TextView) findViewById(R.id.chat_group_desc);
        ap.setViewTextColor(this.title, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.iGS, R.color.cp_cont_b, 2);
        ap.setViewTextColor(this.jly, R.color.cp_cont_f, 1);
        this.iGS.setHintTextColor(ap.getColor(R.color.cp_cont_e));
        this.iGS.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cyh();
    }

    public void cyh() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.iGS != null) {
            return k.charSequence2String(this.iGS.getText(), null);
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
        this.jlz = shareFromTopicMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.jlz.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.jlz.getImageUrl());
        this.eSz.setTag(this.jlz.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.jlz.getContent());
        this.jly.setText(this.jlz.getContent());
    }
}
