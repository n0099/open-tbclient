package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes5.dex */
public class h extends v.a {
    public View eVj;

    public h(View view) {
        super(view);
        this.eVj = view;
    }

    public void pE(int i) {
        if (i < 0) {
            this.eVj.setMinimumHeight(0);
        } else {
            this.eVj.setMinimumHeight(i);
        }
    }

    public void hY(int i) {
        if (i != 0) {
            al.k(this.eVj, i);
        }
    }
}
