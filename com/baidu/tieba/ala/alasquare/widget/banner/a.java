package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import java.util.List;
/* loaded from: classes6.dex */
public class a<T> extends RecyclerView.Adapter<b> {
    private List<T> bVH;
    private d gAH;
    private c gAL;
    private c gAM;
    private boolean gAN;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gAH != null) {
                a.this.gAH.aF(view.getTag());
            }
        }
    };

    public a(Context context, c cVar, boolean z) {
        this.mContext = context;
        this.gAL = cVar;
        this.gAN = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.gAL != null) {
            return this.gAL.p(viewGroup, i);
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
            Object item = y.getItem(this.bVH, vn(i));
            if (item != null) {
                bVar.k(i, item);
                bVar.itemView.setTag(item);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                bVar.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int vn(int i) {
        if (y.getCount(this.bVH) != 0) {
            return i % y.getCount(this.bVH);
        }
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (y.isEmpty(this.bVH) || y.getCount(this.bVH) == 1) {
            return y.getCount(this.bVH);
        }
        return this.gAN ? y.getCount(this.bVH) * 3 : y.getCount(this.bVH);
    }

    public int bTk() {
        return y.getCount(this.bVH);
    }

    public void setData(List<T> list) {
        this.bVH = list;
    }

    public void setOnBannerClickListener(d dVar) {
        this.gAH = dVar;
    }

    public void setViewHolderAdapter(c cVar) {
        this.gAM = cVar;
    }
}
