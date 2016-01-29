package com.baidu.tbadk.mvc.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ NetModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NetModel netModel) {
        this.this$0 = netModel;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbPageContext tbPageContext;
        NetModel netModel = this.this$0;
        tbPageContext = this.this$0.Nw;
        netModel.w(-1, tbPageContext.getString(t.j.neterror));
    }
}
