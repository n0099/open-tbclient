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
    private long ehL;
    private String ehN;
    private boolean ehO;
    private ArrayList<g> ejB;
    private Context mContext;

    public b(Context context, String str, long j, boolean z) {
        this.mContext = context;
        this.ehN = str;
        this.ehL = j;
        this.ehO = z;
    }

    public void setData(ArrayList<g> arrayList) {
        if (this.ejB == null) {
            this.ejB = new ArrayList<>();
        } else {
            this.ejB.clear();
        }
        if (arrayList != null) {
            this.ejB.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ejB == null) {
            return 0;
        }
        return this.ejB.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.ejB == null) {
            return null;
        }
        return this.ejB.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.ejB == null || this.ejB.size() == 0;
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
            e eVar2 = new e(this.mContext, view2, this.ehN, this.ehL, this.ehO);
            view2.setTag(eVar2);
            eVar = eVar2;
        } else {
            eVar = (e) view.getTag();
            view2 = view;
        }
        eVar.a(this.ejB.get(i), i);
        return view2;
    }
}
