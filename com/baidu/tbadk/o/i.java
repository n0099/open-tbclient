package com.baidu.tbadk.o;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.lib.b.a {
    @Override // com.baidu.adp.lib.b.a
    protected void cQ(int i) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001439));
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "android_baiduyun_push";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] mr() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ms() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int mt() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int mu() {
        return 10;
    }
}
