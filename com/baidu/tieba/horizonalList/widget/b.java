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
    private List<c> aiE;
    public final ArrayList<e> bew = new ArrayList<>();
    private e eiR;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;
    private int mResourceId;

    public b(Context context, int i, e eVar) {
        this.mInflater = LayoutInflater.from(context);
        this.mResourceId = i;
        this.eiR = eVar;
    }

    public void setData(List<c> list) {
        this.aiE = list;
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
        return v.y(this.aiE);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.d(this.aiE, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.d(this.aiE, i) == null) {
            return -1L;
        }
        return ((c) v.d(this.aiE, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.mResourceId, viewGroup, false);
            e aw = this.eiR.aw(view);
            aw.setOnClickListener(this.mOnClickListener);
            view.setTag(aw);
            this.bew.add(aw);
        }
        e eVar = (e) view.getTag();
        if (v.d(this.aiE, i) != null) {
            a(eVar, this.aiE.get(i));
        }
        return eVar.getView();
    }

    private void a(e eVar, c cVar) {
        if (cVar != null && eVar != null) {
            eVar.a(cVar);
        }
    }

    public void dx(int i) {
        if (v.y(this.bew) > 0) {
            Iterator<e> it = this.bew.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
