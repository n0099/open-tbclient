package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private int Ir;
    private List<k> VR;
    private m cOm;
    public final ArrayList<m> cOn = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public j(Context context, int i, m mVar) {
        this.mInflater = LayoutInflater.from(context);
        this.Ir = i;
        this.cOm = mVar;
    }

    public void setData(List<k> list) {
        this.VR = list;
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
        return z.s(this.VR);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return z.c(this.VR, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (z.c(this.VR, i) == null) {
            return -1L;
        }
        return ((k) z.c(this.VR, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.Ir, viewGroup, false);
            m V = this.cOm.V(view);
            V.setOnClickListener(this.mOnClickListener);
            view.setTag(V);
            this.cOn.add(V);
        }
        m mVar = (m) view.getTag();
        if (z.c(this.VR, i) != null) {
            a(mVar, this.VR.get(i));
        }
        return mVar.getView();
    }

    private void a(m mVar, k kVar) {
        if (kVar != null && mVar != null) {
            mVar.a(kVar);
        }
    }

    public void de(int i) {
        if (z.s(this.cOn) > 0) {
            Iterator<m> it = this.cOn.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
