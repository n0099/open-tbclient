package com.baidu.tieba.frs.brand.relationbar;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.OriForumInfo;
/* loaded from: classes2.dex */
public class RelationBarAdapter extends RecyclerView.Adapter<RelationBarHolder> {
    private List<OriForumInfo> jqF;
    private Context mContext;

    public RelationBarAdapter(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: D */
    public RelationBarHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new RelationBarHolder(new RelationBarCellView(this.mContext));
    }

    public void setData(List<OriForumInfo> list) {
        if (!y.isEmpty(list)) {
            this.jqF = list;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(RelationBarHolder relationBarHolder, int i) {
        OriForumInfo oriForumInfo = (OriForumInfo) y.getItem(this.jqF, i);
        if (oriForumInfo != null) {
            RelationBarCellView relationBarCellView = (RelationBarCellView) relationBarHolder.cFM();
            relationBarCellView.setData(oriForumInfo);
            relationBarCellView.onChangeSkinType();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.jqF);
    }
}
