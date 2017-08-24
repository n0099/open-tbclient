package com.baidu.tbadk.i;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a implements b {
    private b aGa;

    public a(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GOD_RECOMMEND_CONTROLLER, b.class, tbPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.aGa = (b) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.i.b
    public void an(String str, String str2) {
        if (this.aGa != null) {
            this.aGa.an(str, str2);
        }
    }

    @Override // com.baidu.tbadk.i.b
    public void destory() {
        if (this.aGa != null) {
            this.aGa.destory();
        }
    }
}
