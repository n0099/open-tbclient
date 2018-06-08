package com.baidu.tbadk.h;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a implements b {
    private b aPc;

    public a(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016469, b.class, tbPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.aPc = (b) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.h.b
    public void gX(String str) {
        if (this.aPc != null) {
            this.aPc.gX(str);
        }
    }

    @Override // com.baidu.tbadk.h.b
    public void destory() {
        if (this.aPc != null) {
            this.aPc.destory();
        }
    }
}
