package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes5.dex */
public class h extends v.a {
    public View fqS;

    public h(View view) {
        super(view);
        this.fqS = view;
    }

    public void re(int i) {
        if (i < 0) {
            this.fqS.setMinimumHeight(0);
        } else {
            this.fqS.setMinimumHeight(i);
        }
    }

    public void iS(int i) {
        if (i != 0) {
            am.k(this.fqS, i);
        }
    }
}
