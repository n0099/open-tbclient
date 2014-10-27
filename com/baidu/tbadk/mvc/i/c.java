package com.baidu.tbadk.mvc.i;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.e.c;
import com.baidu.tbadk.mvc.i.a;
/* loaded from: classes.dex */
public class c<D, S extends com.baidu.tbadk.mvc.e.c, H extends a<D, S>> extends b<D, S, H> {
    private final Class<H> Yp;
    private final int Yq;

    public c(Activity activity, Class<H> cls, int i, ViewEventCenter viewEventCenter) {
        super(activity, viewEventCenter);
        this.Yq = i;
        this.Yp = cls;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return super.getViewTypeCount() + 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        if (this.Yi && um()) {
            return -1;
        }
        return super.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return (this.Yi && um()) ? ul() : a(view, i, (Class<?>) this.Yp, this.Yq);
    }
}
