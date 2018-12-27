package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class a {
    private static a bio;
    private com.baidu.tbadk.coreExtra.data.a aQT;

    public static a PJ() {
        if (bio == null) {
            synchronized (a.class) {
                if (bio == null) {
                    bio = new a();
                }
            }
        }
        return bio;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.aQT == null || aVar.Gg() != this.aQT.Gg()) ? true : true;
        this.aQT = aVar;
        if (z) {
            iy("zan_or_cai_smallflow");
        }
    }

    public boolean Gg() {
        if (this.aQT == null) {
            this.aQT = new com.baidu.tbadk.coreExtra.data.a();
            this.aQT.Gh();
        }
        return this.aQT.Gg();
    }

    private void iy(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }
}
