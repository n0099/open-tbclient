package com.baidu.tbadk.mvc.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ NetModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(NetModel netModel) {
        this.this$0 = netModel;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbPageContext tbPageContext;
        NetModel netModel = this.this$0;
        tbPageContext = this.this$0.Mr;
        netModel.v(-1, tbPageContext.getString(i.C0057i.neterror));
    }
}
