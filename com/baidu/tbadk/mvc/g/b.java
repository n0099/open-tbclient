package com.baidu.tbadk.mvc.g;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.g.a;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class b<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends c<D, S, H> {
    private final Class<?>[] awK;
    private final int[] awL;

    public abstract int eI(int i);

    public b(TbPageContext<?> tbPageContext, Class<?>[] clsArr, int[] iArr, ViewEventCenter viewEventCenter) {
        super(tbPageContext, viewEventCenter);
        this.awK = clsArr;
        this.awL = iArr;
        if (clsArr == null || iArr == null || clsArr.length == 0 || iArr.length == 0 || clsArr.length != iArr.length) {
            throw new InvalidParameterException("BaseMulitiListAdapter new failed");
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.awR && Ef()) {
            return -1;
        }
        return eI(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return this.awK.length + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.awR && Ef()) {
            return Ee();
        }
        Ed();
        int itemViewType = getItemViewType(i);
        Class<?> cls = this.awK[itemViewType];
        int i2 = this.awL[itemViewType];
        if (cls == null) {
            throw new InvalidParameterException("BaseMulitiListAdapter holder class error");
        }
        if (i2 == 0) {
            throw new InvalidParameterException("BaseMulitiListAdapter holder layout error");
        }
        return a(view, i, cls, i2);
    }
}
