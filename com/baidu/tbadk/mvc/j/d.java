package com.baidu.tbadk.mvc.j;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.e.c;
import com.baidu.tbadk.mvc.j.a;
/* loaded from: classes.dex */
public class d<D, S extends com.baidu.tbadk.mvc.e.c, H extends a<D, S>> extends c<D, S, H> {
    private final Class<H> apd;
    private final int ape;

    public d(TbPageContext<?> tbPageContext, Class<H> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, viewEventCenter);
        this.ape = i;
        this.apd = cls;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return super.getViewTypeCount() + 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        if (this.aoW && CQ()) {
            return -1;
        }
        return super.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.aoW && CQ()) {
            return createNoDataView();
        }
        CP();
        return a(view, i, (Class<?>) this.apd, this.ape);
    }
}
