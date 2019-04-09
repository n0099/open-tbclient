package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private static b btz = null;
    private static a btA = null;
    private static boolean btB = false;
    private static String btC = "";
    private static transient List<String> btD = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (btA == null) {
            synchronized (a.class) {
                if (btA == null) {
                    btA = new a();
                    btz = b.c(baseFragmentActivity);
                }
            }
        } else if (btz != null) {
            btz.a(baseFragmentActivity.getPageContext());
        }
        if (btB && btz != null) {
            btz.Vl();
            btz.Vm();
            btB = false;
        }
        return btA;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        Vh();
        if (z) {
            Vc();
        }
        if (z2) {
            Vd();
        }
        da(z3);
        a(aVar);
    }

    public void Vc() {
        Vh();
        if (btz != null) {
            btz.Vl();
            btB = false;
        }
    }

    public void Vd() {
        Vh();
        if (btz != null) {
            btz.Vm();
            btB = false;
        }
    }

    public void da(boolean z) {
        Vh();
        if (btz != null) {
            btz.da(z);
        }
    }

    public void a(b.a aVar) {
        Vh();
        if (btz != null) {
            btz.c(aVar);
        }
    }

    public void b(b.a aVar) {
        Vh();
        if (btz != null) {
            if (btz.Vi()) {
                btz.c(aVar);
            }
            btz.Vk();
        }
    }

    public void a(int i, b.a aVar) {
        Vh();
        if (btz != null) {
            if (btz.Vi()) {
                btz.c(aVar);
            }
            btz.fB(i);
        }
    }

    public void Ve() {
        Vh();
        if (btz != null) {
            btz.Ve();
            btB = true;
        }
    }

    public void Vf() {
        Vh();
        if (btz != null) {
            btz.Vf();
        }
    }

    public void Vg() {
        Vh();
        Vf();
        Ve();
    }

    private void Vh() {
        if (btz == null) {
        }
    }

    public static void Hf() {
        try {
            if (btz != null) {
                if (btA != null) {
                    btA.Vg();
                }
                btz.Vj();
                btz.Vn();
                btz = null;
            }
            if (btA != null) {
                btA = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
