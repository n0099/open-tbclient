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
    private ArrayList<com.baidu.tbadk.d.a.a> apO;
    private Context mContext;

    /* loaded from: classes.dex */
    private class a {
        public TextView agd;
        public HeadImageView apP;
        public TextView apQ;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void a(com.baidu.tbadk.d.a.a aVar) {
        if (this.apO != null && aVar != null) {
            this.apO.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.apO == null) {
            return 0;
        }
        return this.apO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ea */
    public com.baidu.tbadk.d.a.a getItem(int i) {
        if (this.apO != null && i < this.apO.size()) {
            return this.apO.get(i);
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
            aVar.apP.setImageResource(this.apO.get(i).Bd());
            aVar.agd.setText(this.apO.get(i).Be());
            aVar.apQ.setText(i);
            return view;
        }
        return null;
    }
}
