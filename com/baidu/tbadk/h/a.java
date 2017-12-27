package com.baidu.tbadk.h;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a implements b {
    private b btO;

    public a(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GOD_RECOMMEND_CONTROLLER, b.class, tbPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.btO = (b) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.h.b
    public void gp(String str) {
        if (this.btO != null) {
            this.btO.gp(str);
        }
    }

    @Override // com.baidu.tbadk.h.b
    public void destory() {
        if (this.btO != null) {
            this.btO.destory();
        }
    }
}
