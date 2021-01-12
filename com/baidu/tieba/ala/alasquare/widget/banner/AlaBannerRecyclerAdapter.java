package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import java.util.List;
/* loaded from: classes9.dex */
public class AlaBannerRecyclerAdapter<T> extends RecyclerView.Adapter<AlaBannerViewHolder> {
    private List<T> bWQ;
    private b gHL;
    private a gHP;
    private a gHQ;
    private boolean gHR;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerAdapter.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AlaBannerRecyclerAdapter.this.gHL != null) {
                AlaBannerRecyclerAdapter.this.gHL.aG(view.getTag());
            }
        }
    };

    public AlaBannerRecyclerAdapter(Context context, a aVar, boolean z) {
        this.mContext = context;
        this.gHP = aVar;
        this.gHR = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: u */
    public AlaBannerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.gHP != null) {
            return this.gHP.t(viewGroup, i);
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
            Object item = x.getItem(this.bWQ, tS(i));
            if (item != null) {
                alaBannerViewHolder.k(i, item);
                alaBannerViewHolder.itemView.setTag(item);
                alaBannerViewHolder.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                alaBannerViewHolder.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int tS(int i) {
        if (x.getCount(this.bWQ) != 0) {
            return i % x.getCount(this.bWQ);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (x.isEmpty(this.bWQ) || x.getCount(this.bWQ) == 1) {
            return x.getCount(this.bWQ);
        }
        return this.gHR ? x.getCount(this.bWQ) * 3 : x.getCount(this.bWQ);
    }

    public int bRY() {
        return x.getCount(this.bWQ);
    }

    public void setData(List<T> list) {
        this.bWQ = list;
    }

    public void setOnBannerClickListener(b bVar) {
        this.gHL = bVar;
    }

    public void setViewHolderAdapter(a aVar) {
        this.gHQ = aVar;
    }
}
