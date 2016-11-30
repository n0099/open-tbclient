package com.baidu.tbadk.mvc.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.r;
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
        tbPageContext = this.this$0.GO;
        netModel.n(-1, tbPageContext.getString(r.j.neterror));
    }
}
