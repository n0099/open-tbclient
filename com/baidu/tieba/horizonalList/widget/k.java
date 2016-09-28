package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    private int Dk;
    private List<l> aAk;
    private n cMU;
    public final ArrayList<n> cMV = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public k(Context context, int i, n nVar) {
        this.mInflater = LayoutInflater.from(context);
        this.Dk = i;
        this.cMU = nVar;
    }

    public void setData(List<l> list) {
        this.aAk = list;
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
        return y.s(this.aAk);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return y.c(this.aAk, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (y.c(this.aAk, i) == null) {
            return -1L;
        }
        return ((l) y.c(this.aAk, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.Dk, viewGroup, false);
            n S = this.cMU.S(view);
            S.setOnClickListener(this.mOnClickListener);
            view.setTag(S);
            this.cMV.add(S);
        }
        n nVar = (n) view.getTag();
        if (y.c(this.aAk, i) != null) {
            a(nVar, this.aAk.get(i));
        }
        return nVar.getView();
    }

    private void a(n nVar, l lVar) {
        if (lVar != null && nVar != null) {
            nVar.a(lVar);
        }
    }

    public void dc(int i) {
        if (y.s(this.cMV) > 0) {
            Iterator<n> it = this.cMV.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
