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
    private long ehK;
    private String ehM;
    private boolean ehN;
    private ArrayList<g> ejA;
    private Context mContext;

    public b(Context context, String str, long j, boolean z) {
        this.mContext = context;
        this.ehM = str;
        this.ehK = j;
        this.ehN = z;
    }

    public void setData(ArrayList<g> arrayList) {
        if (this.ejA == null) {
            this.ejA = new ArrayList<>();
        } else {
            this.ejA.clear();
        }
        if (arrayList != null) {
            this.ejA.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ejA == null) {
            return 0;
        }
        return this.ejA.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ejA == null) {
            return null;
        }
        return this.ejA.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.ejA == null || this.ejA.size() == 0;
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
            e eVar2 = new e(this.mContext, view2, this.ehM, this.ehK, this.ehN);
            view2.setTag(eVar2);
            eVar = eVar2;
        } else {
            eVar = (e) view.getTag();
            view2 = view;
        }
        eVar.a(this.ejA.get(i), i);
        return view2;
    }
}
