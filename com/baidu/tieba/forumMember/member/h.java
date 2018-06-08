package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes3.dex */
public class h extends q.a {
    public View dev;

    public h(View view) {
        super(view);
        this.dev = view;
    }

    public void jT(int i) {
        if (i < 0) {
            this.dev.setMinimumHeight(0);
        } else {
            this.dev.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            al.i(this.dev, i);
        }
    }
}
