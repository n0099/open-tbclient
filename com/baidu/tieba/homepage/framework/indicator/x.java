package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class x extends RelativeLayout {
    private TextView WJ;
    private TextView cJi;
    private View mRootView;

    public x(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(r.h.tab_item_view, this);
        this.WJ = (TextView) this.mRootView.findViewById(r.g.tab_item_textview);
        this.cJi = (TextView) this.mRootView.findViewById(r.g.tab_item_red_tip);
    }

    public TextView getTextView() {
        return this.WJ;
    }

    public TextView getRedTipView() {
        return this.cJi;
    }

    public void tB() {
        at.k(this.cJi, r.f.icon_news_down_bar_one);
    }
}
