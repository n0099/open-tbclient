package com.baidu.tbadk.o;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void cQ(int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_XIAOMI_PUSH_SWITCH_CHANGE));
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "switch_xiaomipush_sdk";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] mq() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int mr() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ms() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int mt() {
        return 10;
    }
}
