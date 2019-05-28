package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    private HashMap<String, b> ajp = new HashMap<>();
    private ArrayList<Integer> cUx;
    private c cUy;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.cUx = arrayList;
        this.cUy = cVar;
    }

    public int ag(String str, int i) {
        if (this.ajp == null || ap.isEmpty(str) || this.cUx == null || !this.cUx.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.ajp.containsKey(str)) {
            rT(str);
        }
        b bVar = this.ajp.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.mh(i);
    }

    public void rT(String str) {
        if (this.ajp != null && !ap.isEmpty(str) && this.cUy != null) {
            if (this.ajp.containsKey(str)) {
                b bVar = this.ajp.get(str);
                this.cUy.a(this.cUx, bVar);
                this.ajp.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.cUy.a(this.cUx, bVar2);
            this.ajp.put(str, bVar2);
        }
    }
}
