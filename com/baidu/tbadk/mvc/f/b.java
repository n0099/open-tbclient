package com.baidu.tbadk.mvc.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.a;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class b<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends c<D, S, H> {
    private final Class<?>[] fug;
    private final int[] fuh;

    public abstract int rG(int i);

    public b(TbPageContext<?> tbPageContext, Class<?>[] clsArr, int[] iArr, ViewEventCenter viewEventCenter) {
        super(tbPageContext, viewEventCenter);
        this.fug = clsArr;
        this.fuh = iArr;
        if (clsArr == null || iArr == null || clsArr.length == 0 || iArr.length == 0 || clsArr.length != iArr.length) {
            throw new InvalidParameterException("BaseMulitiListAdapter new failed");
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fum && bBW()) {
            return -1;
        }
        return rG(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return this.fug.length + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.fum && bBW()) {
            return bBV();
        }
        bBU();
        int itemViewType = getItemViewType(i);
        Class<?> cls = this.fug[itemViewType];
        int i2 = this.fuh[itemViewType];
        if (cls == null) {
            throw new InvalidParameterException("BaseMulitiListAdapter holder class error");
        }
        if (i2 == 0) {
            throw new InvalidParameterException("BaseMulitiListAdapter holder layout error");
        }
        return a(view, i, cls, i2);
    }
}
