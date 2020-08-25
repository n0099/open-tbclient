package com.baidu.tieba.ala.floating;

import android.content.Context;
import com.baidu.tieba.ala.floating.a;
/* loaded from: classes7.dex */
public class b {
    private static String TAG = "AlaFloatLiveControllerUtil";
    private static a fWf;

    public static a eM(Context context) {
        if (fWf == null) {
            fWf = eN(context);
        }
        return fWf;
    }

    private static synchronized a eN(Context context) {
        a aVar;
        synchronized (b.class) {
            if (fWf == null) {
                fWf = new a(context);
            }
            aVar = fWf;
        }
        return aVar;
    }

    public static void b(a.InterfaceC0600a interfaceC0600a) {
        a aVar = fWf;
        if (aVar != null) {
            aVar.a(interfaceC0600a);
            aVar.bJr();
        }
    }

    public static boolean bJp() {
        a aVar = fWf;
        if (aVar != null) {
            return aVar.bJp();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void destroy() {
        synchronized (b.class) {
            a aVar = fWf;
            fWf = null;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}
