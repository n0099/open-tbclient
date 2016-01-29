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
    private ArrayList<com.baidu.tbadk.d.a.a> asj;
    private Context mContext;

    /* loaded from: classes.dex */
    private class a {
        public TextView apm;
        public HeadImageView ask;
        public TextView asl;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void a(com.baidu.tbadk.d.a.a aVar) {
        if (this.asj != null && aVar != null) {
            this.asj.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.asj == null) {
            return 0;
        }
        return this.asj.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ep */
    public com.baidu.tbadk.d.a.a getItem(int i) {
        if (this.asj != null && i < this.asj.size()) {
            return this.asj.get(i);
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
            aVar.ask.setImageResource(this.asj.get(i).Cj());
            aVar.apm.setText(this.asj.get(i).Ck());
            aVar.asl.setText(i);
            return view;
        }
        return null;
    }
}
