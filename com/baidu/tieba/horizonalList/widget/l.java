package com.baidu.tieba.horizonalList.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class l extends ArrayAdapter {
    private int JZ;
    private final ArrayList<o> aEG;
    private List<m> azm;
    private int bIL;
    private o bIM;
    private LayoutInflater mInflater;
    private View.OnClickListener mOnClickListener;
    private int mSkinType;

    public l(Context context, int i, o oVar, List<String> list) {
        super(context, i, list);
        this.aEG = new ArrayList<>();
        this.mSkinType = 3;
        this.mInflater = LayoutInflater.from(context);
        this.bIL = oVar.bIO;
        this.JZ = i;
        this.bIM = oVar;
    }

    public void setData(List<m> list) {
        this.azm = list;
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
            view = this.mInflater.inflate(this.JZ, viewGroup, false);
            o M = this.bIM.M(view);
            M.setOnClickListener(this.mOnClickListener);
            view.setTag(M);
        }
        o oVar = (o) view.getTag();
        a(oVar, this.azm.get(i), i);
        return oVar.getView();
    }

    private void a(o oVar, m mVar, int i) {
        if (mVar != null && oVar != null) {
            oVar.a(mVar);
            this.aEG.add(oVar);
            if (TbadkCoreApplication.m411getInst().getSkinType() != oVar.ahU) {
                oVar.onChangeSkinType(this.mSkinType);
            }
        }
    }

    public void db(int i) {
        if (i != this.mSkinType && x.o(this.aEG) > 0) {
            Iterator<o> it = this.aEG.iterator();
            while (it.hasNext()) {
                it.next().onChangeSkinType(i);
            }
        }
    }
}
