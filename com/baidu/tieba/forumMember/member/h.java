package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes3.dex */
public class h extends q.a {
    public View dwV;

    public h(View view) {
        super(view);
        this.dwV = view;
    }

    public void ld(int i) {
        if (i < 0) {
            this.dwV.setMinimumHeight(0);
        } else {
            this.dwV.setMinimumHeight(i);
        }
    }

    public void dT(int i) {
        if (i != 0) {
            al.i(this.dwV, i);
        }
    }
}
