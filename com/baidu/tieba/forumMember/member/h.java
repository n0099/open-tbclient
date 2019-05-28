package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes5.dex */
public class h extends v.a {
    public View flv;

    public h(View view) {
        super(view);
        this.flv = view;
    }

    public void qK(int i) {
        if (i < 0) {
            this.flv.setMinimumHeight(0);
        } else {
            this.flv.setMinimumHeight(i);
        }
    }

    public void iM(int i) {
        if (i != 0) {
            al.k(this.flv, i);
        }
    }
}
