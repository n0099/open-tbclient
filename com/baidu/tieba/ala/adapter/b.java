package com.baidu.tieba.ala.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.k.a;
import com.baidu.tieba.ala.data.c;
import com.baidu.tieba.ala.view.e;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private long duD;
    private String duF;
    private boolean duG;
    private ArrayList<c> dve;
    private Context mContext;

    public b(Context context, String str, long j, boolean z) {
        this.mContext = context;
        this.duF = str;
        this.duD = j;
        this.duG = z;
    }

    public void setData(ArrayList<c> arrayList) {
        if (this.dve == null) {
            this.dve = new ArrayList<>();
        } else {
            this.dve.clear();
        }
        if (arrayList != null) {
            this.dve.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dve == null) {
            return 0;
        }
        return this.dve.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dve == null) {
            return null;
        }
        return this.dve.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.dve == null || this.dve.size() == 0;
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
            e eVar2 = new e(this.mContext, view2, this.duF, this.duD, this.duG);
            view2.setTag(eVar2);
            eVar = eVar2;
        } else {
            eVar = (e) view.getTag();
            view2 = view;
        }
        eVar.a(this.dve.get(i), i);
        return view2;
    }
}
