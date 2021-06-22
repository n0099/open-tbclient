package com.baidu.tieba.barselect;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import d.a.o0.x.b.d;
import d.a.o0.x.b.f;
import d.a.o0.x.e.a;
import java.util.List;
/* loaded from: classes4.dex */
public class VoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f14249a;

    /* renamed from: b  reason: collision with root package name */
    public f f14250b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f14251c;

    /* renamed from: d  reason: collision with root package name */
    public int f14252d = -1;

    public VoteAdapter(TbPageContext tbPageContext) {
        this.f14249a = tbPageContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<d> list = this.f14251c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        List<d> list = this.f14251c;
        if (list == null || list.size() <= i2 || this.f14251c.get(i2).i() != 1 || i2 != 0) {
            return 0;
        }
        return a.f67043c;
    }

    public int m() {
        return this.f14252d;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public VoteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        VoteCandidateCard voteCandidateCard = new VoteCandidateCard(this.f14249a.getPageActivity());
        voteCandidateCard.setVoteAdaPter(this);
        return new VoteViewHolder(voteCandidateCard);
    }

    public void o(int i2) {
        this.f14252d = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder instanceof VoteViewHolder) {
            ((VoteViewHolder) viewHolder).a(i2, this.f14250b);
        }
    }

    public void p(f fVar) {
        this.f14250b = fVar;
        if (fVar != null) {
            this.f14251c = fVar.b();
        }
        this.f14252d = -1;
        notifyDataSetChanged();
    }
}
