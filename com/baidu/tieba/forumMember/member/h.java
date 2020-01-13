package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes8.dex */
public class h extends v.a {
    public View giI;

    public h(View view) {
        super(view);
        this.giI = view;
    }

    public void sk(int i) {
        if (i < 0) {
            this.giI.setMinimumHeight(0);
        } else {
            this.giI.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            am.setBackgroundResource(this.giI, i);
        }
    }
}
