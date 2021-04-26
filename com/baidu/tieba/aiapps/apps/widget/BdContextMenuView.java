package com.baidu.tieba.aiapps.apps.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.baidu.tieba.R;
import d.a.h0.a.k;
/* loaded from: classes4.dex */
public class BdContextMenuView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public b f14423e;

    /* renamed from: f  reason: collision with root package name */
    public Context f14424f;

    /* renamed from: g  reason: collision with root package name */
    public ListView f14425g;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            BdContextMenuView.this.f14423e.a(i2);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BaseAdapter {
        public abstract void a(int i2);
    }

    static {
        boolean z = k.f43101a;
    }

    @SuppressLint({"NewApi"})
    public BdContextMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14424f = context;
        b();
    }

    public final void b() {
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setBackground(this.f14424f.getResources().getDrawable(R.drawable.aiapps_context_menu_bg));
        ListView listView = new ListView(this.f14424f);
        this.f14425g = listView;
        listView.setCacheColorHint(0);
        this.f14425g.setDivider(getResources().getDrawable(R.color.aiapps_context_menu_divider_color));
        this.f14425g.setDividerHeight(1);
        this.f14425g.setSelector(new ColorDrawable(0));
        addView(this.f14425g, new FrameLayout.LayoutParams(-1, -1));
        this.f14425g.setOnItemClickListener(new a());
    }

    public void setLayoutInCenter(boolean z) {
    }

    public BdContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14424f = context;
        b();
    }

    public BdContextMenuView(Context context) {
        super(context);
        this.f14424f = context;
        b();
    }
}
