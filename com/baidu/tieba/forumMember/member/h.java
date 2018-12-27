package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes3.dex */
public class h extends q.a {
    public View dHA;

    public h(View view) {
        super(view);
        this.dHA = view;
    }

    public void lY(int i) {
        if (i < 0) {
            this.dHA.setMinimumHeight(0);
        } else {
            this.dHA.setMinimumHeight(i);
        }
    }

    public void ev(int i) {
        if (i != 0) {
            al.i(this.dHA, i);
        }
    }
}
