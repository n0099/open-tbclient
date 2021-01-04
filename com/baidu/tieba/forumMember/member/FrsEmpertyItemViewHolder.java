package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes8.dex */
public class FrsEmpertyItemViewHolder extends TypeAdapter.ViewHolder {
    public View jbs;

    public FrsEmpertyItemViewHolder(View view) {
        super(view);
        this.jbs = view;
    }

    public void zF(int i) {
        if (i < 0) {
            this.jbs.setMinimumHeight(0);
        } else {
            this.jbs.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            ao.setBackgroundResource(this.jbs, i);
        }
    }
}
