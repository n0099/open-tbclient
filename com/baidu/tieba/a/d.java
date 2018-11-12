package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private static volatile d bwV;
    private ArrayList<Integer> bwR = new ArrayList<>();
    private c bwS;
    private a bwW;

    public static d UG() {
        if (bwV == null) {
            synchronized (c.class) {
                if (bwV == null) {
                    bwV = new d();
                }
            }
        }
        return bwV;
    }

    private d() {
        this.bwR.add(1);
        this.bwR.add(2);
        this.bwS = new c();
        this.bwW = new a(this.bwS, this.bwR);
        ht(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0));
    }

    public int M(String str, int i) {
        if (this.bwW == null) {
            return 0;
        }
        return this.bwW.M(str, i);
    }

    public void jr(String str) {
        if (this.bwW != null) {
            this.bwW.jq(str);
        }
    }

    public void a(String str, String str2, am amVar) {
        if (amVar != null && this.bwS != null && this.bwS.UE()) {
            HashMap hashMap = new HashMap();
            List<Object> params = amVar.getParams();
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
            com.baidu.ubs.analytics.a.a(str2 + amVar.getKey(), str, "", hashMap);
        }
    }

    public void onPageStart(String str) {
        if (ao.isEmpty(str) || this.bwS == null || !this.bwS.UE()) {
            com.baidu.ubs.analytics.a.xO(str);
        }
    }

    public void onPageEnd(String str) {
        if (ao.isEmpty(str) || this.bwS == null || !this.bwS.UE()) {
            com.baidu.ubs.analytics.a.xP(str);
        }
    }

    public void ht(int i) {
        if (this.bwS != null) {
            this.bwS.ht(i);
        }
    }
}
