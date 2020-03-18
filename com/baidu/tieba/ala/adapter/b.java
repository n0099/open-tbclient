package com.baidu.tieba.ala.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.view.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private long eio;
    private String eiq;
    private boolean eir;
    private ArrayList<g> eke;
    private Context mContext;

    public b(Context context, String str, long j, boolean z) {
        this.mContext = context;
        this.eiq = str;
        this.eio = j;
        this.eir = z;
    }

    public void setData(ArrayList<g> arrayList) {
        if (this.eke == null) {
            this.eke = new ArrayList<>();
        } else {
            this.eke.clear();
        }
        if (arrayList != null) {
            this.eke.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eke == null) {
            return 0;
        }
        return this.eke.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eke == null) {
            return null;
        }
        return this.eke.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.eke == null || this.eke.size() == 0;
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
            e eVar2 = new e(this.mContext, view2, this.eiq, this.eio, this.eir);
            view2.setTag(eVar2);
            eVar = eVar2;
        } else {
            eVar = (e) view.getTag();
            view2 = view;
        }
        eVar.a(this.eke.get(i), i);
        return view2;
    }
}
