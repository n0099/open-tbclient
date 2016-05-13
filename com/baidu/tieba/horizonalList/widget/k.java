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
    private int Aw;
    private List<l> avW;
    private n bTJ;
    public final ArrayList<n> bTK = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public k(Context context, int i, n nVar) {
        this.mInflater = LayoutInflater.from(context);
        this.Aw = i;
        this.bTJ = nVar;
    }

    public void setData(List<l> list) {
        this.avW = list;
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
        return y.r(this.avW);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return y.c(this.avW, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (y.c(this.avW, i) == null) {
            return -1L;
        }
        return ((l) y.c(this.avW, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.Aw, viewGroup, false);
            n S = this.bTJ.S(view);
            S.setOnClickListener(this.mOnClickListener);
            view.setTag(S);
            this.bTK.add(S);
        }
        n nVar = (n) view.getTag();
        if (y.c(this.avW, i) != null) {
            a(nVar, this.avW.get(i));
        }
        return nVar.getView();
    }

    private void a(n nVar, l lVar) {
        if (lVar != null && nVar != null) {
            nVar.a(lVar);
        }
    }

    public void cM(int i) {
        if (y.r(this.bTK) > 0) {
            Iterator<n> it = this.bTK.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
