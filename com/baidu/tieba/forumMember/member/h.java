package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes22.dex */
public class h extends af.a {
    public View iEm;

    public h(View view) {
        super(view);
        this.iEm = view;
    }

    public void yN(int i) {
        if (i < 0) {
            this.iEm.setMinimumHeight(0);
        } else {
            this.iEm.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            ap.setBackgroundResource(this.iEm, i);
        }
    }
}
