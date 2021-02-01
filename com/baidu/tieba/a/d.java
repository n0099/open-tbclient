package com.baidu.tieba.a;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static volatile d gfO;
    private ArrayList<Integer> gfK = new ArrayList<>();
    private c gfL;
    private a gfP;
    private List<ar> gfQ;

    public static d bKP() {
        if (gfO == null) {
            synchronized (c.class) {
                if (gfO == null) {
                    gfO = new d();
                }
            }
        }
        return gfO;
    }

    private d() {
        this.gfK.add(1);
        this.gfK.add(2);
        this.gfL = new c();
        this.gfP = new a(this.gfL, this.gfK);
        setChannel(com.baidu.tbadk.core.sharedPref.b.brQ().getInt(SharedPrefConfig.KEY_ABTEST_CHANNEL, 0));
    }

    public int aB(String str, int i) {
        if (this.gfP == null) {
            return 0;
        }
        return this.gfP.aB(str, i);
    }

    public void Ex(String str) {
        if (this.gfP != null) {
            this.gfP.Ew(str);
        }
    }

    public void e(ar arVar) {
        if (arVar != null) {
            if (this.gfQ == null) {
                this.gfQ = new ArrayList();
            }
            this.gfQ.add(arVar);
        }
    }

    public void dK(String str, String str2) {
        if (!y.isEmpty(this.gfQ) && this.gfL != null && this.gfL.bKN()) {
            int i = -1;
            for (ar arVar : this.gfQ) {
                if (arVar != null) {
                    if (arVar.getPosition() == 0) {
                        a(str, str2, arVar);
                    } else if (i != arVar.getPosition()) {
                        i = arVar.getPosition();
                        a(str, str2, arVar);
                    }
                    i = i;
                }
            }
            this.gfQ.clear();
        }
    }

    public void a(String str, String str2, ar arVar) {
        if (arVar != null && this.gfL != null && this.gfL.bKN()) {
            HashMap hashMap = new HashMap();
            List<Object> params = arVar.getParams();
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
            com.baidu.ubs.analytics.a.a(str2 + arVar.getKey(), str, "", hashMap);
        }
    }

    public void onPageStart(String str) {
        if (au.isEmpty(str) || this.gfL == null || !this.gfL.bKN()) {
            com.baidu.ubs.analytics.a.Xw(str);
        }
    }

    public void onPageEnd(String str) {
        if (au.isEmpty(str) || this.gfL == null || !this.gfL.bKN()) {
            com.baidu.ubs.analytics.a.Xx(str);
        }
    }

    public void setChannel(int i) {
        if (this.gfL != null) {
            this.gfL.setChannel(i);
        }
    }
}
