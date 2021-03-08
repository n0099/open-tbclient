package com.baidu.tieba.barselect;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
/* loaded from: classes7.dex */
public class VoteViewHolder extends RecyclerView.ViewHolder {
    private VoteCandidateCard ise;

    public VoteViewHolder(View view) {
        super(view);
        if (view instanceof VoteCandidateCard) {
            this.ise = (VoteCandidateCard) view;
        }
    }

    public void setData(int i, f fVar) {
        if (this.ise != null) {
            this.ise.setData(i, fVar);
        }
    }
}
