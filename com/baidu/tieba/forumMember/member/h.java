package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes5.dex */
public class h extends v.a {
    public View fsG;

    public h(View view) {
        super(view);
        this.fsG = view;
    }

    public void rh(int i) {
        if (i < 0) {
            this.fsG.setMinimumHeight(0);
        } else {
            this.fsG.setMinimumHeight(i);
        }
    }

    public void iV(int i) {
        if (i != 0) {
            am.k(this.fsG, i);
        }
    }
}
