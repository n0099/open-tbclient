package com.baidu.tieba.barselect;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
/* loaded from: classes21.dex */
public class e extends RecyclerView.ViewHolder {
    private VoteCandidateCard hLq;

    public e(View view) {
        super(view);
        if (view instanceof VoteCandidateCard) {
            this.hLq = (VoteCandidateCard) view;
        }
    }

    public void setData(int i, f fVar) {
        if (this.hLq != null) {
            this.hLq.setData(i, fVar);
        }
    }
}
