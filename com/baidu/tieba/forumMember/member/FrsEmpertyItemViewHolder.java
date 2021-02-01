package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes8.dex */
public class FrsEmpertyItemViewHolder extends TypeAdapter.ViewHolder {
    public View jcs;

    public FrsEmpertyItemViewHolder(View view) {
        super(view);
        this.jcs = view;
    }

    public void yj(int i) {
        if (i < 0) {
            this.jcs.setMinimumHeight(0);
        } else {
            this.jcs.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            ap.setBackgroundResource(this.jcs, i);
        }
    }
}
