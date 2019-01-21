package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes3.dex */
public class h extends q.a {
    public View dIk;

    public h(View view) {
        super(view);
        this.dIk = view;
    }

    public void lZ(int i) {
        if (i < 0) {
            this.dIk.setMinimumHeight(0);
        } else {
            this.dIk.setMinimumHeight(i);
        }
    }

    public void ev(int i) {
        if (i != 0) {
            al.i(this.dIk, i);
        }
    }
}
