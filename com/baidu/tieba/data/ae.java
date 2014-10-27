package com.baidu.tieba.data;

import android.text.TextUtils;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.core.util.at {
    public ad alx;
    public ad aly;

    @Override // com.baidu.tbadk.core.util.at
    public ArrayList<com.baidu.tbadk.core.util.as> getImages() {
        com.baidu.tbadk.core.util.as eu;
        com.baidu.tbadk.core.util.as eu2;
        ArrayList<com.baidu.tbadk.core.util.as> arrayList = new ArrayList<>();
        if (this.alx != null && (eu2 = eu(this.alx.getAvatar())) != null) {
            arrayList.add(eu2);
        }
        if (this.aly != null && (eu = eu(this.aly.getAvatar())) != null) {
            arrayList.add(eu);
        }
        return arrayList;
    }

    private com.baidu.tbadk.core.util.as eu(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as();
        asVar.AI = str;
        asVar.ER = 10;
        return asVar;
    }
}
