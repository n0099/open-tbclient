package com.baidu.tieba.barselect;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<com.baidu.tieba.barselect.data.d> gxz;
    private TbPageContext mPageContext;
    private f mVoteData;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(f fVar) {
        this.mVoteData = fVar;
        if (fVar != null) {
            this.gxz = fVar.bKm();
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: o */
    public e onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new e(new VoteCandidateCard(this.mPageContext.getPageActivity()));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof e) {
            ((e) viewHolder).setData(i, this.mVoteData);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.gxz != null) {
            return this.gxz.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.gxz == null || this.gxz.size() <= i || this.gxz.get(i).getRank() != 1 || i != 0) {
            return 0;
        }
        return com.baidu.tieba.barselect.a.a.gAD;
    }
}
