package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes3.dex */
public class h extends q.a {
    public View cVj;

    public h(View view2) {
        super(view2);
        this.cVj = view2;
    }

    public void jQ(int i) {
        if (i < 0) {
            this.cVj.setMinimumHeight(0);
        } else {
            this.cVj.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            ak.i(this.cVj, i);
        }
    }
}
