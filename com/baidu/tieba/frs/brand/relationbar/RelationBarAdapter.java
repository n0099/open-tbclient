package com.baidu.tieba.frs.brand.relationbar;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.List;
import tbclient.OriForumInfo;
/* loaded from: classes4.dex */
public class RelationBarAdapter extends RecyclerView.Adapter<RelationBarHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f15253a;

    /* renamed from: b  reason: collision with root package name */
    public List<OriForumInfo> f15254b;

    public RelationBarAdapter(Context context) {
        this.f15253a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(RelationBarHolder relationBarHolder, int i2) {
        OriForumInfo oriForumInfo = (OriForumInfo) ListUtils.getItem(this.f15254b, i2);
        if (oriForumInfo == null) {
            return;
        }
        RelationBarCellView relationBarCellView = (RelationBarCellView) relationBarHolder.a();
        relationBarCellView.setData(oriForumInfo);
        relationBarCellView.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public RelationBarHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new RelationBarHolder(new RelationBarCellView(this.f15253a));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f15254b);
    }

    public void setData(List<OriForumInfo> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f15254b = list;
    }
}
