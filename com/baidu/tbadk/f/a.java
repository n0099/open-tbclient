package com.baidu.tbadk.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a implements b {
    private b ayt;

    public a(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GOD_RECOMMEND_CONTROLLER, b.class, tbPageContext);
        if (runTask != null && runTask.getData() != null) {
            this.ayt = (b) runTask.getData();
        }
    }

    @Override // com.baidu.tbadk.f.b
    public void ap(String str, String str2) {
        if (this.ayt != null) {
            this.ayt.ap(str, str2);
        }
    }

    @Override // com.baidu.tbadk.f.b
    public void destory() {
        if (this.ayt != null) {
            this.ayt.destory();
        }
    }
}
