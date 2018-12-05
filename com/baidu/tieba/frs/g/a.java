package com.baidu.tieba.frs.g;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a<T extends h> extends BaseAdapter {
    private List<T> data;
    private TbPageContext ekr;

    protected abstract View d(int i, View view, ViewGroup viewGroup);

    public a(@NonNull TbPageContext tbPageContext) {
        this.ekr = tbPageContext;
    }

    public void setData(@NonNull List<T> list) {
        this.data = list;
        notifyDataSetChanged();
    }

    @NonNull
    public Context getContext() {
        return this.ekr.getPageActivity();
    }

    public TbPageContext aIM() {
        return this.ekr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.H(this.data);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public T getItem(int i) {
        return (T) v.d(this.data, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return d(i, view, viewGroup);
    }
}
