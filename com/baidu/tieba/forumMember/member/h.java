package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes17.dex */
public class h extends af.a {
    public View hPe;

    public h(View view) {
        super(view);
        this.hPe = view;
    }

    public void wE(int i) {
        if (i < 0) {
            this.hPe.setMinimumHeight(0);
        } else {
            this.hPe.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            ap.setBackgroundResource(this.hPe, i);
        }
    }
}
