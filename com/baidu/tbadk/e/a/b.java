package com.baidu.tbadk.e.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private ArrayList<com.baidu.tbadk.e.a.a> atd;
    private Context mContext;

    /* loaded from: classes.dex */
    private class a {
        public HeadImageView ate;
        public TextView atf;
        public TextView title;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void a(com.baidu.tbadk.e.a.a aVar) {
        if (this.atd != null && aVar != null) {
            this.atd.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.atd == null) {
            return 0;
        }
        return this.atd.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ep */
    public com.baidu.tbadk.e.a.a getItem(int i) {
        if (this.atd != null && i < this.atd.size()) {
            return this.atd.get(i);
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
            aVar.ate.setImageResource(this.atd.get(i).Cn());
            aVar.title.setText(this.atd.get(i).Co());
            aVar.atf.setText(i);
            return view;
        }
        return null;
    }
}
