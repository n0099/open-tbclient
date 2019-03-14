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
public class b extends BaseAdapter {
    private List<c> bzg;
    public final ArrayList<e> cyn = new ArrayList<>();
    private e fSI;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;
    private int mResourceId;

    public b(Context context, int i, e eVar) {
        this.mInflater = LayoutInflater.from(context);
        this.mResourceId = i;
        this.fSI = eVar;
    }

    public void setData(List<c> list) {
        this.bzg = list;
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
        return v.S(this.bzg);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.bzg, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.c(this.bzg, i) == null) {
            return -1L;
        }
        return ((c) v.c(this.bzg, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.mResourceId, viewGroup, false);
            e bv = this.fSI.bv(view);
            bv.setOnClickListener(this.mOnClickListener);
            view.setTag(bv);
            this.cyn.add(bv);
        }
        e eVar = (e) view.getTag();
        if (v.c(this.bzg, i) != null) {
            a(eVar, this.bzg.get(i));
        }
        return eVar.getView();
    }

    private void a(e eVar, c cVar) {
        if (cVar != null && eVar != null) {
            eVar.a(cVar);
        }
    }

    public void hN(int i) {
        if (v.S(this.cyn) > 0) {
            Iterator<e> it = this.cyn.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
