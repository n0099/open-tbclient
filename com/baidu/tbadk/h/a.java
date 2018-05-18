package com.baidu.tbadk.h;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a implements b {
    private b aGF;

    public a(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016469, b.class, tbPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.aGF = (b) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.h.b
    public void gz(String str) {
        if (this.aGF != null) {
            this.aGF.gz(str);
        }
    }

    @Override // com.baidu.tbadk.h.b
    public void destory() {
        if (this.aGF != null) {
            this.aGF.destory();
        }
    }
}
