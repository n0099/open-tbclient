package com.baidu.tieba.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> aTN = new HashMap<>();

    public void a(String str, a aVar) {
        this.aTN.put(str, aVar);
    }

    public boolean fT(String str) {
        a aVar;
        return (this.aTN == null || (aVar = this.aTN.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.CN()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.f fU(String str) {
        if (this.aTN.get(str) != null) {
            return this.aTN.get(str).KL();
        }
        return null;
    }
}
