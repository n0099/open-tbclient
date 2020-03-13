package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a dGr;
    private com.baidu.tbadk.coreExtra.data.a dpy;
    private ABTestExtraData dpz;

    public static a aRM() {
        if (dGr == null) {
            synchronized (a.class) {
                if (dGr == null) {
                    dGr = new a();
                }
            }
        }
        return dGr;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.dpy == null || aVar.aIZ() != this.dpy.aIZ()) ? true : true;
        this.dpy = aVar;
        if (z) {
            vP("zan_or_cai_smallflow");
        }
    }

    public boolean aIZ() {
        if (this.dpy == null) {
            this.dpy = new com.baidu.tbadk.coreExtra.data.a();
            this.dpy.aJa();
        }
        return this.dpy.aIZ();
    }

    private void vP(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.dpz = aBTestExtraData;
    }

    public String aRN() {
        if (this.dpz == null) {
            this.dpz = new ABTestExtraData();
            this.dpz.parserABTestExtraFormSharedPref();
        }
        return this.dpz.getABTestResult();
    }
}
