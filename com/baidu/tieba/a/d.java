package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes15.dex */
public class d {
    private static volatile d fne;
    private ArrayList<Integer> fna = new ArrayList<>();
    private c fnb;
    private a fnf;
    private List<aq> fng;

    public static d bAB() {
        if (fne == null) {
            synchronized (c.class) {
                if (fne == null) {
                    fne = new d();
                }
            }
        }
        return fne;
    }

    private d() {
        this.fna.add(1);
        this.fna.add(2);
        this.fnb = new c();
        this.fnf = new a(this.fnb, this.fna);
        sd(com.baidu.tbadk.core.sharedPref.b.bik().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int au(String str, int i) {
        if (this.fnf == null) {
            return 0;
        }
        return this.fnf.au(str, i);
    }

    public void Dj(String str) {
        if (this.fnf != null) {
            this.fnf.Di(str);
        }
    }

    public void e(aq aqVar) {
        if (aqVar != null) {
            if (this.fng == null) {
                this.fng = new ArrayList();
            }
            this.fng.add(aqVar);
        }
    }

    public void dA(String str, String str2) {
        if (!y.isEmpty(this.fng) && this.fnb != null && this.fnb.bAz()) {
            int i = -1;
            for (aq aqVar : this.fng) {
                if (aqVar != null) {
                    if (aqVar.getPosition() == 0) {
                        a(str, str2, aqVar);
                    } else if (i != aqVar.getPosition()) {
                        i = aqVar.getPosition();
                        a(str, str2, aqVar);
                    }
                    i = i;
                }
            }
            this.fng.clear();
        }
    }

    public void a(String str, String str2, aq aqVar) {
        if (aqVar != null && this.fnb != null && this.fnb.bAz()) {
            HashMap hashMap = new HashMap();
            List<Object> params = aqVar.getParams();
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
            com.baidu.ubs.analytics.a.a(str2 + aqVar.getKey(), str, "", hashMap);
        }
    }

    public void onPageStart(String str) {
        if (at.isEmpty(str) || this.fnb == null || !this.fnb.bAz()) {
            com.baidu.ubs.analytics.a.TL(str);
        }
    }

    public void onPageEnd(String str) {
        if (at.isEmpty(str) || this.fnb == null || !this.fnb.bAz()) {
            com.baidu.ubs.analytics.a.TM(str);
        }
    }

    public void sd(int i) {
        if (this.fnb != null) {
            this.fnb.sd(i);
        }
    }
}
