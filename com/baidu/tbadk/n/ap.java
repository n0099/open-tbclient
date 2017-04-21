package com.baidu.tbadk.n;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.lib.b.a {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void X(int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_XIAOMI_PUSH_SWITCH_CHANGE));
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "switch_xiaomipush_sdk";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] eQ() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eR() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eS() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eT() {
        return 10;
    }
}
