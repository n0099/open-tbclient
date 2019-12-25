package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class d {
    private static volatile d dTo;
    private ArrayList<Integer> dTk = new ArrayList<>();
    private c dTl;
    private a dTp;
    private List<an> dTq;

    public static d aUV() {
        if (dTo == null) {
            synchronized (c.class) {
                if (dTo == null) {
                    dTo = new d();
                }
            }
        }
        return dTo;
    }

    private d() {
        this.dTk.add(1);
        this.dTk.add(2);
        this.dTl = new c();
        this.dTp = new a(this.dTl, this.dTk);
        nQ(com.baidu.tbadk.core.sharedPref.b.aCY().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int aj(String str, int i) {
        if (this.dTp == null) {
            return 0;
        }
        return this.dTp.aj(str, i);
    }

    public void wp(String str) {
        if (this.dTp != null) {
            this.dTp.wo(str);
        }
    }

    public void c(an anVar) {
        if (anVar != null) {
            if (this.dTq == null) {
                this.dTq = new ArrayList();
            }
            this.dTq.add(anVar);
        }
    }

    public void cm(String str, String str2) {
        if (!v.isEmpty(this.dTq) && this.dTl != null && this.dTl.aUT()) {
            int i = -1;
            for (an anVar : this.dTq) {
                if (anVar != null) {
                    if (anVar.getPosition() == 0) {
                        a(str, str2, anVar);
                    } else if (i != anVar.getPosition()) {
                        i = anVar.getPosition();
                        a(str, str2, anVar);
                    }
                    i = i;
                }
            }
            this.dTq.clear();
        }
    }

    public void a(String str, String str2, an anVar) {
        if (anVar != null && this.dTl != null && this.dTl.aUT()) {
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
        if (aq.isEmpty(str) || this.dTl == null || !this.dTl.aUT()) {
            com.baidu.ubs.analytics.a.KL(str);
        }
    }

    public void onPageEnd(String str) {
        if (aq.isEmpty(str) || this.dTl == null || !this.dTl.aUT()) {
            com.baidu.ubs.analytics.a.KM(str);
        }
    }

    public void nQ(int i) {
        if (this.dTl != null) {
            this.dTl.nQ(i);
        }
    }
}
