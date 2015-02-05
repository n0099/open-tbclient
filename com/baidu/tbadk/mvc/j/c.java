package com.baidu.tbadk.mvc.j;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.e.c;
import com.baidu.tbadk.mvc.j.a;
/* loaded from: classes.dex */
public class c<D, S extends com.baidu.tbadk.mvc.e.c, H extends a<D, S>> extends b<D, S, H> {
    private final Class<H> afw;
    private final int afx;

    public c(TbPageContext<?> tbPageContext, Class<H> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, viewEventCenter);
        this.afx = i;
        this.afw = cls;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return super.getViewTypeCount() + 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        if (this.afp && yK()) {
            return -1;
        }
        return super.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.afp && yK()) {
            return yJ();
        }
        yI();
        return a(view, i, (Class<?>) this.afw, this.afx);
    }
}
