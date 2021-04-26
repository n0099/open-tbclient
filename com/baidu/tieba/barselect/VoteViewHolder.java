package com.baidu.tieba.barselect;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
import d.a.j0.v.b.f;
/* loaded from: classes4.dex */
public class VoteViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public VoteCandidateCard f14896a;

    public VoteViewHolder(View view) {
        super(view);
        if (view instanceof VoteCandidateCard) {
            this.f14896a = (VoteCandidateCard) view;
        }
    }

    public void a(int i2, f fVar) {
        VoteCandidateCard voteCandidateCard = this.f14896a;
        if (voteCandidateCard != null) {
            voteCandidateCard.setData(i2, fVar);
        }
    }
}
