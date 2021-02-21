package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes8.dex */
public class FrsEmpertyItemViewHolder extends TypeAdapter.ViewHolder {
    public View jcG;

    public FrsEmpertyItemViewHolder(View view) {
        super(view);
        this.jcG = view;
    }

    public void yj(int i) {
        if (i < 0) {
            this.jcG.setMinimumHeight(0);
        } else {
            this.jcG.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            ap.setBackgroundResource(this.jcG, i);
        }
    }
}
