package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes10.dex */
public class h extends aa.a {
    public View hjP;

    public h(View view) {
        super(view);
        this.hjP = view;
    }

    public void tw(int i) {
        if (i < 0) {
            this.hjP.setMinimumHeight(0);
        } else {
            this.hjP.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            am.setBackgroundResource(this.hjP, i);
        }
    }
}
