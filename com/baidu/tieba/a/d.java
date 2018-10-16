package com.baidu.tieba.a;

import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class d {
    private static volatile d bwk;
    private ArrayList<Integer> bwg = new ArrayList<>();
    private c bwh;
    private a bwl;

    public static d Ux() {
        if (bwk == null) {
            synchronized (c.class) {
                if (bwk == null) {
                    bwk = new d();
                }
            }
        }
        return bwk;
    }

    private d() {
        this.bwg.add(1);
        this.bwg.add(2);
        this.bwh = new c();
        this.bwl = new a(this.bwh, this.bwg);
        hg(com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("key_abtest_channel", 0));
    }

    public int M(String str, int i) {
        if (this.bwl == null) {
            return 0;
        }
        return this.bwl.M(str, i);
    }

    public void jp(String str) {
        if (this.bwl != null) {
            this.bwl.jo(str);
        }
    }

    public void a(String str, String str2, am amVar) {
        if (amVar != null && this.bwh != null && this.bwh.Uv()) {
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
        if (ao.isEmpty(str) || this.bwh == null || !this.bwh.Uv()) {
            com.baidu.ubs.analytics.a.xJ(str);
        }
    }

    public void onPageEnd(String str) {
        if (ao.isEmpty(str) || this.bwh == null || !this.bwh.Uv()) {
            com.baidu.ubs.analytics.a.xK(str);
        }
    }

    public void hg(int i) {
        if (this.bwh != null) {
            this.bwh.hg(i);
        }
    }
}
