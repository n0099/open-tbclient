package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private int IF;
    private List<k> Wd;
    private m cAR;
    public final ArrayList<m> cAS = new ArrayList<>();
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;

    public j(Context context, int i, m mVar) {
        this.mInflater = LayoutInflater.from(context);
        this.IF = i;
        this.cAR = mVar;
    }

    public void setData(List<k> list) {
        this.Wd = list;
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
        return x.q(this.Wd);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return x.c(this.Wd, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (x.c(this.Wd, i) == null) {
            return -1L;
        }
        return ((k) x.c(this.Wd, i)).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.IF, viewGroup, false);
            m U = this.cAR.U(view);
            U.setOnClickListener(this.mOnClickListener);
            view.setTag(U);
            this.cAS.add(U);
        }
        m mVar = (m) view.getTag();
        if (x.c(this.Wd, i) != null) {
            a(mVar, this.Wd.get(i));
        }
        return mVar.getView();
    }

    private void a(m mVar, k kVar) {
        if (kVar != null && mVar != null) {
            mVar.a(kVar);
        }
    }

    public void db(int i) {
        if (x.q(this.cAS) > 0) {
            Iterator<m> it = this.cAS.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
