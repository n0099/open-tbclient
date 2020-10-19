package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes23.dex */
public class h extends af.a {
    public View ild;

    public h(View view) {
        super(view);
        this.ild = view;
    }

    public void xJ(int i) {
        if (i < 0) {
            this.ild.setMinimumHeight(0);
        } else {
            this.ild.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            ap.setBackgroundResource(this.ild, i);
        }
    }
}
