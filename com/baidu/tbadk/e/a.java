package com.baidu.tbadk.e;

import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.e.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private static b btv = null;
    private static a btw = null;
    private static boolean btx = false;
    private static String bty = "";
    private static transient List<String> btz = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (btw == null) {
            synchronized (a.class) {
                if (btw == null) {
                    btw = new a();
                    btv = b.c(baseFragmentActivity);
                }
            }
        } else if (btv != null) {
            btv.a(baseFragmentActivity.getPageContext());
        }
        if (btx && btv != null) {
            btv.Vo();
            btv.Vp();
            btx = false;
        }
        return btw;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        Vk();
        if (z) {
            Vf();
        }
        if (z2) {
            Vg();
        }
        da(z3);
        a(aVar);
    }

    public void Vf() {
        Vk();
        if (btv != null) {
            btv.Vo();
            btx = false;
        }
    }

    public void Vg() {
        Vk();
        if (btv != null) {
            btv.Vp();
            btx = false;
        }
    }

    public void da(boolean z) {
        Vk();
        if (btv != null) {
            btv.da(z);
        }
    }

    public void a(b.a aVar) {
        Vk();
        if (btv != null) {
            btv.c(aVar);
        }
    }

    public void b(b.a aVar) {
        Vk();
        if (btv != null) {
            if (btv.Vl()) {
                btv.c(aVar);
            }
            btv.Vn();
        }
    }

    public void a(int i, b.a aVar) {
        Vk();
        if (btv != null) {
            if (btv.Vl()) {
                btv.c(aVar);
            }
            btv.fC(i);
        }
    }

    public void Vh() {
        Vk();
        if (btv != null) {
            btv.Vh();
            btx = true;
        }
    }

    public void Vi() {
        Vk();
        if (btv != null) {
            btv.Vi();
        }
    }

    public void Vj() {
        Vk();
        Vi();
        Vh();
    }

    private void Vk() {
        if (btv == null) {
        }
    }

    public static void Hh() {
        try {
            if (btv != null) {
                if (btw != null) {
                    btw.Vj();
                }
                btv.Vm();
                btv.Vq();
                btv = null;
            }
            if (btw != null) {
                btw = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
