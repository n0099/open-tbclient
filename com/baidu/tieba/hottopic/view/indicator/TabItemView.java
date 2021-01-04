package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class TabItemView extends RelativeLayout {
    private TextView kvr;
    private View mRootView;
    private TextView mTextView;

    public TabItemView(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.topic_tab_item_view, this);
        this.mTextView = (TextView) this.mRootView.findViewById(R.id.topic_tab_item_textview);
        this.kvr = (TextView) this.mRootView.findViewById(R.id.topic_tab_item_red_tip);
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    public TextView getRedTipView() {
        return this.kvr;
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this.kvr, R.drawable.icon_news_down_bar_one);
    }
}
