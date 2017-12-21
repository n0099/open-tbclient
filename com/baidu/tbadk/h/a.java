package com.baidu.tbadk.h;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a implements b {
    private b aFV;

    public a(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GOD_RECOMMEND_CONTROLLER, b.class, tbPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.aFV = (b) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.h.b
    public void gi(String str) {
        if (this.aFV != null) {
            this.aFV.gi(str);
        }
    }

    @Override // com.baidu.tbadk.h.b
    public void destory() {
        if (this.aFV != null) {
            this.aFV.destory();
        }
    }
}
