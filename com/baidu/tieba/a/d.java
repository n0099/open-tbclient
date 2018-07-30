package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    private static volatile d bml;
    private ArrayList<Integer> bmh = new ArrayList<>();
    private c bmi;
    private a bmm;

    public static d QI() {
        if (bml == null) {
            synchronized (c.class) {
                if (bml == null) {
                    bml = new d();
                }
            }
        }
        return bml;
    }

    private d() {
        this.bmh.add(1);
        this.bmh.add(2);
        this.bmi = new c();
        this.bmm = new a(this.bmi, this.bmh);
        gz(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0));
    }

    public int G(String str, int i) {
        if (this.bmm == null) {
            return 0;
        }
        return this.bmm.G(str, i);
    }

    public void iz(String str) {
        if (this.bmm != null) {
            this.bmm.iy(str);
        }
    }

    public void a(String str, String str2, an anVar) {
        if (anVar != null && this.bmi != null && this.bmi.QG()) {
            HashMap hashMap = new HashMap();
            List<Object> params = anVar.getParams();
            if (params != null) {
                int size = params.size();
                for (int i = 0; i < size; i += 2) {
                    String str3 = "";
                    Object obj = params.get(i);
                    if (obj != null) {
                        str3 = obj.toString();
                    }
                    String str4 = "";
                    Object obj2 = params.get(i + 1);
                    if (obj2 != null) {
                        str4 = obj2.toString();
                    }
                    hashMap.put(str3, str4);
                }
            }
            com.baidu.ubs.analytics.a.a(str2 + anVar.getKey(), str, "", hashMap);
        }
    }

    public void onPageStart(String str) {
        if (ap.isEmpty(str) || this.bmi == null || !this.bmi.QG()) {
            com.baidu.ubs.analytics.a.vU(str);
        }
    }

    public void onPageEnd(String str) {
        if (ap.isEmpty(str) || this.bmi == null || !this.bmi.QG()) {
            com.baidu.ubs.analytics.a.vV(str);
        }
    }

    public void gz(int i) {
        if (this.bmi != null) {
            this.bmi.gz(i);
        }
    }
}
