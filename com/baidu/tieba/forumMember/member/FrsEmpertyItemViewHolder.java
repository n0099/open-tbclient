package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes7.dex */
public class FrsEmpertyItemViewHolder extends TypeAdapter.ViewHolder {
    public View iWL;

    public FrsEmpertyItemViewHolder(View view) {
        super(view);
        this.iWL = view;
    }

    public void xZ(int i) {
        if (i < 0) {
            this.iWL.setMinimumHeight(0);
        } else {
            this.iWL.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            ao.setBackgroundResource(this.iWL, i);
        }
    }
}
