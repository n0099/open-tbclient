package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes7.dex */
public class h extends v.a {
    public View gfy;

    public h(View view) {
        super(view);
        this.gfy = view;
    }

    public void sf(int i) {
        if (i < 0) {
            this.gfy.setMinimumHeight(0);
        } else {
            this.gfy.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            am.setBackgroundResource(this.gfy, i);
        }
    }
}
