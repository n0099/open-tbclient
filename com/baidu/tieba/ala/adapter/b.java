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
    private long dtM;
    private String dtO;
    private boolean dtP;
    private ArrayList<c> dun;
    private Context mContext;

    public b(Context context, String str, long j, boolean z) {
        this.mContext = context;
        this.dtO = str;
        this.dtM = j;
        this.dtP = z;
    }

    public void setData(ArrayList<c> arrayList) {
        if (this.dun == null) {
            this.dun = new ArrayList<>();
        } else {
            this.dun.clear();
        }
        if (arrayList != null) {
            this.dun.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dun == null) {
            return 0;
        }
        return this.dun.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dun == null) {
            return null;
        }
        return this.dun.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.dun == null || this.dun.size() == 0;
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
            e eVar2 = new e(this.mContext, view2, this.dtO, this.dtM, this.dtP);
            view2.setTag(eVar2);
            eVar = eVar2;
        } else {
            eVar = (e) view.getTag();
            view2 = view;
        }
        eVar.a(this.dun.get(i), i);
        return view2;
    }
}
