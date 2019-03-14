package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes5.dex */
public class h extends v.a {
    public View eVx;

    public h(View view) {
        super(view);
        this.eVx = view;
    }

    public void pI(int i) {
        if (i < 0) {
            this.eVx.setMinimumHeight(0);
        } else {
            this.eVx.setMinimumHeight(i);
        }
    }

    public void hZ(int i) {
        if (i != 0) {
            al.k(this.eVx, i);
        }
    }
}
