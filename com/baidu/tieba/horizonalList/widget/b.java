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
    private List<c> cLa;
    public final ArrayList<e> dGw = new ArrayList<>();
    private e hei;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;
    private int mResourceId;

    public b(Context context, int i, e eVar) {
        this.mInflater = LayoutInflater.from(context);
        this.mResourceId = i;
        this.hei = eVar;
    }

    public void setData(List<c> list) {
        this.cLa = list;
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
        return v.getCount(this.cLa);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.getItem(this.cLa, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.getItem(this.cLa, i) == null) {
            return -1L;
        }
        return ((c) v.getItem(this.cLa, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.mResourceId, viewGroup, false);
            e by = this.hei.by(view);
            by.setOnClickListener(this.mOnClickListener);
            view.setTag(by);
            this.dGw.add(by);
        }
        e eVar = (e) view.getTag();
        if (v.getItem(this.cLa, i) != null) {
            a(eVar, this.cLa.get(i));
        }
        return eVar.getView();
    }

    private void a(e eVar, c cVar) {
        if (cVar != null && eVar != null) {
            eVar.a(cVar);
        }
    }

    public void onSkinTypeChanged(int i) {
        if (v.getCount(this.dGw) > 0) {
            Iterator<e> it = this.dGw.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
