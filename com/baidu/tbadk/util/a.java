package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a cDz;
    private com.baidu.tbadk.coreExtra.data.a ckj;

    public static a awk() {
        if (cDz == null) {
            synchronized (a.class) {
                if (cDz == null) {
                    cDz = new a();
                }
            }
        }
        return cDz;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.ckj == null || aVar.amc() != this.ckj.amc()) ? true : true;
        this.ckj = aVar;
        if (z) {
            rl("zan_or_cai_smallflow");
        }
    }

    public boolean amc() {
        if (this.ckj == null) {
            this.ckj = new com.baidu.tbadk.coreExtra.data.a();
            this.ckj.amd();
        }
        return this.ckj.amc();
    }

    private void rl(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
