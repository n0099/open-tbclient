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
    private int GC;
    private List<c> Yt;
    public final ArrayList<e> aSg = new ArrayList<>();
    private e dIC;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public b(Context context, int i, e eVar) {
        this.mInflater = LayoutInflater.from(context);
        this.GC = i;
        this.dIC = eVar;
    }

    public void setData(List<c> list) {
        this.Yt = list;
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
        return v.v(this.Yt);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.Yt, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.c(this.Yt, i) == null) {
            return -1L;
        }
        return ((c) v.c(this.Yt, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        if (view2 == null) {
            view2 = this.mInflater.inflate(this.GC, viewGroup, false);
            e ad = this.dIC.ad(view2);
            ad.setOnClickListener(this.mOnClickListener);
            view2.setTag(ad);
            this.aSg.add(ad);
        }
        e eVar = (e) view2.getTag();
        if (v.c(this.Yt, i) != null) {
            a(eVar, this.Yt.get(i));
        }
        return eVar.getView();
    }

    private void a(e eVar, c cVar) {
        if (cVar != null && eVar != null) {
            eVar.a(cVar);
        }
    }

    public void di(int i) {
        if (v.v(this.aSg) > 0) {
            Iterator<e> it = this.aSg.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
