package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes23.dex */
public class h extends af.a {
    public View ixB;

    public h(View view) {
        super(view);
        this.ixB = view;
    }

    public void yc(int i) {
        if (i < 0) {
            this.ixB.setMinimumHeight(0);
        } else {
            this.ixB.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            ap.setBackgroundResource(this.ixB, i);
        }
    }
}
