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
    private int Hy;
    private List<d> WW;
    private f dly;
    public final ArrayList<f> dlz = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public c(Context context, int i, f fVar) {
        this.mInflater = LayoutInflater.from(context);
        this.Hy = i;
        this.dly = fVar;
    }

    public void setData(List<d> list) {
        this.WW = list;
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
        return v.u(this.WW);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.WW, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.c(this.WW, i) == null) {
            return -1L;
        }
        return ((d) v.c(this.WW, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.Hy, viewGroup, false);
            f ae = this.dly.ae(view);
            ae.setOnClickListener(this.mOnClickListener);
            view.setTag(ae);
            this.dlz.add(ae);
        }
        f fVar = (f) view.getTag();
        if (v.c(this.WW, i) != null) {
            a(fVar, this.WW.get(i));
        }
        return fVar.getView();
    }

    private void a(f fVar, d dVar) {
        if (dVar != null && fVar != null) {
            fVar.a(dVar);
        }
    }

    public void dj(int i) {
        if (v.u(this.dlz) > 0) {
            Iterator<f> it = this.dlz.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
