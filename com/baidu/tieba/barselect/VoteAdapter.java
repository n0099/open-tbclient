package com.baidu.tieba.barselect;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.barselect.data.d;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import java.util.List;
/* loaded from: classes7.dex */
public class VoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<d> ikx;
    private int iky = -1;
    private TbPageContext mPageContext;
    private f mVoteData;

    public VoteAdapter(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(f fVar) {
        this.mVoteData = fVar;
        if (fVar != null) {
            this.ikx = fVar.cqd();
        }
        this.iky = -1;
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: x */
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
        if (this.ikx != null) {
            return this.ikx.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.ikx == null || this.ikx.size() <= i || this.ikx.get(i).getRank() != 1 || i != 0) {
            return 0;
        }
        return com.baidu.tieba.barselect.a.a.inD;
    }

    public int cpO() {
        return this.iky;
    }

    public void wz(int i) {
        this.iky = i;
    }
}
