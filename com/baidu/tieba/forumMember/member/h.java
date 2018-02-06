package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.util.aj;
/* loaded from: classes3.dex */
public class h extends r.a {
    public View dBC;

    public h(View view) {
        super(view);
        this.dBC = view;
    }

    public void mF(int i) {
        if (i < 0) {
            this.dBC.setMinimumHeight(0);
        } else {
            this.dBC.setMinimumHeight(i);
        }
    }

    public void gu(int i) {
        if (i != 0) {
            aj.s(this.dBC, i);
        }
    }
}
