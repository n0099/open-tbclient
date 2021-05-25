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
    public View f16929e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16930f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16931g;

    public TabItemView(Context context) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_tab_item_view, this);
        this.f16929e = inflate;
        this.f16930f = (TextView) inflate.findViewById(R.id.topic_tab_item_textview);
        this.f16931g = (TextView) this.f16929e.findViewById(R.id.topic_tab_item_red_tip);
    }

    public void a() {
        SkinManager.setBackgroundResource(this.f16931g, R.drawable.icon_news_down_bar_one);
    }

    public TextView getRedTipView() {
        return this.f16931g;
    }

    public TextView getTextView() {
        return this.f16930f;
    }
}
