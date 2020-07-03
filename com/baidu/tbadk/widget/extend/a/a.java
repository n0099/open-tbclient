package com.baidu.tbadk.widget.extend.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a<T> extends b {
    protected e<T> aih;
    protected Context mContext;
    protected List<T> mData;
    protected LayoutInflater mInflater;
    protected int mLayoutId;

    public abstract void a(c cVar, T t, int i);

    public void a(e<T> eVar) {
        this.aih = eVar;
    }

    public a(Context context, List<T> list, int i) {
        this.mContext = context;
        this.mData = list == null ? new ArrayList() : new ArrayList(list);
        this.mLayoutId = i;
        this.mInflater = LayoutInflater.from(this.mContext);
    }

    public a(Context context, int i) {
        this(context, null, i);
    }

    @Override // com.baidu.tbadk.widget.extend.a.b
    public int getCount() {
        return this.mData.size();
    }

    @Override // com.baidu.tbadk.widget.extend.a.b
    public View getView(int i, ViewGroup viewGroup) {
        View inflate = this.mInflater.inflate(this.mLayoutId, viewGroup, false);
        c cVar = new c(inflate);
        T t = this.mData.get(i);
        a(cVar, t, i);
        cVar.i(new View$OnClickListenerC0504a(t, i));
        return inflate;
    }

    /* renamed from: com.baidu.tbadk.widget.extend.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class View$OnClickListenerC0504a implements View.OnClickListener {
        private T eJg;
        private int position;

        public View$OnClickListenerC0504a(T t, int i) {
            this.eJg = t;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aih != null) {
                a.this.aih.a(view, this.eJg, this.position, this.position);
            }
        }
    }

    public void setData(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.mData = list;
        notifyDataSetChanged();
    }
}
