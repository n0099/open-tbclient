package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import java.util.List;
/* loaded from: classes9.dex */
public class AlaBannerRecyclerAdapter<T> extends RecyclerView.Adapter<AlaBannerViewHolder> {
    private List<T> ccu;
    private b gMs;
    private a gMw;
    private a gMx;
    private boolean gMy;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerAdapter.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AlaBannerRecyclerAdapter.this.gMs != null) {
                AlaBannerRecyclerAdapter.this.gMs.aI(view.getTag());
            }
        }
    };

    public AlaBannerRecyclerAdapter(Context context, a aVar, boolean z) {
        this.mContext = context;
        this.gMw = aVar;
        this.gMy = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: u */
    public AlaBannerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.gMw != null) {
            return this.gMw.t(viewGroup, i);
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
            Object item = y.getItem(this.ccu, ua(i));
            if (item != null) {
                alaBannerViewHolder.k(i, item);
                alaBannerViewHolder.itemView.setTag(item);
                alaBannerViewHolder.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                alaBannerViewHolder.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int ua(int i) {
        if (y.getCount(this.ccu) != 0) {
            return i % y.getCount(this.ccu);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (y.isEmpty(this.ccu) || y.getCount(this.ccu) == 1) {
            return y.getCount(this.ccu);
        }
        return this.gMy ? y.getCount(this.ccu) * 3 : y.getCount(this.ccu);
    }

    public int bSO() {
        return y.getCount(this.ccu);
    }

    public void setData(List<T> list) {
        this.ccu = list;
    }

    public void setOnBannerClickListener(b bVar) {
        this.gMs = bVar;
    }

    public void setViewHolderAdapter(a aVar) {
        this.gMx = aVar;
    }
}
