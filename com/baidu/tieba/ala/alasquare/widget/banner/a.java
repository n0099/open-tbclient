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
    private List<T> aJh;
    private d fNs;
    private c fNw;
    private c fNx;
    private boolean fNy;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fNs != null) {
                a.this.fNs.az(view.getTag());
            }
        }
    };

    public a(Context context, c cVar, boolean z) {
        this.mContext = context;
        this.fNw = cVar;
        this.fNy = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: m */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.fNw != null) {
            return this.fNw.l(viewGroup, i);
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
            Object item = y.getItem(this.aJh, sS(i));
            if (item != null) {
                bVar.h(i, item);
                bVar.itemView.setTag(item);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                bVar.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int sS(int i) {
        if (y.getCount(this.aJh) != 0) {
            return i % y.getCount(this.aJh);
        }
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (y.isEmpty(this.aJh) || y.getCount(this.aJh) == 1) {
            return y.getCount(this.aJh);
        }
        return this.fNy ? y.getCount(this.aJh) * 3 : y.getCount(this.aJh);
    }

    public int bHd() {
        return y.getCount(this.aJh);
    }

    public void setData(List<T> list) {
        this.aJh = list;
    }

    public void setOnBannerClickListener(d dVar) {
        this.fNs = dVar;
    }

    public void setViewHolderAdapter(c cVar) {
        this.fNx = cVar;
    }
}
