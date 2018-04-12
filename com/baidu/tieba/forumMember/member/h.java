package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes3.dex */
public class h extends q.a {
    public View cUf;

    public h(View view2) {
        super(view2);
        this.cUf = view2;
    }

    public void jS(int i) {
        if (i < 0) {
            this.cUf.setMinimumHeight(0);
        } else {
            this.cUf.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            ak.i(this.cUf, i);
        }
    }
}
