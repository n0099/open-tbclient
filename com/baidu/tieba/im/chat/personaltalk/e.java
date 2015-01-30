package com.baidu.tieba.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> aVg = new HashMap<>();

    public void a(String str, a aVar) {
        this.aVg.put(str, aVar);
    }

    public boolean fY(String str) {
        a aVar;
        return (this.aVg == null || (aVar = this.aVg.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.Dm()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.f fZ(String str) {
        if (this.aVg.get(str) != null) {
            return this.aVg.get(str).Lg();
        }
        return null;
    }
}
