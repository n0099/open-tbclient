package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes3.dex */
public class h extends q.a {
    public View djc;

    public h(View view) {
        super(view);
        this.djc = view;
    }

    public void kh(int i) {
        if (i < 0) {
            this.djc.setMinimumHeight(0);
        } else {
            this.djc.setMinimumHeight(i);
        }
    }

    public void dz(int i) {
        if (i != 0) {
            am.i(this.djc, i);
        }
    }
}
