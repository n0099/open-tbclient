package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes22.dex */
public class h extends af.a {
    public View hWe;

    public h(View view) {
        super(view);
        this.hWe = view;
    }

    public void xd(int i) {
        if (i < 0) {
            this.hWe.setMinimumHeight(0);
        } else {
            this.hWe.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            ap.setBackgroundResource(this.hWe, i);
        }
    }
}
