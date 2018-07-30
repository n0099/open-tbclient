package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {
    private HashMap<String, b> bmg = new HashMap<>();
    private ArrayList<Integer> bmh;
    private c bmi;

    public a(c cVar, ArrayList<Integer> arrayList) {
        this.bmh = arrayList;
        this.bmi = cVar;
    }

    public int G(String str, int i) {
        if (this.bmg == null || ap.isEmpty(str) || this.bmh == null || !this.bmh.contains(Integer.valueOf(i))) {
            return 0;
        }
        if (!this.bmg.containsKey(str)) {
            iy(str);
        }
        b bVar = this.bmg.get(str);
        if (bVar == null) {
            return 0;
        }
        return bVar.gu(i);
    }

    public void iy(String str) {
        if (this.bmg != null && !ap.isEmpty(str) && this.bmi != null) {
            if (this.bmg.containsKey(str)) {
                b bVar = this.bmg.get(str);
                this.bmi.a(this.bmh, bVar);
                this.bmg.put(str, bVar);
                return;
            }
            b bVar2 = new b();
            this.bmi.a(this.bmh, bVar2);
            this.bmg.put(str, bVar2);
        }
    }
}
