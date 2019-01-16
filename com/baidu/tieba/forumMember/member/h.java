package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes3.dex */
public class h extends q.a {
    public View dIj;

    public h(View view) {
        super(view);
        this.dIj = view;
    }

    public void lZ(int i) {
        if (i < 0) {
            this.dIj.setMinimumHeight(0);
        } else {
            this.dIj.setMinimumHeight(i);
        }
    }

    public void ev(int i) {
        if (i != 0) {
            al.i(this.dIj, i);
        }
    }
}
