package com.baidu.tbadk.i;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a implements b {
    private b aPV;

    public a(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016469, b.class, tbPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.aPV = (b) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.i.b
    public void gX(String str) {
        if (this.aPV != null) {
            this.aPV.gX(str);
        }
    }

    @Override // com.baidu.tbadk.i.b
    public void destory() {
        if (this.aPV != null) {
            this.aPV.destory();
        }
    }
}
