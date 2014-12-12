package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.view.ak;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class q extends ak {
    public q(Context context) {
        super(context);
    }

    @Override // com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public View jx() {
        View jx = super.jx();
        this.ws.setVisibility(4);
        this.wt.setVisibility(4);
        this.wu.setVisibility(4);
        return jx;
    }

    @Override // com.baidu.tbadk.core.view.ak
    public void cl(int i) {
        super.cl(i);
        this.wr.setBackgroundColor(getContext().getResources().getColor(t.transparent));
    }

    @Override // com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public void Q(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public void jA() {
    }

    @Override // com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public void jB() {
    }

    @Override // com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public void R(boolean z) {
    }
}
