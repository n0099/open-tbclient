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
    private static volatile d eyh;
    private ArrayList<Integer> eyc = new ArrayList<>();
    private c eyd;
    private a eyi;
    private List<an> eyj;

    public static d bfN() {
        if (eyh == null) {
            synchronized (c.class) {
                if (eyh == null) {
                    eyh = new d();
                }
            }
        }
        return eyh;
    }

    private d() {
        this.eyc.add(1);
        this.eyc.add(2);
        this.eyd = new c();
        this.eyi = new a(this.eyd, this.eyc);
        ow(com.baidu.tbadk.core.sharedPref.b.aNT().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int ar(String str, int i) {
        if (this.eyi == null) {
            return 0;
        }
        return this.eyi.ar(str, i);
    }

    public void ye(String str) {
        if (this.eyi != null) {
            this.eyi.yd(str);
        }
    }

    public void e(an anVar) {
        if (anVar != null) {
            if (this.eyj == null) {
                this.eyj = new ArrayList();
            }
            this.eyj.add(anVar);
        }
    }

    public void cF(String str, String str2) {
        if (!v.isEmpty(this.eyj) && this.eyd != null && this.eyd.bfL()) {
            int i = -1;
            for (an anVar : this.eyj) {
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
            this.eyj.clear();
        }
    }

    public void a(String str, String str2, an anVar) {
        if (anVar != null && this.eyd != null && this.eyd.bfL()) {
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
        if (aq.isEmpty(str) || this.eyd == null || !this.eyd.bfL()) {
            com.baidu.ubs.analytics.a.NA(str);
        }
    }

    public void onPageEnd(String str) {
        if (aq.isEmpty(str) || this.eyd == null || !this.eyd.bfL()) {
            com.baidu.ubs.analytics.a.NB(str);
        }
    }

    public void ow(int i) {
        if (this.eyd != null) {
            this.eyd.ow(i);
        }
    }
}
