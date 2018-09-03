package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    private HashMap<String, b> bmk = new HashMap<>();
    private ArrayList<Integer> bml;
    private c bmm;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.bml = arrayList;
        this.bmm = cVar;
    }

    public int G(String str, int i) {
        if (this.bmk == null || ap.isEmpty(str) || this.bml == null || !this.bml.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.bmk.containsKey(str)) {
            iz(str);
        }
        b bVar = this.bmk.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.gt(i);
    }

    public void iz(String str) {
        if (this.bmk != null && !ap.isEmpty(str) && this.bmm != null) {
            if (this.bmk.containsKey(str)) {
                b bVar = this.bmk.get(str);
                this.bmm.a(this.bml, bVar);
                this.bmk.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.bmm.a(this.bml, bVar2);
            this.bmk.put(str, bVar2);
        }
    }
}
