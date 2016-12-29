package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    private int Dl;
    private List<l> aAw;
    private n cxr;
    public final ArrayList<n> cxs = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public k(Context context, int i, n nVar) {
        this.mInflater = LayoutInflater.from(context);
        this.Dl = i;
        this.cxr = nVar;
    }

    public void setData(List<l> list) {
        this.aAw = list;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return x.s(this.aAw);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return x.c(this.aAw, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (x.c(this.aAw, i) == null) {
            return -1L;
        }
        return ((l) x.c(this.aAw, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.Dl, viewGroup, false);
            n T = this.cxr.T(view);
            T.setOnClickListener(this.mOnClickListener);
            view.setTag(T);
            this.cxs.add(T);
        }
        n nVar = (n) view.getTag();
        if (x.c(this.aAw, i) != null) {
            a(nVar, this.aAw.get(i));
        }
        return nVar.getView();
    }

    private void a(n nVar, l lVar) {
        if (lVar != null && nVar != null) {
            nVar.a(lVar);
        }
    }

    public void df(int i) {
        if (x.s(this.cxs) > 0) {
            Iterator<n> it = this.cxs.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
