package com.baidu.tieba.barselect;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import java.util.List;
/* loaded from: classes21.dex */
public class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<com.baidu.tieba.barselect.data.d> hLo;
    private int hLp = -1;
    private TbPageContext mPageContext;
    private f mVoteData;

    public d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(f fVar) {
        this.mVoteData = fVar;
        if (fVar != null) {
            this.hLo = fVar.ckJ();
        }
        this.hLp = -1;
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: t */
    public e onCreateViewHolder(ViewGroup viewGroup, int i) {
        VoteCandidateCard voteCandidateCard = new VoteCandidateCard(this.mPageContext.getPageActivity());
        voteCandidateCard.setVoteAdaPter(this);
        return new e(voteCandidateCard);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof e) {
            ((e) viewHolder).setData(i, this.mVoteData);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.hLo != null) {
            return this.hLo.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.hLo == null || this.hLo.size() <= i || this.hLo.get(i).getRank() != 1 || i != 0) {
            return 0;
        }
        return com.baidu.tieba.barselect.a.a.hOt;
    }

    public int cku() {
        return this.hLp;
    }

    public void wB(int i) {
        this.hLp = i;
    }
}
