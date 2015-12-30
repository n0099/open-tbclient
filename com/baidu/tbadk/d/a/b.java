package com.baidu.tbadk.d.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private ArrayList<com.baidu.tbadk.d.a.a> arq;
    private Context mContext;

    /* loaded from: classes.dex */
    private class a {
        public TextView ahk;
        public HeadImageView arr;
        public TextView ars;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void a(com.baidu.tbadk.d.a.a aVar) {
        if (this.arq != null && aVar != null) {
            this.arq.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.arq == null) {
            return 0;
        }
        return this.arq.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dU */
    public com.baidu.tbadk.d.a.a getItem(int i) {
        if (this.arq != null && i < this.arq.size()) {
            return this.arq.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view != null) {
            a aVar = (a) view.getTag();
            aVar.arr.setImageResource(this.arq.get(i).AT());
            aVar.ahk.setText(this.arq.get(i).AU());
            aVar.ars.setText(i);
            return view;
        }
        return null;
    }
}
