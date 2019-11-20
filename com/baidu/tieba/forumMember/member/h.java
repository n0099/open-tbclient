package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes5.dex */
public class h extends v.a {
    public View frb;

    public h(View view) {
        super(view);
        this.frb = view;
    }

    public void pZ(int i) {
        if (i < 0) {
            this.frb.setMinimumHeight(0);
        } else {
            this.frb.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            am.setBackgroundResource(this.frb, i);
        }
    }
}
