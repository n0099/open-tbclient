package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import java.util.List;
/* loaded from: classes4.dex */
public class a<T> extends RecyclerView.Adapter<b> {
    private List<T> aDV;
    private d fBW;
    private c fCa;
    private c fCb;
    private boolean fCc;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fBW != null) {
                a.this.fBW.ax(view.getTag());
            }
        }
    };

    public a(Context context, c cVar, boolean z) {
        this.mContext = context;
        this.fCa = cVar;
        this.fCc = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: m */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.fCa != null) {
            return this.fCa.l(viewGroup, i);
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
            Object item = x.getItem(this.aDV, qG(i));
            if (item != null) {
                bVar.h(i, item);
                bVar.itemView.setTag(item);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                bVar.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int qG(int i) {
        if (x.getCount(this.aDV) != 0) {
            return i % x.getCount(this.aDV);
        }
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (x.isEmpty(this.aDV) || x.getCount(this.aDV) == 1) {
            return x.getCount(this.aDV);
        }
        return this.fCc ? x.getCount(this.aDV) * 3 : x.getCount(this.aDV);
    }

    public int byd() {
        return x.getCount(this.aDV);
    }

    public void setData(List<T> list) {
        this.aDV = list;
    }

    public void setOnBannerClickListener(d dVar) {
        this.fBW = dVar;
    }

    public void setViewHolderAdapter(c cVar) {
        this.fCb = cVar;
    }
}
