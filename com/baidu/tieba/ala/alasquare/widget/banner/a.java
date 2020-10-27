package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import java.util.List;
/* loaded from: classes4.dex */
public class a<T> extends RecyclerView.Adapter<b> {
    private List<T> aOh;
    private d gnc;
    private c gng;
    private c gnh;
    private boolean gni;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gnc != null) {
                a.this.gnc.aF(view.getTag());
            }
        }
    };

    public a(Context context, c cVar, boolean z) {
        this.mContext = context;
        this.gng = cVar;
        this.gni = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.gng != null) {
            return this.gng.p(viewGroup, i);
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
            Object item = y.getItem(this.aOh, ub(i));
            if (item != null) {
                bVar.l(i, item);
                bVar.itemView.setTag(item);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                bVar.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int ub(int i) {
        if (y.getCount(this.aOh) != 0) {
            return i % y.getCount(this.aOh);
        }
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (y.isEmpty(this.aOh) || y.getCount(this.aOh) == 1) {
            return y.getCount(this.aOh);
        }
        return this.gni ? y.getCount(this.aOh) * 3 : y.getCount(this.aOh);
    }

    public int bNF() {
        return y.getCount(this.aOh);
    }

    public void setData(List<T> list) {
        this.aOh = list;
    }

    public void setOnBannerClickListener(d dVar) {
        this.gnc = dVar;
    }

    public void setViewHolderAdapter(c cVar) {
        this.gnh = cVar;
    }
}
