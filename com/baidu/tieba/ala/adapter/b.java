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
    private long eUH;
    private String eUJ;
    private boolean eUK;
    private ArrayList<g> eWs;
    private Context mContext;

    public b(Context context, String str, long j, boolean z) {
        this.mContext = context;
        this.eUJ = str;
        this.eUH = j;
        this.eUK = z;
    }

    public void setData(ArrayList<g> arrayList) {
        if (this.eWs == null) {
            this.eWs = new ArrayList<>();
        } else {
            this.eWs.clear();
        }
        if (arrayList != null) {
            this.eWs.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eWs == null) {
            return 0;
        }
        return this.eWs.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eWs == null) {
            return null;
        }
        return this.eWs.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.eWs == null || this.eWs.size() == 0;
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
            e eVar2 = new e(this.mContext, view2, this.eUJ, this.eUH, this.eUK);
            view2.setTag(eVar2);
            eVar = eVar2;
        } else {
            eVar = (e) view.getTag();
            view2 = view;
        }
        eVar.a(this.eWs.get(i), i);
        return view2;
    }
}
