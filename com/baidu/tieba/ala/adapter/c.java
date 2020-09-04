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
/* loaded from: classes7.dex */
public class c extends BaseAdapter {
    private long fvG;
    private String fvI;
    private boolean fvJ;
    private ArrayList<h> fxw;
    private AlaLastLiveroomInfo fxx;
    private Context mContext;

    public c(Context context, String str, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.mContext = context;
        this.fvI = str;
        this.fvG = j;
        this.fvJ = z;
        this.fxx = alaLastLiveroomInfo;
    }

    public void setData(ArrayList<h> arrayList) {
        if (this.fxw == null) {
            this.fxw = new ArrayList<>();
        } else {
            this.fxw.clear();
        }
        if (arrayList != null) {
            this.fxw.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fxw == null) {
            return 0;
        }
        return this.fxw.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fxw == null) {
            return null;
        }
        return this.fxw.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.fxw == null || this.fxw.size() == 0;
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
            g gVar2 = new g(this.mContext, view2, this.fvI, this.fvG, this.fvJ, this.fxx);
            view2.setTag(gVar2);
            gVar = gVar2;
        } else {
            gVar = (g) view.getTag();
            view2 = view;
        }
        gVar.a(this.fxw.get(i), i);
        return view2;
    }
}
