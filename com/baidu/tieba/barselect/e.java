package com.baidu.tieba.barselect;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
/* loaded from: classes8.dex */
public class e extends RecyclerView.ViewHolder {
    private VoteCandidateCard giE;

    public e(View view) {
        super(view);
        if (view instanceof VoteCandidateCard) {
            this.giE = (VoteCandidateCard) view;
        }
    }

    public void setData(int i, f fVar) {
        if (this.giE != null) {
            this.giE.setData(i, fVar);
        }
    }
}
