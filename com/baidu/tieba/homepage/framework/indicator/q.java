package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class q extends RelativeLayout {
    private TextView SD;
    private TextView cpJ;
    private View mRootView;

    public q(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(u.h.tab_item_view, this);
        this.SD = (TextView) this.mRootView.findViewById(u.g.tab_item_textview);
        this.cpJ = (TextView) this.mRootView.findViewById(u.g.tab_item_red_tip);
    }

    public TextView getTextView() {
        return this.SD;
    }

    public TextView getRedTipView() {
        return this.cpJ;
    }

    public void se() {
        av.k(this.cpJ, u.f.icon_news_down_bar_one);
    }
}
