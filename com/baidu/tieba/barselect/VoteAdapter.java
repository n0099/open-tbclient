package com.baidu.tieba.barselect;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import d.a.j0.v.b.d;
import d.a.j0.v.b.f;
import d.a.j0.v.e.a;
import java.util.List;
/* loaded from: classes4.dex */
public class VoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f14892a;

    /* renamed from: b  reason: collision with root package name */
    public f f14893b;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f14894c;

    /* renamed from: d  reason: collision with root package name */
    public int f14895d = -1;

    public VoteAdapter(TbPageContext tbPageContext) {
        this.f14892a = tbPageContext;
    }

    public int c() {
        return this.f14895d;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public VoteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        VoteCandidateCard voteCandidateCard = new VoteCandidateCard(this.f14892a.getPageActivity());
        voteCandidateCard.setVoteAdaPter(this);
        return new VoteViewHolder(voteCandidateCard);
    }

    public void e(int i2) {
        this.f14895d = i2;
    }

    public void f(f fVar) {
        this.f14893b = fVar;
        if (fVar != null) {
            this.f14894c = fVar.b();
        }
        this.f14895d = -1;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<d> list = this.f14894c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        List<d> list = this.f14894c;
        if (list == null || list.size() <= i2 || this.f14894c.get(i2).i() != 1 || i2 != 0) {
            return 0;
        }
        return a.f61617c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder instanceof VoteViewHolder) {
            ((VoteViewHolder) viewHolder).a(i2, this.f14893b);
        }
    }
}
