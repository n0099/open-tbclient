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
    private int Jo;
    private List<l> aFa;
    private n cGH;
    public final ArrayList<n> cGI = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public k(Context context, int i, n nVar) {
        this.mInflater = LayoutInflater.from(context);
        this.Jo = i;
        this.cGH = nVar;
    }

    public void setData(List<l> list) {
        this.aFa = list;
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
        return x.p(this.aFa);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return x.c(this.aFa, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (x.c(this.aFa, i) == null) {
            return -1L;
        }
        return ((l) x.c(this.aFa, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.Jo, viewGroup, false);
            n V = this.cGH.V(view);
            V.setOnClickListener(this.mOnClickListener);
            view.setTag(V);
            this.cGI.add(V);
        }
        n nVar = (n) view.getTag();
        if (x.c(this.aFa, i) != null) {
            a(nVar, this.aFa.get(i));
        }
        return nVar.getView();
    }

    private void a(n nVar, l lVar) {
        if (lVar != null && nVar != null) {
            nVar.a(lVar);
        }
    }

    public void df(int i) {
        if (x.p(this.cGI) > 0) {
            Iterator<n> it = this.cGI.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
