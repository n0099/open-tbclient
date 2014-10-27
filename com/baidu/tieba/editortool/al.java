package com.baidu.tieba.editortool;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
/* loaded from: classes.dex */
public class al extends BaseAdapter {
    private final int RG;
    final /* synthetic */ PrivilegeTabContentView arA;
    private ao arz;
    private final int count;

    public al(PrivilegeTabContentView privilegeTabContentView, Context context, int i, int i2, ao aoVar) {
        this.arA = privilegeTabContentView;
        this.count = i;
        this.RG = i2;
        this.arz = aoVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.count;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.arz.getView(this.RG + i, view, viewGroup);
    }
}
