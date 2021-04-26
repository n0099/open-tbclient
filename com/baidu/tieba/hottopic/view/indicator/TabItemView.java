package com.baidu.tieba.hottopic.view.indicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class TabItemView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f17704e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17705f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17706g;

    public TabItemView(Context context) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_tab_item_view, this);
        this.f17704e = inflate;
        this.f17705f = (TextView) inflate.findViewById(R.id.topic_tab_item_textview);
        this.f17706g = (TextView) this.f17704e.findViewById(R.id.topic_tab_item_red_tip);
    }

    public void a() {
        SkinManager.setBackgroundResource(this.f17706g, R.drawable.icon_news_down_bar_one);
    }

    public TextView getRedTipView() {
        return this.f17706g;
    }

    public TextView getTextView() {
        return this.f17705f;
    }
}
