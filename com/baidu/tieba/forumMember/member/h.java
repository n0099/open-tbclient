package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes23.dex */
public class h extends af.a {
    public View iPe;

    public h(View view) {
        super(view);
        this.iPe = view;
    }

    public void zs(int i) {
        if (i < 0) {
            this.iPe.setMinimumHeight(0);
        } else {
            this.iPe.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            ap.setBackgroundResource(this.iPe, i);
        }
    }
}
