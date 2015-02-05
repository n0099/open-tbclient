package com.baidu.tieba.im.chat.personaltalk;

import java.util.HashMap;
/* loaded from: classes.dex */
public class e {
    private HashMap<String, a> aVf = new HashMap<>();

    public void a(String str, a aVar) {
        this.aVf.put(str, aVar);
    }

    public boolean fV(String str) {
        a aVar;
        return (this.aVf == null || (aVar = this.aVf.get(str)) == null || Math.abs(System.currentTimeMillis() - aVar.Dg()) >= 300000) ? false : true;
    }

    public com.baidu.tbadk.coreExtra.relationship.f fW(String str) {
        if (this.aVf.get(str) != null) {
            return this.aVf.get(str).Lb();
        }
        return null;
    }
}
