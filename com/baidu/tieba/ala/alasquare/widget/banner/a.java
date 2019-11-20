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
    private List<T> Ty;
    private d dEa;
    private c dEe;
    private c dEf;
    private boolean dEg;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.dEa != null) {
                a.this.dEa.ah(view.getTag());
            }
        }
    };

    public a(Context context, c cVar, boolean z) {
        this.mContext = context;
        this.dEe = cVar;
        this.dEg = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: k */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.dEe != null) {
            return this.dEe.j(viewGroup, i);
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
            Object item = v.getItem(this.Ty, mt(i));
            if (item != null) {
                bVar.h(i, item);
                bVar.itemView.setTag(item);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                bVar.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int mt(int i) {
        if (v.getCount(this.Ty) != 0) {
            return i % v.getCount(this.Ty);
        }
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (v.isEmpty(this.Ty) || v.getCount(this.Ty) == 1) {
            return v.getCount(this.Ty);
        }
        return this.dEg ? v.getCount(this.Ty) * 3 : v.getCount(this.Ty);
    }

    public int aKr() {
        return v.getCount(this.Ty);
    }

    public void setData(List<T> list) {
        this.Ty = list;
    }

    public void setOnBannerClickListener(d dVar) {
        this.dEa = dVar;
    }

    public void setViewHolderAdapter(c cVar) {
        this.dEf = cVar;
    }
}
