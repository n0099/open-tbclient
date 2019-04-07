package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a implements b {
    private b cmn;

    public a(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016469, b.class, tbPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.cmn = (b) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.k.b
    public void pc(String str) {
        if (this.cmn != null) {
            this.cmn.pc(str);
        }
    }

    @Override // com.baidu.tbadk.k.b
    public void destory() {
        if (this.cmn != null) {
            this.cmn.destory();
        }
    }
}
