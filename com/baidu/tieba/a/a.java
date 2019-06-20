package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    private HashMap<String, b> ajp = new HashMap<>();
    private ArrayList<Integer> cUy;
    private c cUz;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.cUy = arrayList;
        this.cUz = cVar;
    }

    public int ag(String str, int i) {
        if (this.ajp == null || ap.isEmpty(str) || this.cUy == null || !this.cUy.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.ajp.containsKey(str)) {
            rS(str);
        }
        b bVar = this.ajp.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.mh(i);
    }

    public void rS(String str) {
        if (this.ajp != null && !ap.isEmpty(str) && this.cUz != null) {
            if (this.ajp.containsKey(str)) {
                b bVar = this.ajp.get(str);
                this.cUz.a(this.cUy, bVar);
                this.ajp.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.cUz.a(this.cUy, bVar2);
            this.ajp.put(str, bVar2);
        }
    }
}
