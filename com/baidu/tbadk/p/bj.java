package com.baidu.tbadk.p;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class bj extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001310));
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "switch_xiaomipush_sdk";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hl() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hm() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hn() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ho() {
        return 10;
    }
}
