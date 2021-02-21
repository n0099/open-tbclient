package com.baidu.tieba.barselect;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.barselect.data.d;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import java.util.List;
/* loaded from: classes8.dex */
public class VoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<d> iqt;
    private int iqu = -1;
    private TbPageContext mPageContext;
    private f mVoteData;

    public VoteAdapter(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(f fVar) {
        this.mVoteData = fVar;
        if (fVar != null) {
            this.iqt = fVar.cru();
        }
        this.iqu = -1;
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: y */
    public VoteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        VoteCandidateCard voteCandidateCard = new VoteCandidateCard(this.mPageContext.getPageActivity());
        voteCandidateCard.setVoteAdaPter(this);
        return new VoteViewHolder(voteCandidateCard);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof VoteViewHolder) {
            ((VoteViewHolder) viewHolder).setData(i, this.mVoteData);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.iqt != null) {
            return this.iqt.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.iqt == null || this.iqt.size() <= i || this.iqt.get(i).getRank() != 1 || i != 0) {
            return 0;
        }
        return com.baidu.tieba.barselect.a.a.itv;
    }

    public int crf() {
        return this.iqu;
    }

    public void wK(int i) {
        this.iqu = i;
    }
}
