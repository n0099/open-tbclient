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
    private List<T> aNC;
    private d gcY;
    private c gdc;
    private c gdd;
    private boolean gde;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gcY != null) {
                a.this.gcY.aE(view.getTag());
            }
        }
    };

    public a(Context context, c cVar, boolean z) {
        this.mContext = context;
        this.gdc = cVar;
        this.gde = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.gdc != null) {
            return this.gdc.p(viewGroup, i);
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
            Object item = y.getItem(this.aNC, tI(i));
            if (item != null) {
                bVar.i(i, item);
                bVar.itemView.setTag(item);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                bVar.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int tI(int i) {
        if (y.getCount(this.aNC) != 0) {
            return i % y.getCount(this.aNC);
        }
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (y.isEmpty(this.aNC) || y.getCount(this.aNC) == 1) {
            return y.getCount(this.aNC);
        }
        return this.gde ? y.getCount(this.aNC) * 3 : y.getCount(this.aNC);
    }

    public int bLd() {
        return y.getCount(this.aNC);
    }

    public void setData(List<T> list) {
        this.aNC = list;
    }

    public void setOnBannerClickListener(d dVar) {
        this.gcY = dVar;
    }

    public void setViewHolderAdapter(c cVar) {
        this.gdd = cVar;
    }
}
