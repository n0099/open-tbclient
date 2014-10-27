package com.baidu.tieba.im.chat.notify;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.view.y;
import com.baidu.tieba.s;
/* loaded from: classes.dex */
public class p extends y {
    public p(Context context) {
        super(context);
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.ListView.i
    public View hA() {
        View hA = super.hA();
        this.uk.setVisibility(4);
        this.ul.setVisibility(4);
        this.um.setVisibility(4);
        return hA;
    }

    @Override // com.baidu.tbadk.core.view.y
    public void bM(int i) {
        super.bM(i);
        this.uj.setBackgroundColor(getContext().getResources().getColor(s.transparent));
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.ListView.i
    public void E(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.ListView.i
    public void hE() {
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.ListView.i
    public void hF() {
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.ListView.i
    public void F(boolean z) {
    }
}
