package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class x extends RelativeLayout {
    private TextView cvE;
    private View mRootView;
    private TextView mTextView;

    public x(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(w.j.tab_item_view, this);
        this.mTextView = (TextView) this.mRootView.findViewById(w.h.tab_item_textview);
        this.cvE = (TextView) this.mRootView.findViewById(w.h.tab_item_red_tip);
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    public TextView getRedTipView() {
        return this.cvE;
    }

    public void onChangeSkinType() {
        aq.j(this.cvE, w.g.icon_news_down_bar_one);
    }
}
