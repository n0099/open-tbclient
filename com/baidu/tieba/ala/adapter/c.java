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
/* loaded from: classes11.dex */
public class c extends BaseAdapter {
    private String grB;
    private boolean grC;
    private long grz;
    private ArrayList<h> gto;
    private AlaLastLiveroomInfo gtp;
    private Context mContext;

    public c(Context context, String str, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.mContext = context;
        this.grB = str;
        this.grz = j;
        this.grC = z;
        this.gtp = alaLastLiveroomInfo;
    }

    public void setData(ArrayList<h> arrayList) {
        if (this.gto == null) {
            this.gto = new ArrayList<>();
        } else {
            this.gto.clear();
        }
        if (arrayList != null) {
            this.gto.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gto == null) {
            return 0;
        }
        return this.gto.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gto == null) {
            return null;
        }
        return this.gto.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.gto == null || this.gto.size() == 0;
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
            view2 = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_list_item_view, (ViewGroup) null);
            com.baidu.tieba.ala.view.h hVar2 = new com.baidu.tieba.ala.view.h(this.mContext, view2, this.grB, this.grz, this.grC, this.gtp);
            view2.setTag(hVar2);
            hVar = hVar2;
        } else {
            hVar = (com.baidu.tieba.ala.view.h) view.getTag();
            view2 = view;
        }
        hVar.a(this.gto.get(i), i);
        return view2;
    }
}
