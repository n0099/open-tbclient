package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import java.util.List;
/* loaded from: classes6.dex */
public class a<T> extends RecyclerView.Adapter<b> {
    private List<T> TT;
    private d dER;
    private c dEV;
    private c dEW;
    private boolean dEX;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dER != null) {
                a.this.dER.ah(view.getTag());
            }
        }
    };

    public a(Context context, c cVar, boolean z) {
        this.mContext = context;
        this.dEV = cVar;
        this.dEX = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: k */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.dEV != null) {
            return this.dEV.j(viewGroup, i);
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
            Object item = v.getItem(this.TT, mu(i));
            if (item != null) {
                bVar.h(i, item);
                bVar.itemView.setTag(item);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                bVar.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int mu(int i) {
        if (v.getCount(this.TT) != 0) {
            return i % v.getCount(this.TT);
        }
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (v.isEmpty(this.TT) || v.getCount(this.TT) == 1) {
            return v.getCount(this.TT);
        }
        return this.dEX ? v.getCount(this.TT) * 3 : v.getCount(this.TT);
    }

    public int aKt() {
        return v.getCount(this.TT);
    }

    public void setData(List<T> list) {
        this.TT = list;
    }

    public void setOnBannerClickListener(d dVar) {
        this.dER = dVar;
    }

    public void setViewHolderAdapter(c cVar) {
        this.dEW = cVar;
    }
}
