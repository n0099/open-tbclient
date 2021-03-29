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
import d.b.g0.a.k;
/* loaded from: classes4.dex */
public class BdContextMenuView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public b f14694e;

    /* renamed from: f  reason: collision with root package name */
    public Context f14695f;

    /* renamed from: g  reason: collision with root package name */
    public ListView f14696g;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BdContextMenuView.this.f14694e.a(i);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BaseAdapter {
        public abstract void a(int i);
    }

    static {
        boolean z = k.f45051a;
    }

    @SuppressLint({"NewApi"})
    public BdContextMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14695f = context;
        b();
    }

    public final void b() {
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setBackground(this.f14695f.getResources().getDrawable(R.drawable.aiapps_context_menu_bg));
        ListView listView = new ListView(this.f14695f);
        this.f14696g = listView;
        listView.setCacheColorHint(0);
        this.f14696g.setDivider(getResources().getDrawable(R.color.aiapps_context_menu_divider_color));
        this.f14696g.setDividerHeight(1);
        this.f14696g.setSelector(new ColorDrawable(0));
        addView(this.f14696g, new FrameLayout.LayoutParams(-1, -1));
        this.f14696g.setOnItemClickListener(new a());
    }

    public void setLayoutInCenter(boolean z) {
    }

    public BdContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14695f = context;
        b();
    }

    public BdContextMenuView(Context context) {
        super(context);
        this.f14695f = context;
        b();
    }
}
