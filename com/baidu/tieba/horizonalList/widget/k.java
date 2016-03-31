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
    private int Kf;
    public final ArrayList<n> aGb = new ArrayList<>();
    private List<l> azT;
    private n bTi;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public k(Context context, int i, n nVar) {
        this.mInflater = LayoutInflater.from(context);
        this.Kf = i;
        this.bTi = nVar;
    }

    public void setData(List<l> list) {
        this.azT = list;
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
        return y.p(this.azT);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return y.b(this.azT, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (y.b(this.azT, i) == null) {
            return -1L;
        }
        return ((l) y.b(this.azT, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.Kf, viewGroup, false);
            n Q = this.bTi.Q(view);
            Q.setOnClickListener(this.mOnClickListener);
            view.setTag(Q);
            this.aGb.add(Q);
        }
        n nVar = (n) view.getTag();
        if (y.b(this.azT, i) != null) {
            a(nVar, this.azT.get(i));
        }
        return nVar.getView();
    }

    private void a(n nVar, l lVar) {
        if (lVar != null && nVar != null) {
            nVar.a(lVar);
        }
    }

    public void de(int i) {
        if (y.p(this.aGb) > 0) {
            Iterator<n> it = this.aGb.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
