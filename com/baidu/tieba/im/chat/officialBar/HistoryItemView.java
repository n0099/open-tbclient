package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
/* loaded from: classes13.dex */
public class HistoryItemView extends LinearLayout {
    TbRichTextView hua;
    TextView hub;
    ChatImageWithTailView huc;
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
        this.hub = (TextView) findViewById(R.id.history_send_time);
        this.hua = (TbRichTextView) findViewById(R.id.history_txt);
        this.huc = (ChatImageWithTailView) findViewById(R.id.history_pic);
        am.setBackgroundResource(this.mContainer, R.drawable.selector_history_multi_single_bg);
        am.setViewTextColor(this.hub, R.color.common_color_10067, 1);
        this.hua.setTextColor(am.getColor(R.color.cp_cont_c));
        this.huc.setIsSupportNight(true);
    }

    public void setTime(String str) {
        this.hub.setText(str);
    }

    public TbRichTextView getRichTextView() {
        return this.hua;
    }

    public ChatImageWithTailView getImageView() {
        return this.huc;
    }

    public void cd(View view) {
        this.mContainer.setBackgroundDrawable(null);
        this.mContainer.removeAllViews();
        this.mContainer.addView(view);
    }
}
