package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes3.dex */
public class h extends q.a {
    public View dEM;

    public h(View view) {
        super(view);
        this.dEM = view;
    }

    public void lL(int i) {
        if (i < 0) {
            this.dEM.setMinimumHeight(0);
        } else {
            this.dEM.setMinimumHeight(i);
        }
    }

    public void ev(int i) {
        if (i != 0) {
            al.i(this.dEM, i);
        }
    }
}
