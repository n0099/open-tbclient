package com.baidu.tbadk.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a implements b {
    private b aCB;

    public a(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GOD_RECOMMEND_CONTROLLER, b.class, tbPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.aCB = (b) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.e.b
    public void an(String str, String str2) {
        if (this.aCB != null) {
            this.aCB.an(str, str2);
        }
    }

    @Override // com.baidu.tbadk.e.b
    public void destory() {
        if (this.aCB != null) {
            this.aCB.destory();
        }
    }
}
