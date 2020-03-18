package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes10.dex */
public class h extends v.a {
    public View glG;

    public h(View view) {
        super(view);
        this.glG = view;
    }

    public void ss(int i) {
        if (i < 0) {
            this.glG.setMinimumHeight(0);
        } else {
            this.glG.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            am.setBackgroundResource(this.glG, i);
        }
    }
}
