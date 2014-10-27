package com.baidu.tieba.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private HashMap<String, a> aSk = new HashMap<>();

    public void a(String str, a aVar) {
        this.aSk.put(str, aVar);
    }

    public boolean fE(String str) {
        a aVar;
        return (this.aSk == null || (aVar = this.aSk.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.KE()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.f fF(String str) {
        if (this.aSk.get(str) != null) {
            return this.aSk.get(str).KD();
        }
        return null;
    }
}
