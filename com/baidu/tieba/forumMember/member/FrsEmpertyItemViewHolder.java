package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes7.dex */
public class FrsEmpertyItemViewHolder extends TypeAdapter.ViewHolder {
    public View jep;

    public FrsEmpertyItemViewHolder(View view) {
        super(view);
        this.jep = view;
    }

    public void yk(int i) {
        if (i < 0) {
            this.jep.setMinimumHeight(0);
        } else {
            this.jep.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            ap.setBackgroundResource(this.jep, i);
        }
    }
}
