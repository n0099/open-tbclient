package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes10.dex */
public class h extends y.a {
    public View gUS;

    public h(View view) {
        super(view);
        this.gUS = view;
    }

    public void sP(int i) {
        if (i < 0) {
            this.gUS.setMinimumHeight(0);
        } else {
            this.gUS.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            am.setBackgroundResource(this.gUS, i);
        }
    }
}
