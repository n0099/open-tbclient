package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
/* loaded from: classes20.dex */
public class HistoryItemView extends LinearLayout {
    TbRichTextView iSc;
    TextView iSd;
    ChatImageWithTailView iSe;
    LinearLayout mContainer;
    Context mContext;

    public HistoryItemView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public HistoryItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    private void initView() {
        setOrientation(1);
        LayoutInflater.from(this.mContext).inflate(R.layout.official_history_item, (ViewGroup) this, true);
        setClickable(false);
        setFocusable(false);
        this.mContainer = (LinearLayout) findViewById(R.id.history_container);
        this.iSd = (TextView) findViewById(R.id.history_send_time);
        this.iSc = (TbRichTextView) findViewById(R.id.history_txt);
        this.iSe = (ChatImageWithTailView) findViewById(R.id.history_pic);
        ao.setBackgroundResource(this.mContainer, R.drawable.selector_history_multi_single_bg);
        ao.setViewTextColor(this.iSd, R.color.common_color_10067, 1);
        this.iSc.setTextColor(ao.getColor(R.color.cp_cont_c));
        this.iSe.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.iSd.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.iSc;
    }

    public ChatImageWithTailView getImageView() {
        return this.iSe;
    }

    public void cs(View view) {
        this.mContainer.setBackgroundDrawable(null);
        this.mContainer.removeAllViews();
        this.mContainer.addView(view);
    }
}
