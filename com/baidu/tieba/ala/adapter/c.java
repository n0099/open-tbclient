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
/* loaded from: classes10.dex */
public class c extends BaseAdapter {
    private String grA;
    private boolean grB;
    private long gry;
    private ArrayList<h> gtn;
    private AlaLastLiveroomInfo gto;
    private Context mContext;

    public c(Context context, String str, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.mContext = context;
        this.grA = str;
        this.gry = j;
        this.grB = z;
        this.gto = alaLastLiveroomInfo;
    }

    public void setData(ArrayList<h> arrayList) {
        if (this.gtn == null) {
            this.gtn = new ArrayList<>();
        } else {
            this.gtn.clear();
        }
        if (arrayList != null) {
            this.gtn.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gtn == null) {
            return 0;
        }
        return this.gtn.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gtn == null) {
            return null;
        }
        return this.gtn.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.gtn == null || this.gtn.size() == 0;
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
            com.baidu.tieba.ala.view.h hVar2 = new com.baidu.tieba.ala.view.h(this.mContext, view2, this.grA, this.gry, this.grB, this.gto);
            view2.setTag(hVar2);
            hVar = hVar2;
        } else {
            hVar = (com.baidu.tieba.ala.view.h) view.getTag();
            view2 = view;
        }
        hVar.a(this.gtn.get(i), i);
        return view2;
    }
}
