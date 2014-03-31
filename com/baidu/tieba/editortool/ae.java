package com.baidu.tieba.editortool;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
/* loaded from: classes.dex */
public final class ae extends BaseAdapter {
    final /* synthetic */ PrivilegeTabContentView a;
    private final int b;
    private final int c;
    private ah d;

    public ae(PrivilegeTabContentView privilegeTabContentView, int i, int i2, ah ahVar) {
        this.a = privilegeTabContentView;
        this.b = i;
        this.c = i2;
        this.d = ahVar;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.d.a(this.c + i, view);
    }
}
