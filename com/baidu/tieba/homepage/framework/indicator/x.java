package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class x extends RelativeLayout {
    private TextView Tl;
    private TextView csi;
    private View mRootView;

    public x(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(u.h.tab_item_view, this);
        this.Tl = (TextView) this.mRootView.findViewById(u.g.tab_item_textview);
        this.csi = (TextView) this.mRootView.findViewById(u.g.tab_item_red_tip);
    }

    public TextView getTextView() {
        return this.Tl;
    }

    public TextView getRedTipView() {
        return this.csi;
    }

    public void sd() {
        av.k(this.csi, u.f.icon_news_down_bar_one);
    }
}
