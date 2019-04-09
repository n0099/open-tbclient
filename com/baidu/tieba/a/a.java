package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    private HashMap<String, b> ajc = new HashMap<>();
    private ArrayList<Integer> cMl;
    private c cMm;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.cMl = arrayList;
        this.cMm = cVar;
    }

    public int ak(String str, int i) {
        if (this.ajc == null || ap.isEmpty(str) || this.cMl == null || !this.cMl.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.ajc.containsKey(str)) {
            qK(str);
        }
        b bVar = this.ajc.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.ls(i);
    }

    public void qK(String str) {
        if (this.ajc != null && !ap.isEmpty(str) && this.cMm != null) {
            if (this.ajc.containsKey(str)) {
                b bVar = this.ajc.get(str);
                this.cMm.a(this.cMl, bVar);
                this.ajc.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.cMm.a(this.cMl, bVar2);
            this.ajc.put(str, bVar2);
        }
    }
}
