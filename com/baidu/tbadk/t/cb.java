package com.baidu.tbadk.t;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class cb extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void C(int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_XIAOMI_PUSH_SWITCH_CHANGE));
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "switch_xiaomipush_sdk";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] fi() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fj() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fk() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fl() {
        return 10;
    }
}
