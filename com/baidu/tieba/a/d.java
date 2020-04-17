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
    private static volatile d eyb;
    private ArrayList<Integer> exX = new ArrayList<>();
    private c exY;
    private a eyc;
    private List<an> eyd;

    public static d bfP() {
        if (eyb == null) {
            synchronized (c.class) {
                if (eyb == null) {
                    eyb = new d();
                }
            }
        }
        return eyb;
    }

    private d() {
        this.exX.add(1);
        this.exX.add(2);
        this.exY = new c();
        this.eyc = new a(this.exY, this.exX);
        ow(com.baidu.tbadk.core.sharedPref.b.aNV().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int ar(String str, int i) {
        if (this.eyc == null) {
            return 0;
        }
        return this.eyc.ar(str, i);
    }

    public void yb(String str) {
        if (this.eyc != null) {
            this.eyc.ya(str);
        }
    }

    public void e(an anVar) {
        if (anVar != null) {
            if (this.eyd == null) {
                this.eyd = new ArrayList();
            }
            this.eyd.add(anVar);
        }
    }

    public void cF(String str, String str2) {
        if (!v.isEmpty(this.eyd) && this.exY != null && this.exY.bfN()) {
            int i = -1;
            for (an anVar : this.eyd) {
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
            this.eyd.clear();
        }
    }

    public void a(String str, String str2, an anVar) {
        if (anVar != null && this.exY != null && this.exY.bfN()) {
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
        if (aq.isEmpty(str) || this.exY == null || !this.exY.bfN()) {
            com.baidu.ubs.analytics.a.Nx(str);
        }
    }

    public void onPageEnd(String str) {
        if (aq.isEmpty(str) || this.exY == null || !this.exY.bfN()) {
            com.baidu.ubs.analytics.a.Ny(str);
        }
    }

    public void ow(int i) {
        if (this.exY != null) {
            this.exY.ow(i);
        }
    }
}
