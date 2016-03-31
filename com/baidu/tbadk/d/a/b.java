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
    private ArrayList<com.baidu.tbadk.d.a.a> asB;
    private Context mContext;

    /* loaded from: classes.dex */
    private class a {
        public TextView apE;
        public HeadImageView asC;
        public TextView asD;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void a(com.baidu.tbadk.d.a.a aVar) {
        if (this.asB != null && aVar != null) {
            this.asB.add(aVar);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.asB == null) {
            return 0;
        }
        return this.asB.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: es */
    public com.baidu.tbadk.d.a.a getItem(int i) {
        if (this.asB != null && i < this.asB.size()) {
            return this.asB.get(i);
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
            aVar.asC.setImageResource(this.asB.get(i).CO());
            aVar.apE.setText(this.asB.get(i).CQ());
            aVar.asD.setText(i);
            return view;
        }
        return null;
    }
}
