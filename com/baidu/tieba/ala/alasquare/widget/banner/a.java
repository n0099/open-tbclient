package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import java.util.List;
/* loaded from: classes2.dex */
public class a<T> extends RecyclerView.Adapter<b> {
    private List<T> aaB;
    private d eqm;
    private c eqq;
    private c eqr;
    private boolean eqs;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eqm != null) {
                a.this.eqm.an(view.getTag());
            }
        }
    };

    public a(Context context, c cVar, boolean z) {
        this.mContext = context;
        this.eqq = cVar;
        this.eqs = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: n */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.eqq != null) {
            return this.eqq.m(viewGroup, i);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.ala.alasquare.widget.banner.b */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i) {
        if (getItemCount() != 0 && bVar != 0) {
            Object item = v.getItem(this.aaB, oD(i));
            if (item != null) {
                bVar.h(i, item);
                bVar.itemView.setTag(item);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                bVar.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int oD(int i) {
        if (v.getCount(this.aaB) != 0) {
            return i % v.getCount(this.aaB);
        }
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (v.isEmpty(this.aaB) || v.getCount(this.aaB) == 1) {
            return v.getCount(this.aaB);
        }
        return this.eqs ? v.getCount(this.aaB) * 3 : v.getCount(this.aaB);
    }

    public int bbl() {
        return v.getCount(this.aaB);
    }

    public void setData(List<T> list) {
        this.aaB = list;
    }

    public void setOnBannerClickListener(d dVar) {
        this.eqm = dVar;
    }

    public void setViewHolderAdapter(c cVar) {
        this.eqr = cVar;
    }
}
