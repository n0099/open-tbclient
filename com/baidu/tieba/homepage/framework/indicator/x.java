package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class x extends RelativeLayout {
    private TextView Wb;
    private TextView cDq;
    private View mRootView;

    public x(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(t.h.tab_item_view, this);
        this.Wb = (TextView) this.mRootView.findViewById(t.g.tab_item_textview);
        this.cDq = (TextView) this.mRootView.findViewById(t.g.tab_item_red_tip);
    }

    public TextView getTextView() {
        return this.Wb;
    }

    public TextView getRedTipView() {
        return this.cDq;
    }

    public void ti() {
        av.k(this.cDq, t.f.icon_news_down_bar_one);
    }
}
