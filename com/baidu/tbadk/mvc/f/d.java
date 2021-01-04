package com.baidu.tbadk.mvc.f;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.mvc.d.b;
import com.baidu.tbadk.mvc.f.a;
/* loaded from: classes.dex */
public class d<D, S extends com.baidu.tbadk.mvc.d.b, H extends a<D, S>> extends c<D, S, H> {
    private final Class<H> fKU;
    private final int fKV;

    public d(TbPageContext<?> tbPageContext, Class<H> cls, int i, ViewEventCenter viewEventCenter) {
        super(tbPageContext, viewEventCenter);
        this.fKV = i;
        this.fKU = cls;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return super.getViewTypeCount() + 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        if (this.fKN && isDataEmpty()) {
            return -1;
        }
        return super.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.fKN && isDataEmpty()) {
            return bHh();
        }
        bHg();
        return a(view, i, (Class<?>) this.fKU, this.fKV);
    }
}
