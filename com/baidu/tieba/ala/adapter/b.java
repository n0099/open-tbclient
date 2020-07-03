package com.baidu.tieba.ala.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.view.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private long ffd;
    private String fff;
    private boolean ffg;
    private ArrayList<g> fgO;
    private AlaLastLiveroomInfo fgP;
    private Context mContext;

    public b(Context context, String str, long j, boolean z, AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.mContext = context;
        this.fff = str;
        this.ffd = j;
        this.ffg = z;
        this.fgP = alaLastLiveroomInfo;
    }

    public void setData(ArrayList<g> arrayList) {
        if (this.fgO == null) {
            this.fgO = new ArrayList<>();
        } else {
            this.fgO.clear();
        }
        if (arrayList != null) {
            this.fgO.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fgO == null) {
            return 0;
        }
        return this.fgO.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fgO == null) {
            return null;
        }
        return this.fgO.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.fgO == null || this.fgO.size() == 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        e eVar;
        View view2;
        if (view == null) {
            view2 = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_list_item_view, (ViewGroup) null);
            e eVar2 = new e(this.mContext, view2, this.fff, this.ffd, this.ffg, this.fgP);
            view2.setTag(eVar2);
            eVar = eVar2;
        } else {
            eVar = (e) view.getTag();
            view2 = view;
        }
        eVar.a(this.fgO.get(i), i);
        return view2;
    }
}
