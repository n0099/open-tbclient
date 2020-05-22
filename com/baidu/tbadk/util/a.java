package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a euH;
    private com.baidu.tbadk.coreExtra.data.a eeb;
    private ABTestExtraData eec;

    public static a bgh() {
        if (euH == null) {
            synchronized (a.class) {
                if (euH == null) {
                    euH = new a();
                }
            }
        }
        return euH;
    }

    public void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        b(aVar);
    }

    private void b(com.baidu.tbadk.coreExtra.data.a aVar) {
        boolean z = false;
        z = (aVar == null || this.eeb == null || aVar.aXE() != this.eeb.aXE()) ? true : true;
        this.eeb = aVar;
        if (z) {
            yN("zan_or_cai_smallflow");
        }
    }

    public boolean aXE() {
        if (this.eeb == null) {
            this.eeb = new com.baidu.tbadk.coreExtra.data.a();
            this.eeb.aXF();
        }
        return this.eeb.aXE();
    }

    private void yN(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.eec = aBTestExtraData;
    }

    public String bgi() {
        if (this.eec == null) {
            this.eec = new ABTestExtraData();
            this.eec.parserABTestExtraFormSharedPref();
        }
        return this.eec.getABTestResult();
    }
}
