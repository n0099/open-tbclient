package com.baidu.tieba.barselect;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
/* loaded from: classes8.dex */
public class e extends RecyclerView.ViewHolder {
    private VoteCandidateCard gxA;

    public e(View view) {
        super(view);
        if (view instanceof VoteCandidateCard) {
            this.gxA = (VoteCandidateCard) view;
        }
    }

    public void setData(int i, f fVar) {
        if (this.gxA != null) {
            this.gxA.setData(i, fVar);
        }
    }
}
