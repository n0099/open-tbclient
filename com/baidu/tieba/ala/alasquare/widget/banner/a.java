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
    private List<T> aap;
    private d eoZ;
    private c epd;
    private c epe;
    private boolean epf;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eoZ != null) {
                a.this.eoZ.an(view.getTag());
            }
        }
    };

    public a(Context context, c cVar, boolean z) {
        this.mContext = context;
        this.epd = cVar;
        this.epf = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: n */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.epd != null) {
            return this.epd.m(viewGroup, i);
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
            Object item = v.getItem(this.aap, oC(i));
            if (item != null) {
                bVar.h(i, item);
                bVar.itemView.setTag(item);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                bVar.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int oC(int i) {
        if (v.getCount(this.aap) != 0) {
            return i % v.getCount(this.aap);
        }
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (v.isEmpty(this.aap) || v.getCount(this.aap) == 1) {
            return v.getCount(this.aap);
        }
        return this.epf ? v.getCount(this.aap) * 3 : v.getCount(this.aap);
    }

    public int baQ() {
        return v.getCount(this.aap);
    }

    public void setData(List<T> list) {
        this.aap = list;
    }

    public void setOnBannerClickListener(d dVar) {
        this.eoZ = dVar;
    }

    public void setViewHolderAdapter(c cVar) {
        this.epe = cVar;
    }
}
