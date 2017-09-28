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
    private int Id;
    private List<d> WQ;
    private f ddY;
    public final ArrayList<f> ddZ = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public c(Context context, int i, f fVar) {
        this.mInflater = LayoutInflater.from(context);
        this.Id = i;
        this.ddY = fVar;
    }

    public void setData(List<d> list) {
        this.WQ = list;
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
        return v.t(this.WQ);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.WQ, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.c(this.WQ, i) == null) {
            return -1L;
        }
        return ((d) v.c(this.WQ, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.Id, viewGroup, false);
            f ab = this.ddY.ab(view);
            ab.setOnClickListener(this.mOnClickListener);
            view.setTag(ab);
            this.ddZ.add(ab);
        }
        f fVar = (f) view.getTag();
        if (v.c(this.WQ, i) != null) {
            a(fVar, this.WQ.get(i));
        }
        return fVar.getView();
    }

    private void a(f fVar, d dVar) {
        if (dVar != null && fVar != null) {
            fVar.a(dVar);
        }
    }

    public void dj(int i) {
        if (v.t(this.ddZ) > 0) {
            Iterator<f> it = this.ddZ.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
