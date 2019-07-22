package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes5.dex */
public class h extends v.a {
    public View fqt;

    public h(View view) {
        super(view);
        this.fqt = view;
    }

    public void rc(int i) {
        if (i < 0) {
            this.fqt.setMinimumHeight(0);
        } else {
            this.fqt.setMinimumHeight(i);
        }
    }

    public void iS(int i) {
        if (i != 0) {
            am.k(this.fqt, i);
        }
    }
}
