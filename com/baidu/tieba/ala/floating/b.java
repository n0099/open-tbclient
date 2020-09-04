package com.baidu.tieba.ala.floating;

import android.content.Context;
import com.baidu.tieba.ala.floating.a;
/* loaded from: classes7.dex */
public class b {
    private static String TAG = "AlaFloatLiveControllerUtil";
    private static a fWj;

    public static a eM(Context context) {
        if (fWj == null) {
            fWj = eN(context);
        }
        return fWj;
    }

    private static synchronized a eN(Context context) {
        a aVar;
        synchronized (b.class) {
            if (fWj == null) {
                fWj = new a(context);
            }
            aVar = fWj;
        }
        return aVar;
    }

    public static void b(a.InterfaceC0600a interfaceC0600a) {
        a aVar = fWj;
        if (aVar != null) {
            aVar.a(interfaceC0600a);
            aVar.bJs();
        }
    }

    public static boolean bJq() {
        a aVar = fWj;
        if (aVar != null) {
            return aVar.bJq();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void destroy() {
        synchronized (b.class) {
            a aVar = fWj;
            fWj = null;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}
