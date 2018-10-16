package com.baidu.tbadk.d;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.d.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static b aie = null;
    private static a aif = null;
    private static boolean aig = false;
    private static String aih = "";
    private static transient List<String> aii = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (aif == null) {
            synchronized (a.class) {
                if (aif == null) {
                    aif = new a();
                    aie = b.c(baseFragmentActivity);
                }
            }
        } else if (aie != null) {
            aie.setContext(baseFragmentActivity.getPageContext());
        }
        if (aig && aie != null) {
            aie.vp();
            aie.vq();
            aig = false;
        }
        return aif;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        vl();
        if (z) {
            vg();
        }
        if (z2) {
            vh();
        }
        az(z3);
        a(aVar);
    }

    public void vg() {
        vl();
        if (aie != null) {
            aie.vp();
            aig = false;
        }
    }

    public void vh() {
        vl();
        if (aie != null) {
            aie.vq();
            aig = false;
        }
    }

    public void az(boolean z) {
        vl();
        if (aie != null) {
            aie.az(z);
        }
    }

    public void a(b.a aVar) {
        vl();
        if (aie != null) {
            aie.c(aVar);
        }
    }

    public void b(b.a aVar) {
        vl();
        if (aie != null) {
            if (aie.vm()) {
                aie.c(aVar);
            }
            aie.vo();
        }
    }

    public void a(int i, b.a aVar) {
        vl();
        if (aie != null) {
            if (aie.vm()) {
                aie.c(aVar);
            }
            aie.bx(i);
        }
    }

    public void vi() {
        vl();
        if (aie != null) {
            aie.vi();
            aig = true;
        }
    }

    public void vj() {
        vl();
        if (aie != null) {
            aie.vj();
        }
    }

    public void vk() {
        vl();
        vj();
        vi();
    }

    private void vl() {
        if (aie == null) {
        }
    }

    public static void resetAll() {
        try {
            if (aie != null) {
                if (aif != null) {
                    aif.vk();
                }
                aie.vn();
                aie.vr();
                aie = null;
            }
            if (aif != null) {
                aif = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
