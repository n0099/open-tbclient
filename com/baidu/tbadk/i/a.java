package com.baidu.tbadk.i;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a implements b {
    private b bcL;

    public a(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016469, b.class, tbPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.bcL = (b) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.i.b
    public void ip(String str) {
        if (this.bcL != null) {
            this.bcL.ip(str);
        }
    }

    @Override // com.baidu.tbadk.i.b
    public void destory() {
        if (this.bcL != null) {
            this.bcL.destory();
        }
    }
}
