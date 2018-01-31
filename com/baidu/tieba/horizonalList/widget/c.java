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
    private List<d> aLJ;
    private int avR;
    private f eiI;
    public final ArrayList<f> eiJ = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public c(Context context, int i, f fVar) {
        this.mInflater = LayoutInflater.from(context);
        this.avR = i;
        this.eiI = fVar;
    }

    public void setData(List<d> list) {
        this.aLJ = list;
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
        return v.D(this.aLJ);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.f(this.aLJ, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.f(this.aLJ, i) == null) {
            return -1L;
        }
        return ((d) v.f(this.aLJ, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.avR, viewGroup, false);
            f bA = this.eiI.bA(view);
            bA.setOnClickListener(this.mOnClickListener);
            view.setTag(bA);
            this.eiJ.add(bA);
        }
        f fVar = (f) view.getTag();
        if (v.f(this.aLJ, i) != null) {
            a(fVar, this.aLJ.get(i));
        }
        return fVar.getView();
    }

    private void a(f fVar, d dVar) {
        if (dVar != null && fVar != null) {
            fVar.a(dVar);
        }
    }

    public void gg(int i) {
        if (v.D(this.eiJ) > 0) {
            Iterator<f> it = this.eiJ.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
