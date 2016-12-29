package com.baidu.tbadk.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a implements b {
    private b ayl;

    public a(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GOD_RECOMMEND_CONTROLLER, b.class, tbPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.ayl = (b) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.e.b
    public void aq(String str, String str2) {
        if (this.ayl != null) {
            this.ayl.aq(str, str2);
        }
    }

    @Override // com.baidu.tbadk.e.b
    public void destory() {
        if (this.ayl != null) {
            this.ayl.destory();
        }
    }
}
