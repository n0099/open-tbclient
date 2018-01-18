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
    private List<d> aLG;
    private int avO;
    private f ein;
    public final ArrayList<f> eio = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public c(Context context, int i, f fVar) {
        this.mInflater = LayoutInflater.from(context);
        this.avO = i;
        this.ein = fVar;
    }

    public void setData(List<d> list) {
        this.aLG = list;
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
        return v.D(this.aLG);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.f(this.aLG, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.f(this.aLG, i) == null) {
            return -1L;
        }
        return ((d) v.f(this.aLG, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.avO, viewGroup, false);
            f bA = this.ein.bA(view);
            bA.setOnClickListener(this.mOnClickListener);
            view.setTag(bA);
            this.eio.add(bA);
        }
        f fVar = (f) view.getTag();
        if (v.f(this.aLG, i) != null) {
            a(fVar, this.aLG.get(i));
        }
        return fVar.getView();
    }

    private void a(f fVar, d dVar) {
        if (dVar != null && fVar != null) {
            fVar.a(dVar);
        }
    }

    public void gg(int i) {
        if (v.D(this.eio) > 0) {
            Iterator<f> it = this.eio.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
