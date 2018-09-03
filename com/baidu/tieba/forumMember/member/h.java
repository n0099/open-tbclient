package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes3.dex */
public class h extends q.a {
    public View dja;

    public h(View view) {
        super(view);
        this.dja = view;
    }

    public void kg(int i) {
        if (i < 0) {
            this.dja.setMinimumHeight(0);
        } else {
            this.dja.setMinimumHeight(i);
        }
    }

    public void dy(int i) {
        if (i != 0) {
            am.i(this.dja, i);
        }
    }
}
