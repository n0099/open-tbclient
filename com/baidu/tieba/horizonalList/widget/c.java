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
    private int JT;
    private List<d> XG;
    private f dai;
    public final ArrayList<f> daj = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public c(Context context, int i, f fVar) {
        this.mInflater = LayoutInflater.from(context);
        this.JT = i;
        this.dai = fVar;
    }

    public void setData(List<d> list) {
        this.XG = list;
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
        return u.u(this.XG);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return u.c(this.XG, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (u.c(this.XG, i) == null) {
            return -1L;
        }
        return ((d) u.c(this.XG, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.JT, viewGroup, false);
            f U = this.dai.U(view);
            U.setOnClickListener(this.mOnClickListener);
            view.setTag(U);
            this.daj.add(U);
        }
        f fVar = (f) view.getTag();
        if (u.c(this.XG, i) != null) {
            a(fVar, this.XG.get(i));
        }
        return fVar.getView();
    }

    private void a(f fVar, d dVar) {
        if (dVar != null && fVar != null) {
            fVar.a(dVar);
        }
    }

    public void di(int i) {
        if (u.u(this.daj) > 0) {
            Iterator<f> it = this.daj.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
