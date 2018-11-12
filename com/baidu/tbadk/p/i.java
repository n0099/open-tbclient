package com.baidu.tbadk.p;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void aq(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001439));
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_baiduyun_push";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] iG() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iH() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iI() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iJ() {
        return 10;
    }
}
