package com.baidu.tieba.ala.alaar.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.ala.alaar.view.b;
/* loaded from: classes11.dex */
public abstract class h<LIST, D, VH extends b> extends BaseAdapter implements View.OnClickListener {
    protected int abv;
    protected Context context;
    protected int gwP = -1;
    protected a gwQ;
    private VH gwR;
    protected LIST mData;
    protected LayoutInflater mInflater;

    /* loaded from: classes11.dex */
    public interface a<VH extends b> {
        void a(VH vh, int i, boolean z);

        boolean a(VH vh, int i, int i2, boolean z);
    }

    public abstract VH b(int i, ViewGroup viewGroup);

    public abstract D tB(int i);

    public h(Context context, LIST list) {
        this.abv = -1;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = list;
        this.abv = -1;
    }

    public void setData(LIST list) {
        this.mData = list;
        bOT();
        notifyDataSetChanged();
    }

    protected void bOT() {
        this.abv = -1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.ala.alaar.view.h<LIST, D, VH extends com.baidu.tieba.ala.alaar.view.b> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = b(i, viewGroup);
            bVar.itemView.setOnClickListener(this);
        } else {
            bVar = (b) view.getTag();
        }
        a(i, (int) bVar);
        return bVar.itemView;
    }

    public void a(int i, final VH vh) {
        vh.h(i, tB(i));
        if (this.gwP >= 0 && i == this.gwP) {
            vh.itemView.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.h.1
                /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.ala.alaar.view.h */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    h.this.a((h) vh, false);
                }
            });
        } else if (i == this.abv) {
            b(i, (int) vh);
        }
    }

    private void b(int i, VH vh) {
        if (vh != this.gwR) {
            if (this.gwR != null) {
                this.gwR.tx(i);
            }
            this.gwR = vh;
        }
        vh.tx(i);
    }

    public void tC(int i) {
        if (i != this.abv) {
            this.gwP = i;
            notifyDataSetChanged();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.ala.alaar.view.h<LIST, D, VH extends com.baidu.tieba.ala.alaar.view.b> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
            com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "MBAdapter onClick");
        }
        Object tag = view.getTag();
        if (tag != null && (tag instanceof b)) {
            a((h<LIST, D, VH>) ((b) tag), true);
        }
    }

    protected void a(VH vh, boolean z) {
        if (vh == null) {
            com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "onClick with viewHolder null");
            return;
        }
        boolean z2 = this.gwQ != null && this.gwQ.a(vh, vh.position, this.abv, z);
        if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
            com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "onClick pos= " + vh.position + ", processed= " + z2);
        }
        if (!z2) {
            b(vh.position, (int) vh);
            this.abv = vh.position;
            this.gwP = -1;
            if (this.gwQ != null) {
                this.gwQ.a(vh, vh.position, z);
            }
        }
    }

    public int getCurrentPosition() {
        return this.abv;
    }

    public void a(a aVar) {
        this.gwQ = aVar;
    }
}
