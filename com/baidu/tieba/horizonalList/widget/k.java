package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    private int Cw;
    private List<l> azp;
    private n cEv;
    public final ArrayList<n> cEw = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public k(Context context, int i, n nVar) {
        this.mInflater = LayoutInflater.from(context);
        this.Cw = i;
        this.cEv = nVar;
    }

    public void setData(List<l> list) {
        this.azp = list;
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
        return w.r(this.azp);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return w.c(this.azp, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (w.c(this.azp, i) == null) {
            return -1L;
        }
        return ((l) w.c(this.azp, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.Cw, viewGroup, false);
            n X = this.cEv.X(view);
            X.setOnClickListener(this.mOnClickListener);
            view.setTag(X);
            this.cEw.add(X);
        }
        n nVar = (n) view.getTag();
        if (w.c(this.azp, i) != null) {
            a(nVar, this.azp.get(i));
        }
        return nVar.getView();
    }

    private void a(n nVar, l lVar) {
        if (lVar != null && nVar != null) {
            nVar.a(lVar);
        }
    }

    public void dg(int i) {
        if (w.r(this.cEw) > 0) {
            Iterator<n> it = this.cEw.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
