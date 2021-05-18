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
import d.a.i0.a.k;
import d.a.i0.a.z1.b.e.a;
/* loaded from: classes4.dex */
public class BdContextMenuView extends FrameLayout implements a.g {

    /* renamed from: e  reason: collision with root package name */
    public b f13746e;

    /* renamed from: f  reason: collision with root package name */
    public Context f13747f;

    /* renamed from: g  reason: collision with root package name */
    public ListView f13748g;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            BdContextMenuView.this.f13746e.a(i2);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BaseAdapter {
        public abstract void a(int i2);
    }

    static {
        boolean z = k.f43025a;
    }

    @SuppressLint({"NewApi"})
    public BdContextMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13747f = context;
        b();
    }

    public final void b() {
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setBackground(this.f13747f.getResources().getDrawable(R.drawable.aiapps_context_menu_bg));
        ListView listView = new ListView(this.f13747f);
        this.f13748g = listView;
        listView.setCacheColorHint(0);
        this.f13748g.setDivider(getResources().getDrawable(R.color.aiapps_context_menu_divider_color));
        this.f13748g.setDividerHeight(1);
        this.f13748g.setSelector(new ColorDrawable(0));
        addView(this.f13748g, new FrameLayout.LayoutParams(-1, -1));
        this.f13748g.setOnItemClickListener(new a());
    }

    public void setLayoutInCenter(boolean z) {
    }

    public BdContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13747f = context;
        b();
    }

    public BdContextMenuView(Context context) {
        super(context);
        this.f13747f = context;
        b();
    }
}
