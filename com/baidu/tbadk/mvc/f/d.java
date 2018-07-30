package com.baidu.tbadk.mvc.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.a;
/* loaded from: classes.dex */
public class d<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends c<D, S, H> {
    private final Class<H> aTc;
    private final int aTd;

    public d(TbPageContext<?> tbPageContext, Class<H> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, viewEventCenter);
        this.aTd = i;
        this.aTc = cls;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return super.getViewTypeCount() + 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        if (this.aSV && Kf()) {
            return -1;
        }
        return super.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.aSV && Kf()) {
            return Ke();
        }
        Kd();
        return a(view, i, (Class<?>) this.aTc, this.aTd);
    }
}
