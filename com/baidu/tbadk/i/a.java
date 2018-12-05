package com.baidu.tbadk.i;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a implements b {
    private b bbY;

    public a(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016469, b.class, tbPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.bbY = (b) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.i.b
    public void hZ(String str) {
        if (this.bbY != null) {
            this.bbY.hZ(str);
        }
    }

    @Override // com.baidu.tbadk.i.b
    public void destory() {
        if (this.bbY != null) {
            this.bbY.destory();
        }
    }
}
