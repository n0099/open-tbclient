package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes10.dex */
public class h extends v.a {
    public View gkJ;

    public h(View view) {
        super(view);
        this.gkJ = view;
    }

    public void sq(int i) {
        if (i < 0) {
            this.gkJ.setMinimumHeight(0);
        } else {
            this.gkJ.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            am.setBackgroundResource(this.gkJ, i);
        }
    }
}
