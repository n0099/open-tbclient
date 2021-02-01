package com.baidu.tieba.barselect;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
/* loaded from: classes8.dex */
public class VoteViewHolder extends RecyclerView.ViewHolder {
    private VoteCandidateCard iqh;

    public VoteViewHolder(View view) {
        super(view);
        if (view instanceof VoteCandidateCard) {
            this.iqh = (VoteCandidateCard) view;
        }
    }

    public void setData(int i, f fVar) {
        if (this.iqh != null) {
            this.iqh.setData(i, fVar);
        }
    }
}
