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
    private d flC;
    private c flG;
    private c flH;
    private boolean flI;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.flC != null) {
                a.this.flC.aw(view.getTag());
            }
        }
    };

    public a(Context context, c cVar, boolean z) {
        this.mContext = context;
        this.flG = cVar;
        this.flI = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: l */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.flG != null) {
            return this.flG.k(viewGroup, i);
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
            Object item = v.getItem(this.aAp, pS(i));
            if (item != null) {
                bVar.h(i, item);
                bVar.itemView.setTag(item);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                bVar.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int pS(int i) {
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
        return this.flI ? v.getCount(this.aAp) * 3 : v.getCount(this.aAp);
    }

    public int brX() {
        return v.getCount(this.aAp);
    }

    public void setData(List<T> list) {
        this.aAp = list;
    }

    public void setOnBannerClickListener(d dVar) {
        this.flC = dVar;
    }

    public void setViewHolderAdapter(c cVar) {
        this.flH = cVar;
    }
}
