package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a implements b {
    private b cwO;

    public a(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016469, b.class, tbPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.cwO = (b) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.k.b
    public void qL(String str) {
        if (this.cwO != null) {
            this.cwO.qL(str);
        }
    }

    @Override // com.baidu.tbadk.k.b
    public void destory() {
        if (this.cwO != null) {
            this.cwO.destory();
        }
    }
}
