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
/* loaded from: classes21.dex */
public class ShareCardView extends LinearLayout {
    private TbImageView fzX;
    private EditText jCr;
    private TextView khg;
    private ShareFromTopicMsgData khh;
    private LinearLayout mRootView;
    private TextView title;

    public EditText getChatMsgView() {
        return this.jCr;
    }

    public void aQ(String str, boolean z) {
        if (this.fzX != null) {
            this.fzX.startLoad(str, z ? 17 : 18, false);
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
        this.jCr = (EditText) findViewById(R.id.chat_msg);
        this.fzX = (TbImageView) findViewById(R.id.chat_group_img);
        this.khg = (TextView) findViewById(R.id.chat_group_desc);
        ap.setViewTextColor(this.title, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.jCr, R.color.CAM_X0105, 2);
        ap.setViewTextColor(this.khg, R.color.CAM_X0106, 1);
        this.jCr.setHintTextColor(ap.getColor(R.color.CAM_X0110));
        this.jCr.setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds20), 0, 0, 0);
        cMg();
    }

    public void cMg() {
        this.mRootView.setFocusable(true);
        this.mRootView.setFocusableInTouchMode(true);
        this.mRootView.requestFocus();
    }

    public String getLeaveMsg() {
        if (this.jCr != null) {
            return k.charSequence2String(this.jCr.getText(), null);
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
        this.khh = shareFromTopicMsgData;
        updateUI();
    }

    private void updateUI() {
        this.title.setText(this.khh.getTitle());
        BdLog.e("mData.getImageUrl()的图片URL" + this.khh.getImageUrl());
        this.fzX.setTag(this.khh.getImageUrl());
        BdLog.e("mData.getContent()的Content" + this.khh.getContent());
        this.khg.setText(this.khh.getContent());
    }
}
