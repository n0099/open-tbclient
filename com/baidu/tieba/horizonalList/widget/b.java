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
    private List<c> bzk;
    public final ArrayList<e> cyq = new ArrayList<>();
    private e fSw;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;
    private int mResourceId;

    public b(Context context, int i, e eVar) {
        this.mInflater = LayoutInflater.from(context);
        this.mResourceId = i;
        this.fSw = eVar;
    }

    public void setData(List<c> list) {
        this.bzk = list;
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
        return v.S(this.bzk);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.bzk, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.c(this.bzk, i) == null) {
            return -1L;
        }
        return ((c) v.c(this.bzk, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.mResourceId, viewGroup, false);
            e bv = this.fSw.bv(view);
            bv.setOnClickListener(this.mOnClickListener);
            view.setTag(bv);
            this.cyq.add(bv);
        }
        e eVar = (e) view.getTag();
        if (v.c(this.bzk, i) != null) {
            a(eVar, this.bzk.get(i));
        }
        return eVar.getView();
    }

    private void a(e eVar, c cVar) {
        if (cVar != null && eVar != null) {
            eVar.a(cVar);
        }
    }

    public void hM(int i) {
        if (v.S(this.cyq) > 0) {
            Iterator<e> it = this.cyq.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
