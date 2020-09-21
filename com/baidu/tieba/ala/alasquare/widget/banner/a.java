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
    private List<T> aKx;
    private d fQG;
    private c fQK;
    private c fQL;
    private boolean fQM;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fQG != null) {
                a.this.fQG.aB(view.getTag());
            }
        }
    };

    public a(Context context, c cVar, boolean z) {
        this.mContext = context;
        this.fQK = cVar;
        this.fQM = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: o */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.fQK != null) {
            return this.fQK.n(viewGroup, i);
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
            Object item = y.getItem(this.aKx, tk(i));
            if (item != null) {
                bVar.h(i, item);
                bVar.itemView.setTag(item);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                bVar.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int tk(int i) {
        if (y.getCount(this.aKx) != 0) {
            return i % y.getCount(this.aKx);
        }
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (y.isEmpty(this.aKx) || y.getCount(this.aKx) == 1) {
            return y.getCount(this.aKx);
        }
        return this.fQM ? y.getCount(this.aKx) * 3 : y.getCount(this.aKx);
    }

    public int bIt() {
        return y.getCount(this.aKx);
    }

    public void setData(List<T> list) {
        this.aKx = list;
    }

    public void setOnBannerClickListener(d dVar) {
        this.fQG = dVar;
    }

    public void setViewHolderAdapter(c cVar) {
        this.fQL = cVar;
    }
}
