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
    private long fTr;
    private String fTt;
    private boolean fTu;
    private ArrayList<h> fVg;
    private AlaLastLiveroomInfo fVh;
    private Context mContext;

    public c(Context context, String str, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.mContext = context;
        this.fTt = str;
        this.fTr = j;
        this.fTu = z;
        this.fVh = alaLastLiveroomInfo;
    }

    public void setData(ArrayList<h> arrayList) {
        if (this.fVg == null) {
            this.fVg = new ArrayList<>();
        } else {
            this.fVg.clear();
        }
        if (arrayList != null) {
            this.fVg.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fVg == null) {
            return 0;
        }
        return this.fVg.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fVg == null) {
            return null;
        }
        return this.fVg.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.fVg == null || this.fVg.size() == 0;
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
            com.baidu.tieba.ala.view.h hVar2 = new com.baidu.tieba.ala.view.h(this.mContext, view2, this.fTt, this.fTr, this.fTu, this.fVh);
            view2.setTag(hVar2);
            hVar = hVar2;
        } else {
            hVar = (com.baidu.tieba.ala.view.h) view.getTag();
            view2 = view;
        }
        hVar.a(this.fVg.get(i), i);
        return view2;
    }
}
