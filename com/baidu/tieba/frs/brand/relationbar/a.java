package com.baidu.tieba.frs.brand.relationbar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.w;
import java.util.List;
import tbclient.OriForumInfo;
/* loaded from: classes2.dex */
public class a extends RecyclerView.Adapter<b> {
    private List<OriForumInfo> dsp;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: n */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(new RelationBarCellView(this.mContext));
    }

    public void setData(List<OriForumInfo> list) {
        if (!w.z(list)) {
            this.dsp = list;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i) {
        OriForumInfo oriForumInfo = (OriForumInfo) w.d(this.dsp, i);
        if (oriForumInfo != null) {
            RelationBarCellView relationBarCellView = (RelationBarCellView) bVar.awu();
            relationBarCellView.setData(oriForumInfo);
            relationBarCellView.onChangeSkinType();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return w.y(this.dsp);
    }
}
