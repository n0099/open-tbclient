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
    private int Jm;
    private List<l> aEY;
    private n cEq;
    public final ArrayList<n> cEr = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public k(Context context, int i, n nVar) {
        this.mInflater = LayoutInflater.from(context);
        this.Jm = i;
        this.cEq = nVar;
    }

    public void setData(List<l> list) {
        this.aEY = list;
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
        return x.p(this.aEY);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return x.c(this.aEY, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (x.c(this.aEY, i) == null) {
            return -1L;
        }
        return ((l) x.c(this.aEY, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.Jm, viewGroup, false);
            n V = this.cEq.V(view);
            V.setOnClickListener(this.mOnClickListener);
            view.setTag(V);
            this.cEr.add(V);
        }
        n nVar = (n) view.getTag();
        if (x.c(this.aEY, i) != null) {
            a(nVar, this.aEY.get(i));
        }
        return nVar.getView();
    }

    private void a(n nVar, l lVar) {
        if (lVar != null && nVar != null) {
            nVar.a(lVar);
        }
    }

    public void df(int i) {
        if (x.p(this.cEr) > 0) {
            Iterator<n> it = this.cEr.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
