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
    private int Ie;
    private List<d> WE;
    private f ddL;
    public final ArrayList<f> ddM = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public c(Context context, int i, f fVar) {
        this.mInflater = LayoutInflater.from(context);
        this.Ie = i;
        this.ddL = fVar;
    }

    public void setData(List<d> list) {
        this.WE = list;
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
        return v.t(this.WE);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.WE, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.c(this.WE, i) == null) {
            return -1L;
        }
        return ((d) v.c(this.WE, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.Ie, viewGroup, false);
            f ab = this.ddL.ab(view);
            ab.setOnClickListener(this.mOnClickListener);
            view.setTag(ab);
            this.ddM.add(ab);
        }
        f fVar = (f) view.getTag();
        if (v.c(this.WE, i) != null) {
            a(fVar, this.WE.get(i));
        }
        return fVar.getView();
    }

    private void a(f fVar, d dVar) {
        if (dVar != null && fVar != null) {
            fVar.a(dVar);
        }
    }

    public void di(int i) {
        if (v.t(this.ddM) > 0) {
            Iterator<f> it = this.ddM.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
