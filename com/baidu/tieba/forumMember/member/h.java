package com.baidu.tieba.forumMember.member;

import android.view.View;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes10.dex */
public class h extends ad.a {
    public View hvX;

    public h(View view) {
        super(view);
        this.hvX = view;
    }

    public void tX(int i) {
        if (i < 0) {
            this.hvX.setMinimumHeight(0);
        } else {
            this.hvX.setMinimumHeight(i);
        }
    }

    public void setBackground(int i) {
        if (i != 0) {
            an.setBackgroundResource(this.hvX, i);
        }
    }
}
