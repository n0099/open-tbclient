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
    private int JR;
    private List<d> XD;
    private f cYj;
    public final ArrayList<f> cYk = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public c(Context context, int i, f fVar) {
        this.mInflater = LayoutInflater.from(context);
        this.JR = i;
        this.cYj = fVar;
    }

    public void setData(List<d> list) {
        this.XD = list;
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
        return u.u(this.XD);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return u.c(this.XD, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (u.c(this.XD, i) == null) {
            return -1L;
        }
        return ((d) u.c(this.XD, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.JR, viewGroup, false);
            f V = this.cYj.V(view);
            V.setOnClickListener(this.mOnClickListener);
            view.setTag(V);
            this.cYk.add(V);
        }
        f fVar = (f) view.getTag();
        if (u.c(this.XD, i) != null) {
            a(fVar, this.XD.get(i));
        }
        return fVar.getView();
    }

    private void a(f fVar, d dVar) {
        if (dVar != null && fVar != null) {
            fVar.a(dVar);
        }
    }

    public void di(int i) {
        if (u.u(this.cYk) > 0) {
            Iterator<f> it = this.cYk.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
