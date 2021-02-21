package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaBannerRecyclerAdapter<T> extends RecyclerView.Adapter<AlaBannerViewHolder> {
    private List<T> caS;
    private b gKJ;
    private a gKN;
    private a gKO;
    private boolean gKP;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerAdapter.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AlaBannerRecyclerAdapter.this.gKJ != null) {
                AlaBannerRecyclerAdapter.this.gKJ.aG(view.getTag());
            }
        }
    };

    public AlaBannerRecyclerAdapter(Context context, a aVar, boolean z) {
        this.mContext = context;
        this.gKN = aVar;
        this.gKP = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: u */
    public AlaBannerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.gKN != null) {
            return this.gKN.t(viewGroup, i);
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
            Object item = y.getItem(this.caS, tY(i));
            if (item != null) {
                alaBannerViewHolder.k(i, item);
                alaBannerViewHolder.itemView.setTag(item);
                alaBannerViewHolder.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                alaBannerViewHolder.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int tY(int i) {
        if (y.getCount(this.caS) != 0) {
            return i % y.getCount(this.caS);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (y.isEmpty(this.caS) || y.getCount(this.caS) == 1) {
            return y.getCount(this.caS);
        }
        return this.gKP ? y.getCount(this.caS) * 3 : y.getCount(this.caS);
    }

    public int bSI() {
        return y.getCount(this.caS);
    }

    public void setData(List<T> list) {
        this.caS = list;
    }

    public void setOnBannerClickListener(b bVar) {
        this.gKJ = bVar;
    }

    public void setViewHolderAdapter(a aVar) {
        this.gKO = aVar;
    }
}
