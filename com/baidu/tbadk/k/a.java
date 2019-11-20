package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
public class a implements b {
    private b cIh;

    public a(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GOD_RECOMMEND_CONTROLLER, b.class, tbPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.cIh = (b) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.k.b
    public void pT(String str) {
        if (this.cIh != null) {
            this.cIh.pT(str);
        }
    }

    @Override // com.baidu.tbadk.k.b
    public void destory() {
        if (this.cIh != null) {
            this.cIh.destory();
        }
    }
}
