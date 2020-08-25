package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class TabItemView extends RelativeLayout {
    private TextView jdK;
    private View mRootView;
    private TextView mTextView;

    public TabItemView(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.topic_tab_item_view, this);
        this.mTextView = (TextView) this.mRootView.findViewById(R.id.topic_tab_item_textview);
        this.jdK = (TextView) this.mRootView.findViewById(R.id.topic_tab_item_red_tip);
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    public TextView getRedTipView() {
        return this.jdK;
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.jdK, R.drawable.icon_news_down_bar_one);
    }
}
