package com.baidu.tbadk.mvc.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ NetModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NetModel netModel) {
        this.this$0 = netModel;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbPageContext tbPageContext;
        NetModel netModel = this.this$0;
        tbPageContext = this.this$0.mPageContext;
        netModel.w(-1, tbPageContext.getString(n.i.neterror));
    }
}
