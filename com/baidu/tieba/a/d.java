package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class d {
    private static volatile d eMI;
    private ArrayList<Integer> eME = new ArrayList<>();
    private c eMF;
    private a eMJ;
    private List<an> eMK;

    public static d blZ() {
        if (eMI == null) {
            synchronized (c.class) {
                if (eMI == null) {
                    eMI = new d();
                }
            }
        }
        return eMI;
    }

    private d() {
        this.eME.add(1);
        this.eME.add(2);
        this.eMF = new c();
        this.eMJ = new a(this.eMF, this.eME);
        pd(com.baidu.tbadk.core.sharedPref.b.aTX().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int as(String str, int i) {
        if (this.eMJ == null) {
            return 0;
        }
        return this.eMJ.as(str, i);
    }

    public void zK(String str) {
        if (this.eMJ != null) {
            this.eMJ.zJ(str);
        }
    }

    public void e(an anVar) {
        if (anVar != null) {
            if (this.eMK == null) {
                this.eMK = new ArrayList();
            }
            this.eMK.add(anVar);
        }
    }

    public void de(String str, String str2) {
        if (!v.isEmpty(this.eMK) && this.eMF != null && this.eMF.blX()) {
            int i = -1;
            for (an anVar : this.eMK) {
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
            this.eMK.clear();
        }
    }

    public void a(String str, String str2, an anVar) {
        if (anVar != null && this.eMF != null && this.eMF.blX()) {
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
        if (aq.isEmpty(str) || this.eMF == null || !this.eMF.blX()) {
            com.baidu.ubs.analytics.a.Pn(str);
        }
    }

    public void onPageEnd(String str) {
        if (aq.isEmpty(str) || this.eMF == null || !this.eMF.blX()) {
            com.baidu.ubs.analytics.a.Po(str);
        }
    }

    public void pd(int i) {
        if (this.eMF != null) {
            this.eMF.pd(i);
        }
    }
}
