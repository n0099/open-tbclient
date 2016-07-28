package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    private int AY;
    private List<l> axA;
    private n cAy;
    public final ArrayList<n> cAz = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public k(Context context, int i, n nVar) {
        this.mInflater = LayoutInflater.from(context);
        this.AY = i;
        this.cAy = nVar;
    }

    public void setData(List<l> list) {
        this.axA = list;
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
        return y.s(this.axA);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return y.c(this.axA, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (y.c(this.axA, i) == null) {
            return -1L;
        }
        return ((l) y.c(this.axA, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.AY, viewGroup, false);
            n T = this.cAy.T(view);
            T.setOnClickListener(this.mOnClickListener);
            view.setTag(T);
            this.cAz.add(T);
        }
        n nVar = (n) view.getTag();
        if (y.c(this.axA, i) != null) {
            a(nVar, this.axA.get(i));
        }
        return nVar.getView();
    }

    private void a(n nVar, l lVar) {
        if (lVar != null && nVar != null) {
            nVar.a(lVar);
        }
    }

    public void cO(int i) {
        if (y.s(this.cAz) > 0) {
            Iterator<n> it = this.cAz.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
