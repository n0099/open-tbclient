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
    private int Hx;
    private List<d> Xm;
    private f duP;
    public final ArrayList<f> duQ = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public c(Context context, int i, f fVar) {
        this.mInflater = LayoutInflater.from(context);
        this.Hx = i;
        this.duP = fVar;
    }

    public void setData(List<d> list) {
        this.Xm = list;
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
        return v.v(this.Xm);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.Xm, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.c(this.Xm, i) == null) {
            return -1L;
        }
        return ((d) v.c(this.Xm, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.Hx, viewGroup, false);
            f ag = this.duP.ag(view);
            ag.setOnClickListener(this.mOnClickListener);
            view.setTag(ag);
            this.duQ.add(ag);
        }
        f fVar = (f) view.getTag();
        if (v.c(this.Xm, i) != null) {
            a(fVar, this.Xm.get(i));
        }
        return fVar.getView();
    }

    private void a(f fVar, d dVar) {
        if (dVar != null && fVar != null) {
            fVar.a(dVar);
        }
    }

    public void dj(int i) {
        if (v.v(this.duQ) > 0) {
            Iterator<f> it = this.duQ.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
