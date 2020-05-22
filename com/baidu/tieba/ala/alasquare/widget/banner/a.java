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
    private List<T> aAp;
    private d flr;
    private c flv;
    private c flw;
    private boolean flx;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.flr != null) {
                a.this.flr.aw(view.getTag());
            }
        }
    };

    public a(Context context, c cVar, boolean z) {
        this.mContext = context;
        this.flv = cVar;
        this.flx = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: l */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.flv != null) {
            return this.flv.k(viewGroup, i);
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
            Object item = v.getItem(this.aAp, pQ(i));
            if (item != null) {
                bVar.h(i, item);
                bVar.itemView.setTag(item);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                bVar.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int pQ(int i) {
        if (v.getCount(this.aAp) != 0) {
            return i % v.getCount(this.aAp);
        }
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (v.isEmpty(this.aAp) || v.getCount(this.aAp) == 1) {
            return v.getCount(this.aAp);
        }
        return this.flx ? v.getCount(this.aAp) * 3 : v.getCount(this.aAp);
    }

    public int brV() {
        return v.getCount(this.aAp);
    }

    public void setData(List<T> list) {
        this.aAp = list;
    }

    public void setOnBannerClickListener(d dVar) {
        this.flr = dVar;
    }

    public void setViewHolderAdapter(c cVar) {
        this.flw = cVar;
    }
}
