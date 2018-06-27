package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes3.dex */
public class h extends q.a {
    public View dgm;

    public h(View view) {
        super(view);
        this.dgm = view;
    }

    public void jW(int i) {
        if (i < 0) {
            this.dgm.setMinimumHeight(0);
        } else {
            this.dgm.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            am.i(this.dgm, i);
        }
    }
}
