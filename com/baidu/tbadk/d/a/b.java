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
    private ArrayList<com.baidu.tbadk.d.a.a> aos;
    private Context mContext;

    /* loaded from: classes.dex */
    private class a {
        public HeadImageView aot;
        public TextView aou;
        public TextView title;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void a(com.baidu.tbadk.d.a.a aVar) {
        if (this.aos != null && aVar != null) {
            this.aos.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aos == null) {
            return 0;
        }
        return this.aos.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dY */
    public com.baidu.tbadk.d.a.a getItem(int i) {
        if (this.aos != null && i < this.aos.size()) {
            return this.aos.get(i);
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
            aVar.aot.setImageResource(this.aos.get(i).AI());
            aVar.title.setText(this.aos.get(i).AJ());
            aVar.aou.setText(i);
            return view;
        }
        return null;
    }
}
