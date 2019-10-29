package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes5.dex */
public class h extends v.a {
    public View frT;

    public h(View view) {
        super(view);
        this.frT = view;
    }

    public void qa(int i) {
        if (i < 0) {
            this.frT.setMinimumHeight(0);
        } else {
            this.frT.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            am.setBackgroundResource(this.frT, i);
        }
    }
}
