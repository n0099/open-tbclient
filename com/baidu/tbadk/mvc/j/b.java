package com.baidu.tbadk.mvc.j;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.e.c;
import com.baidu.tbadk.mvc.j.a;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public abstract class b<D, S extends com.baidu.tbadk.mvc.e.c, H extends a<D, S>> extends c<D, S, H> {
    private final Class<?>[] anE;
    private final int[] anF;

    public abstract int dS(int i);

    public b(TbPageContext<?> tbPageContext, Class<?>[] clsArr, int[] iArr, ViewEventCenter viewEventCenter) {
        super(tbPageContext, viewEventCenter);
        this.anE = clsArr;
        this.anF = iArr;
        if (clsArr == null || iArr == null || clsArr.length == 0 || iArr.length == 0 || clsArr.length != iArr.length) {
            throw new InvalidParameterException("BaseMulitiListAdapter new failed");
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.anL && BY()) {
            return -1;
        }
        return dS(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return this.anE.length + 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.anL && BY()) {
            return BX();
        }
        BW();
        int itemViewType = getItemViewType(i);
        Class<?> cls = this.anE[itemViewType];
        int i2 = this.anF[itemViewType];
        if (cls == null) {
            throw new InvalidParameterException("BaseMulitiListAdapter holder class error");
        }
        if (i2 == 0) {
            throw new InvalidParameterException("BaseMulitiListAdapter holder layout error");
        }
        return a(view, i, cls, i2);
    }
}
