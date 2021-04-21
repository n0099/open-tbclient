package com.baidu.tieba.barselect;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import d.b.j0.v.b.f;
/* loaded from: classes4.dex */
public class VoteViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public VoteCandidateCard f14808a;

    public VoteViewHolder(View view) {
        super(view);
        if (view instanceof VoteCandidateCard) {
            this.f14808a = (VoteCandidateCard) view;
        }
    }

    public void a(int i, f fVar) {
        VoteCandidateCard voteCandidateCard = this.f14808a;
        if (voteCandidateCard != null) {
            voteCandidateCard.setData(i, fVar);
        }
    }
}
