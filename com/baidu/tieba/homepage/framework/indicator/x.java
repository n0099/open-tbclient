package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class x extends RelativeLayout {
    private TextView Wl;
    private TextView cDU;
    private View mRootView;

    public x(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(r.h.tab_item_view, this);
        this.Wl = (TextView) this.mRootView.findViewById(r.g.tab_item_textview);
        this.cDU = (TextView) this.mRootView.findViewById(r.g.tab_item_red_tip);
    }

    public TextView getTextView() {
        return this.Wl;
    }

    public TextView getRedTipView() {
        return this.cDU;
    }

    public void tx() {
        av.k(this.cDU, r.f.icon_news_down_bar_one);
    }
}
