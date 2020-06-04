package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
/* loaded from: classes.dex */
public class a {
    private static a euH;
    private com.baidu.tbadk.coreExtra.data.a eeb;
    private ABTestExtraData eec;

    public static a bgi() {
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
        z = (aVar == null || this.eeb == null || aVar.aXF() != this.eeb.aXF()) ? true : true;
        this.eeb = aVar;
        if (z) {
            yN("zan_or_cai_smallflow");
        }
    }

    public boolean aXF() {
        if (this.eeb == null) {
            this.eeb = new com.baidu.tbadk.coreExtra.data.a();
            this.eeb.aXG();
        }
        return this.eeb.aXF();
    }

    private void yN(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156670, str));
    }

    public void a(ABTestExtraData aBTestExtraData) {
        this.eec = aBTestExtraData;
    }

    public String bgj() {
        if (this.eec == null) {
            this.eec = new ABTestExtraData();
            this.eec.parserABTestExtraFormSharedPref();
        }
        return this.eec.getABTestResult();
    }
}
