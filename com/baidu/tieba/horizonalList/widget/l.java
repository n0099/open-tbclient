package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class l extends ArrayAdapter {
    private int JK;
    private final ArrayList<p> aDQ;
    private List<n> ayw;
    private p bFA;
    private View.OnTouchListener bFB;
    private int bFz;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public l(Context context, int i, p pVar, List<String> list) {
        super(context, i, list);
        this.aDQ = new ArrayList<>();
        this.mSkinType = 3;
        this.bFB = new m(this);
        this.mInflater = LayoutInflater.from(context);
        this.bFz = pVar.bFE;
        this.JK = i;
        this.bFA = pVar;
    }

    public void setData(List<n> list) {
        this.ayw = list;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return getItem(i).hashCode();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.mInflater.inflate(this.JK, viewGroup, false);
            p y = this.bFA.y(view);
            y.setOnClickListener(this.mOnClickListener);
            view.setTag(y);
        }
        p pVar = (p) view.getTag();
        view.setOnTouchListener(this.bFB);
        a(pVar, this.ayw.get(i), i);
        return pVar.getView();
    }

    private void a(p pVar, n nVar, int i) {
        if (nVar != null && pVar != null) {
            pVar.a(nVar);
            this.aDQ.add(pVar);
            if (TbadkCoreApplication.m411getInst().getSkinType() != pVar.ahf) {
                pVar.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void cK(int i) {
        if (i != this.mSkinType && y.l(this.aDQ) > 0) {
            Iterator<p> it = this.aDQ.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
