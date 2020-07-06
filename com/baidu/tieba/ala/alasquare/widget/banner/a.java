package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.w;
import java.util.List;
/* loaded from: classes3.dex */
public class a<T> extends RecyclerView.Adapter<b> {
    private List<T> aCA;
    private d fwP;
    private c fwT;
    private c fwU;
    private boolean fwV;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fwP != null) {
                a.this.fwP.ax(view.getTag());
            }
        }
    };

    public a(Context context, c cVar, boolean z) {
        this.mContext = context;
        this.fwT = cVar;
        this.fwV = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: m */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.fwT != null) {
            return this.fwT.l(viewGroup, i);
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
            Object item = w.getItem(this.aCA, qr(i));
            if (item != null) {
                bVar.h(i, item);
                bVar.itemView.setTag(item);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                bVar.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int qr(int i) {
        if (w.getCount(this.aCA) != 0) {
            return i % w.getCount(this.aCA);
        }
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (w.isEmpty(this.aCA) || w.getCount(this.aCA) == 1) {
            return w.getCount(this.aCA);
        }
        return this.fwV ? w.getCount(this.aCA) * 3 : w.getCount(this.aCA);
    }

    public int buU() {
        return w.getCount(this.aCA);
    }

    public void setData(List<T> list) {
        this.aCA = list;
    }

    public void setOnBannerClickListener(d dVar) {
        this.fwP = dVar;
    }

    public void setViewHolderAdapter(c cVar) {
        this.fwU = cVar;
    }
}
