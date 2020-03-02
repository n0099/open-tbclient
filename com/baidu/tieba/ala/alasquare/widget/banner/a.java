package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.v;
import java.util.List;
/* loaded from: classes3.dex */
public class a<T> extends RecyclerView.Adapter<b> {
    private List<T> acz;
    private c euC;
    private c euD;
    private boolean euE;
    private d euy;
    private Context mContext;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.widget.banner.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.euy != null) {
                a.this.euy.ap(view.getTag());
            }
        }
    };

    public a(Context context, c cVar, boolean z) {
        this.mContext = context;
        this.euC = cVar;
        this.euE = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: n */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.euC != null) {
            return this.euC.m(viewGroup, i);
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
            Object item = v.getItem(this.acz, oU(i));
            if (item != null) {
                bVar.h(i, item);
                bVar.itemView.setTag(item);
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                bVar.itemView.setOnClickListener(this.mOnClickListener);
            }
        }
    }

    private int oU(int i) {
        if (v.getCount(this.acz) != 0) {
            return i % v.getCount(this.acz);
        }
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (v.isEmpty(this.acz) || v.getCount(this.acz) == 1) {
            return v.getCount(this.acz);
        }
        return this.euE ? v.getCount(this.acz) * 3 : v.getCount(this.acz);
    }

    public int bdC() {
        return v.getCount(this.acz);
    }

    public void setData(List<T> list) {
        this.acz = list;
    }

    public void setOnBannerClickListener(d dVar) {
        this.euy = dVar;
    }

    public void setViewHolderAdapter(c cVar) {
        this.euD = cVar;
    }
}
