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
    private ArrayList<com.baidu.tbadk.d.a.a> apW;
    private Context mContext;

    /* loaded from: classes.dex */
    private class a {
        public HeadImageView apX;
        public TextView apY;
        public TextView title;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void a(com.baidu.tbadk.d.a.a aVar) {
        if (this.apW != null && aVar != null) {
            this.apW.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.apW == null) {
            return 0;
        }
        return this.apW.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: eb */
    public com.baidu.tbadk.d.a.a getItem(int i) {
        if (this.apW != null && i < this.apW.size()) {
            return this.apW.get(i);
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
            aVar.apX.setImageResource(this.apW.get(i).AS());
            aVar.title.setText(this.apW.get(i).AT());
            aVar.apY.setText(i);
            return view;
        }
        return null;
    }
}
