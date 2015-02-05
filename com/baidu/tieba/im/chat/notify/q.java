package com.baidu.tieba.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ak;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class q extends ak {
    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public View jr() {
        View jr = super.jr();
        this.wv.setVisibility(4);
        return jr;
    }

    @Override // com.baidu.tbadk.core.view.ak
    public void cs(int i) {
        super.cs(i);
        this.wu.setBackgroundColor(getContext().getResources().getColor(t.transparent));
    }

    @Override // com.baidu.tbadk.core.view.ak, com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public void Q(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public void js() {
    }

    @Override // com.baidu.tbadk.core.view.ak, com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public void jt() {
    }

    @Override // com.baidu.tbadk.core.view.ak, com.baidu.adp.widget.ListView.e, com.baidu.adp.widget.ListView.j
    public void R(boolean z) {
    }
}
