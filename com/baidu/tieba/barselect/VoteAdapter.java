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
    public TbPageContext f14796a;

    /* renamed from: b  reason: collision with root package name */
    public f f14797b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f14798c;

    /* renamed from: d  reason: collision with root package name */
    public int f14799d = -1;

    public VoteAdapter(TbPageContext tbPageContext) {
        this.f14796a = tbPageContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<d> list = this.f14798c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        List<d> list = this.f14798c;
        if (list == null || list.size() <= i || this.f14798c.get(i).i() != 1 || i != 0) {
            return 0;
        }
        return a.f62966c;
    }

    public int m() {
        return this.f14799d;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public VoteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        VoteCandidateCard voteCandidateCard = new VoteCandidateCard(this.f14796a.getPageActivity());
        voteCandidateCard.setVoteAdaPter(this);
        return new VoteViewHolder(voteCandidateCard);
    }

    public void o(int i) {
        this.f14799d = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof VoteViewHolder) {
            ((VoteViewHolder) viewHolder).a(i, this.f14797b);
        }
    }

    public void p(f fVar) {
        this.f14797b = fVar;
        if (fVar != null) {
            this.f14798c = fVar.b();
        }
        this.f14799d = -1;
        notifyDataSetChanged();
    }
}
