package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes17.dex */
public class h extends af.a {
    public View hOY;

    public h(View view) {
        super(view);
        this.hOY = view;
    }

    public void wE(int i) {
        if (i < 0) {
            this.hOY.setMinimumHeight(0);
        } else {
            this.hOY.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            ap.setBackgroundResource(this.hOY, i);
        }
    }
}
