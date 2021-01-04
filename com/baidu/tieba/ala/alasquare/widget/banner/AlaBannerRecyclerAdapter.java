package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaBannerRecyclerAdapter<T> extends RecyclerView.Adapter<AlaBannerViewHolder> {
    private List<T> cbD;
    private b gMr;
    private a gMv;
    private a gMw;
    private boolean gMx;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerAdapter.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AlaBannerRecyclerAdapter.this.gMr != null) {
                AlaBannerRecyclerAdapter.this.gMr.aG(view.getTag());
            }
        }
    };

    public AlaBannerRecyclerAdapter(Context context, a aVar, boolean z) {
        this.mContext = context;
        this.gMv = aVar;
        this.gMx = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: u */
    public AlaBannerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.gMv != null) {
            return this.gMv.t(viewGroup, i);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(AlaBannerViewHolder alaBannerViewHolder, int i) {
        if (getItemCount() != 0 && alaBannerViewHolder != 0) {
            Object item = x.getItem(this.cbD, vy(i));
            if (item != null) {
                alaBannerViewHolder.k(i, item);
                alaBannerViewHolder.itemView.setTag(item);
                alaBannerViewHolder.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                alaBannerViewHolder.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int vy(int i) {
        if (x.getCount(this.cbD) != 0) {
            return i % x.getCount(this.cbD);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (x.isEmpty(this.cbD) || x.getCount(this.cbD) == 1) {
            return x.getCount(this.cbD);
        }
        return this.gMx ? x.getCount(this.cbD) * 3 : x.getCount(this.cbD);
    }

    public int bVP() {
        return x.getCount(this.cbD);
    }

    public void setData(List<T> list) {
        this.cbD = list;
    }

    public void setOnBannerClickListener(b bVar) {
        this.gMr = bVar;
    }

    public void setViewHolderAdapter(a aVar) {
        this.gMw = aVar;
    }
}
