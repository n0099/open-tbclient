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
    private int Hy;
    private List<d> Xp;
    private f dtG;
    public final ArrayList<f> dtH = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public c(Context context, int i, f fVar) {
        this.mInflater = LayoutInflater.from(context);
        this.Hy = i;
        this.dtG = fVar;
    }

    public void setData(List<d> list) {
        this.Xp = list;
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
        return v.v(this.Xp);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.Xp, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (v.c(this.Xp, i) == null) {
            return -1L;
        }
        return ((d) v.c(this.Xp, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.Hy, viewGroup, false);
            f af = this.dtG.af(view);
            af.setOnClickListener(this.mOnClickListener);
            view.setTag(af);
            this.dtH.add(af);
        }
        f fVar = (f) view.getTag();
        if (v.c(this.Xp, i) != null) {
            a(fVar, this.Xp.get(i));
        }
        return fVar.getView();
    }

    private void a(f fVar, d dVar) {
        if (dVar != null && fVar != null) {
            fVar.a(dVar);
        }
    }

    public void dj(int i) {
        if (v.v(this.dtH) > 0) {
            Iterator<f> it = this.dtH.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
