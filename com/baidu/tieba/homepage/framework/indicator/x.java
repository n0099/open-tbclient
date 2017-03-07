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
    private TextView aaE;
    private TextView cxe;
    private View mRootView;

    public x(Context context) {
        super(context);
        this.mRootView = LayoutInflater.from(context).inflate(w.j.tab_item_view, this);
        this.aaE = (TextView) this.mRootView.findViewById(w.h.tab_item_textview);
        this.cxe = (TextView) this.mRootView.findViewById(w.h.tab_item_red_tip);
    }

    public TextView getTextView() {
        return this.aaE;
    }

    public TextView getRedTipView() {
        return this.cxe;
    }

    public void tD() {
        aq.j(this.cxe, w.g.icon_news_down_bar_one);
    }
}
