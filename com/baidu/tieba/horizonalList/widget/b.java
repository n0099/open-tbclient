package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private List<c> agd;
    public final ArrayList<e> bbd = new ArrayList<>();
    private e ebz;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;
    private int mResourceId;

    public b(Context context, int i, e eVar) {
        this.mInflater = LayoutInflater.from(context);
        this.mResourceId = i;
        this.ebz = eVar;
    }

    public void setData(List<c> list) {
        this.agd = list;
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
        return w.y(this.agd);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return w.d(this.agd, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (w.d(this.agd, i) == null) {
            return -1L;
        }
        return ((c) w.d(this.agd, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.mResourceId, viewGroup, false);
            e ai = this.ebz.ai(view);
            ai.setOnClickListener(this.mOnClickListener);
            view.setTag(ai);
            this.bbd.add(ai);
        }
        e eVar = (e) view.getTag();
        if (w.d(this.agd, i) != null) {
            a(eVar, this.agd.get(i));
        }
        return eVar.getView();
    }

    private void a(e eVar, c cVar) {
        if (cVar != null && eVar != null) {
            eVar.a(cVar);
        }
    }

    public void dn(int i) {
        if (w.y(this.bbd) > 0) {
            Iterator<e> it = this.bbd.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
