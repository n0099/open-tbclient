package com.baidu.tieba.barselect;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.tieba.barselect.data.f;
import com.baidu.tieba.barselect.view.VoteCandidateCard;
/* loaded from: classes15.dex */
public class e extends RecyclerView.ViewHolder {
    private VoteCandidateCard hcV;

    public e(View view) {
        super(view);
        if (view instanceof VoteCandidateCard) {
            this.hcV = (VoteCandidateCard) view;
        }
    }

    public void setData(int i, f fVar) {
        if (this.hcV != null) {
            this.hcV.setData(i, fVar);
        }
    }
}
