package com.baidu.tieba.data;

import android.text.TextUtils;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class af implements com.baidu.tbadk.core.util.av {
    public ae a;
    public ae b;

    @Override // com.baidu.tbadk.core.util.av
    public LinkedList<com.baidu.tbadk.core.util.au> getImages() {
        com.baidu.tbadk.core.util.au a;
        com.baidu.tbadk.core.util.au a2;
        LinkedList<com.baidu.tbadk.core.util.au> linkedList = new LinkedList<>();
        if (this.a != null && (a2 = a(this.a.c())) != null) {
            linkedList.add(a2);
        }
        if (this.b != null && (a = a(this.b.c())) != null) {
            linkedList.add(a);
        }
        return linkedList;
    }

    private com.baidu.tbadk.core.util.au a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au();
        auVar.a = str;
        auVar.d = 10;
        return auVar;
    }
}
