package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import java.util.List;
/* loaded from: classes3.dex */
public class a<T> extends RecyclerView.Adapter<b> {
    private List<T> avh;
    private d eYH;
    private c eYL;
    private c eYM;
    private boolean eYN;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eYH != null) {
                a.this.eYH.as(view.getTag());
            }
        }
    };

    public a(Context context, c cVar, boolean z) {
        this.mContext = context;
        this.eYL = cVar;
        this.eYN = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: n */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.eYL != null) {
            return this.eYL.m(viewGroup, i);
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
            Object item = v.getItem(this.avh, pq(i));
            if (item != null) {
                bVar.h(i, item);
                bVar.itemView.setTag(item);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                bVar.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int pq(int i) {
        if (v.getCount(this.avh) != 0) {
            return i % v.getCount(this.avh);
        }
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (v.isEmpty(this.avh) || v.getCount(this.avh) == 1) {
            return v.getCount(this.avh);
        }
        return this.eYN ? v.getCount(this.avh) * 3 : v.getCount(this.avh);
    }

    public int bmx() {
        return v.getCount(this.avh);
    }

    public void setData(List<T> list) {
        this.avh = list;
    }

    public void setOnBannerClickListener(d dVar) {
        this.eYH = dVar;
    }

    public void setViewHolderAdapter(c cVar) {
        this.eYM = cVar;
    }
}
