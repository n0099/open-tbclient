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
    private ArrayList<com.baidu.tbadk.d.a.a> apg;
    private Context mContext;

    /* loaded from: classes.dex */
    private class a {
        public HeadImageView aph;
        public TextView api;
        public TextView title;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void a(com.baidu.tbadk.d.a.a aVar) {
        if (this.apg != null && aVar != null) {
            this.apg.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.apg == null) {
            return 0;
        }
        return this.apg.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: eb */
    public com.baidu.tbadk.d.a.a getItem(int i) {
        if (this.apg != null && i < this.apg.size()) {
            return this.apg.get(i);
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
            aVar.aph.setImageResource(this.apg.get(i).AS());
            aVar.title.setText(this.apg.get(i).AT());
            aVar.api.setText(i);
            return view;
        }
        return null;
    }
}
