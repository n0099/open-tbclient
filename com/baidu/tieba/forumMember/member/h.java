package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes3.dex */
public class h extends q.a {
    public View doT;

    public h(View view) {
        super(view);
        this.doT = view;
    }

    public void kF(int i) {
        if (i < 0) {
            this.doT.setMinimumHeight(0);
        } else {
            this.doT.setMinimumHeight(i);
        }
    }

    public void dJ(int i) {
        if (i != 0) {
            al.i(this.doT, i);
        }
    }
}
