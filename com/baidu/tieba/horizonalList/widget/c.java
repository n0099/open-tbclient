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
    private int HM;
    private List<d> WP;
    private f dgQ;
    public final ArrayList<f> dgR = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public c(Context context, int i, f fVar) {
        this.mInflater = LayoutInflater.from(context);
        this.HM = i;
        this.dgQ = fVar;
    }

    public void setData(List<d> list) {
        this.WP = list;
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
        return v.u(this.WP);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.WP, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.c(this.WP, i) == null) {
            return -1L;
        }
        return ((d) v.c(this.WP, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.HM, viewGroup, false);
            f ac = this.dgQ.ac(view);
            ac.setOnClickListener(this.mOnClickListener);
            view.setTag(ac);
            this.dgR.add(ac);
        }
        f fVar = (f) view.getTag();
        if (v.c(this.WP, i) != null) {
            a(fVar, this.WP.get(i));
        }
        return fVar.getView();
    }

    private void a(f fVar, d dVar) {
        if (dVar != null && fVar != null) {
            fVar.a(dVar);
        }
    }

    public void dj(int i) {
        if (v.u(this.dgR) > 0) {
            Iterator<f> it = this.dgR.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
