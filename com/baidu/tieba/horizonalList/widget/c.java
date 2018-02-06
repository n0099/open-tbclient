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
    private List<d> aNc;
    private int avM;
    private f emS;
    public final ArrayList<f> emT = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public c(Context context, int i, f fVar) {
        this.mInflater = LayoutInflater.from(context);
        this.avM = i;
        this.emS = fVar;
    }

    public void setData(List<d> list) {
        this.aNc = list;
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
        return v.D(this.aNc);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.f(this.aNc, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.f(this.aNc, i) == null) {
            return -1L;
        }
        return ((d) v.f(this.aNc, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.avM, viewGroup, false);
            f bz = this.emS.bz(view);
            bz.setOnClickListener(this.mOnClickListener);
            view.setTag(bz);
            this.emT.add(bz);
        }
        f fVar = (f) view.getTag();
        if (v.f(this.aNc, i) != null) {
            a(fVar, this.aNc.get(i));
        }
        return fVar.getView();
    }

    private void a(f fVar, d dVar) {
        if (dVar != null && fVar != null) {
            fVar.a(dVar);
        }
    }

    public void gi(int i) {
        if (v.D(this.emT) > 0) {
            Iterator<f> it = this.emT.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
