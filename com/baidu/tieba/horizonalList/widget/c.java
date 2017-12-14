package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private int Hw;
    private List<d> Xj;
    private f duL;
    public final ArrayList<f> duM = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public c(Context context, int i, f fVar) {
        this.mInflater = LayoutInflater.from(context);
        this.Hw = i;
        this.duL = fVar;
    }

    public void setData(List<d> list) {
        this.Xj = list;
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
        return v.v(this.Xj);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.Xj, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.c(this.Xj, i) == null) {
            return -1L;
        }
        return ((d) v.c(this.Xj, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.Hw, viewGroup, false);
            f ag = this.duL.ag(view);
            ag.setOnClickListener(this.mOnClickListener);
            view.setTag(ag);
            this.duM.add(ag);
        }
        f fVar = (f) view.getTag();
        if (v.c(this.Xj, i) != null) {
            a(fVar, this.Xj.get(i));
        }
        return fVar.getView();
    }

    private void a(f fVar, d dVar) {
        if (dVar != null && fVar != null) {
            fVar.a(dVar);
        }
    }

    public void dj(int i) {
        if (v.v(this.duM) > 0) {
            Iterator<f> it = this.duM.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
