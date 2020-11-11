package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes23.dex */
public class h extends af.a {
    public View iDy;

    public h(View view) {
        super(view);
        this.iDy = view;
    }

    public void yp(int i) {
        if (i < 0) {
            this.iDy.setMinimumHeight(0);
        } else {
            this.iDy.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            ap.setBackgroundResource(this.iDy, i);
        }
    }
}
