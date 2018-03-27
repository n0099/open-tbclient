package com.baidu.tbadk.h;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a implements b {
    private b bwh;

    public a(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016469, b.class, tbPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.bwh = (b) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.h.b
    public void gI(String str) {
        if (this.bwh != null) {
            this.bwh.gI(str);
        }
    }

    @Override // com.baidu.tbadk.h.b
    public void destory() {
        if (this.bwh != null) {
            this.bwh.destory();
        }
    }
}
