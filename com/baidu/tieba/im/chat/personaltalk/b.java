package com.baidu.tieba.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class b {
    private HashMap<String, a> aSy = new HashMap<>();

    public void a(String str, a aVar) {
        this.aSy.put(str, aVar);
    }

    public boolean fE(String str) {
        a aVar;
        return (this.aSy == null || (aVar = this.aSy.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.KI()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.f fF(String str) {
        if (this.aSy.get(str) != null) {
            return this.aSy.get(str).KH();
        }
        return null;
    }
}
