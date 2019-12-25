package com.baidu.tieba.ala.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.q.a;
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.view.e;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private String edB;
    private boolean edC;
    private long edz;
    private ArrayList<g> efp;
    private Context mContext;

    public b(Context context, String str, long j, boolean z) {
        this.mContext = context;
        this.edB = str;
        this.edz = j;
        this.edC = z;
    }

    public void setData(ArrayList<g> arrayList) {
        if (this.efp == null) {
            this.efp = new ArrayList<>();
        } else {
            this.efp.clear();
        }
        if (arrayList != null) {
            this.efp.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.efp == null) {
            return 0;
        }
        return this.efp.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.efp == null) {
            return null;
        }
        return this.efp.get(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.efp == null || this.efp.size() == 0;
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
            e eVar2 = new e(this.mContext, view2, this.edB, this.edz, this.edC);
            view2.setTag(eVar2);
            eVar = eVar2;
        } else {
            eVar = (e) view.getTag();
            view2 = view;
        }
        eVar.a(this.efp.get(i), i);
        return view2;
    }
}
