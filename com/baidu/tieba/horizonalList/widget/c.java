package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private int Ir;
    private List<d> Wh;
    private f cWQ;
    public final ArrayList<f> cWR = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public c(Context context, int i, f fVar) {
        this.mInflater = LayoutInflater.from(context);
        this.Ir = i;
        this.cWQ = fVar;
    }

    public void setData(List<d> list) {
        this.Wh = list;
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
        return u.u(this.Wh);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return u.c(this.Wh, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (u.c(this.Wh, i) == null) {
            return -1L;
        }
        return ((d) u.c(this.Wh, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.Ir, viewGroup, false);
            f V = this.cWQ.V(view);
            V.setOnClickListener(this.mOnClickListener);
            view.setTag(V);
            this.cWR.add(V);
        }
        f fVar = (f) view.getTag();
        if (u.c(this.Wh, i) != null) {
            a(fVar, this.Wh.get(i));
        }
        return fVar.getView();
    }

    private void a(f fVar, d dVar) {
        if (dVar != null && fVar != null) {
            fVar.a(dVar);
        }
    }

    public void dg(int i) {
        if (u.u(this.cWR) > 0) {
            Iterator<f> it = this.cWR.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
