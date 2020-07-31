package com.baidu.tieba.ala.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.tieba.ala.data.h;
import com.baidu.tieba.ala.view.g;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c extends BaseAdapter {
    private long fkg;
    private String fki;
    private boolean fkj;
    private ArrayList<h> flW;
    private AlaLastLiveroomInfo flX;
    private Context mContext;

    public c(Context context, String str, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.mContext = context;
        this.fki = str;
        this.fkg = j;
        this.fkj = z;
        this.flX = alaLastLiveroomInfo;
    }

    public void setData(ArrayList<h> arrayList) {
        if (this.flW == null) {
            this.flW = new ArrayList<>();
        } else {
            this.flW.clear();
        }
        if (arrayList != null) {
            this.flW.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.flW == null) {
            return 0;
        }
        return this.flW.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.flW == null) {
            return null;
        }
        return this.flW.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.flW == null || this.flW.size() == 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        g gVar;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_item_view, (ViewGroup) null);
            g gVar2 = new g(this.mContext, view2, this.fki, this.fkg, this.fkj, this.flX);
            view2.setTag(gVar2);
            gVar = gVar2;
        } else {
            gVar = (g) view.getTag();
            view2 = view;
        }
        gVar.a(this.flW.get(i), i);
        return view2;
    }
}
