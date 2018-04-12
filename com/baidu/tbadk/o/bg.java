package com.baidu.tbadk.o;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class bg extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void Q(int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001310));
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "switch_xiaomipush_sdk";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] ev() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ew() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ex() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ey() {
        return 10;
    }
}
