package com.baidu.tieba.barselect;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import d.b.i0.v.b.d;
import d.b.i0.v.b.f;
import d.b.i0.v.e.a;
import java.util.List;
/* loaded from: classes4.dex */
public class VoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f15132a;

    /* renamed from: b  reason: collision with root package name */
    public f f15133b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f15134c;

    /* renamed from: d  reason: collision with root package name */
    public int f15135d = -1;

    public VoteAdapter(TbPageContext tbPageContext) {
        this.f15132a = tbPageContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<d> list = this.f15134c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        List<d> list = this.f15134c;
        if (list == null || list.size() <= i || this.f15134c.get(i).i() != 1 || i != 0) {
            return 0;
        }
        return a.f61956c;
    }

    public int m() {
        return this.f15135d;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public VoteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        VoteCandidateCard voteCandidateCard = new VoteCandidateCard(this.f15132a.getPageActivity());
        voteCandidateCard.setVoteAdaPter(this);
        return new VoteViewHolder(voteCandidateCard);
    }

    public void o(int i) {
        this.f15135d = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof VoteViewHolder) {
            ((VoteViewHolder) viewHolder).a(i, this.f15133b);
        }
    }

    public void p(f fVar) {
        this.f15133b = fVar;
        if (fVar != null) {
            this.f15134c = fVar.b();
        }
        this.f15135d = -1;
        notifyDataSetChanged();
    }
}
