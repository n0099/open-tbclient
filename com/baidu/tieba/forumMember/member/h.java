package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes3.dex */
public class h extends q.a {
    public View dyn;

    public h(View view) {
        super(view);
        this.dyn = view;
    }

    public void lv(int i) {
        if (i < 0) {
            this.dyn.setMinimumHeight(0);
        } else {
            this.dyn.setMinimumHeight(i);
        }
    }

    public void eh(int i) {
        if (i != 0) {
            al.i(this.dyn, i);
        }
    }
}
