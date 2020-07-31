package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes17.dex */
public class h extends ad.a {
    public View hBJ;

    public h(View view) {
        super(view);
        this.hBJ = view;
    }

    public void up(int i) {
        if (i < 0) {
            this.hBJ.setMinimumHeight(0);
        } else {
            this.hBJ.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            ao.setBackgroundResource(this.hBJ, i);
        }
    }
}
