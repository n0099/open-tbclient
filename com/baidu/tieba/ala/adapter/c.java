package com.baidu.tieba.ala.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.tieba.ala.data.h;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    private long fLa;
    private String fLc;
    private boolean fLd;
    private ArrayList<h> fMR;
    private AlaLastLiveroomInfo fMS;
    private Context mContext;

    public c(Context context, String str, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.mContext = context;
        this.fLc = str;
        this.fLa = j;
        this.fLd = z;
        this.fMS = alaLastLiveroomInfo;
    }

    public void setData(ArrayList<h> arrayList) {
        if (this.fMR == null) {
            this.fMR = new ArrayList<>();
        } else {
            this.fMR.clear();
        }
        if (arrayList != null) {
            this.fMR.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fMR == null) {
            return 0;
        }
        return this.fMR.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fMR == null) {
            return null;
        }
        return this.fMR.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.fMR == null || this.fMR.size() == 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.ala.view.h hVar;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_item_view, (ViewGroup) null);
            com.baidu.tieba.ala.view.h hVar2 = new com.baidu.tieba.ala.view.h(this.mContext, view2, this.fLc, this.fLa, this.fLd, this.fMS);
            view2.setTag(hVar2);
            hVar = hVar2;
        } else {
            hVar = (com.baidu.tieba.ala.view.h) view.getTag();
            view2 = view;
        }
        hVar.a(this.fMR.get(i), i);
        return view2;
    }
}
