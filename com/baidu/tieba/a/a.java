package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    private HashMap<String, b> ajb = new HashMap<>();
    private ArrayList<Integer> cMk;
    private c cMl;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.cMk = arrayList;
        this.cMl = cVar;
    }

    public int ak(String str, int i) {
        if (this.ajb == null || ap.isEmpty(str) || this.cMk == null || !this.cMk.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.ajb.containsKey(str)) {
            qK(str);
        }
        b bVar = this.ajb.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.ls(i);
    }

    public void qK(String str) {
        if (this.ajb != null && !ap.isEmpty(str) && this.cMl != null) {
            if (this.ajb.containsKey(str)) {
                b bVar = this.ajb.get(str);
                this.cMl.a(this.cMk, bVar);
                this.ajb.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.cMl.a(this.cMk, bVar2);
            this.ajb.put(str, bVar2);
        }
    }
}
