package com.baidu.tbadk.i;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a implements b {
    private b aFn;

    public a(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GOD_RECOMMEND_CONTROLLER, b.class, tbPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.aFn = (b) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.i.b
    public void gg(String str) {
        if (this.aFn != null) {
            this.aFn.gg(str);
        }
    }

    @Override // com.baidu.tbadk.i.b
    public void destory() {
        if (this.aFn != null) {
            this.aFn.destory();
        }
    }
}
