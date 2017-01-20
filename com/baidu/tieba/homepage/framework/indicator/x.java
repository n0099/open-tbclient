package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class x extends RelativeLayout {
    private TextView Vt;
    private TextView cvF;
    private View mRootView;

    public x(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(r.j.tab_item_view, this);
        this.Vt = (TextView) this.mRootView.findViewById(r.h.tab_item_textview);
        this.cvF = (TextView) this.mRootView.findViewById(r.h.tab_item_red_tip);
    }

    public TextView getTextView() {
        return this.Vt;
    }

    public TextView getRedTipView() {
        return this.cvF;
    }

    public void tg() {
        ap.j((View) this.cvF, r.g.icon_news_down_bar_one);
    }
}
