package com.baidu.tbadk.n;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.b.a {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void X(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BAIDU_YUN_PUSH_SWITCH_CHANGE));
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_baiduyun_push";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] eP() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eQ() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eR() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eS() {
        return 10;
    }
}
