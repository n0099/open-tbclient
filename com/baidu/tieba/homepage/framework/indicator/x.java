package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class x extends RelativeLayout {
    private TextView Wd;
    private TextView coD;
    private View mRootView;

    public x(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(r.h.tab_item_view, this);
        this.Wd = (TextView) this.mRootView.findViewById(r.g.tab_item_textview);
        this.coD = (TextView) this.mRootView.findViewById(r.g.tab_item_red_tip);
    }

    public TextView getTextView() {
        return this.Wd;
    }

    public TextView getRedTipView() {
        return this.coD;
    }

    public void tm() {
        ar.k(this.coD, r.f.icon_news_down_bar_one);
    }
}
