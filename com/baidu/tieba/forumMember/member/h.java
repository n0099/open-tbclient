package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes10.dex */
public class h extends aa.a {
    public View hjE;

    public h(View view) {
        super(view);
        this.hjE = view;
    }

    public void tu(int i) {
        if (i < 0) {
            this.hjE.setMinimumHeight(0);
        } else {
            this.hjE.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            am.setBackgroundResource(this.hjE, i);
        }
    }
}
