package com.baidu.tieba.ala.floating;

import android.content.Context;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.tieba.ala.floating.a;
/* loaded from: classes10.dex */
public class b {
    private static String TAG = "AlaFloatLiveControllerUtil";
    private static a gWa;

    public static a fV(Context context) {
        if (gWa == null) {
            gWa = fW(context);
        }
        return gWa;
    }

    private static synchronized a fW(Context context) {
        a aVar;
        synchronized (b.class) {
            if (gWa == null) {
                gWa = new a(context);
            }
            aVar = gWa;
        }
        return aVar;
    }

    public static AlaLiveInfoData bUW() {
        a aVar = gWa;
        if (aVar != null) {
            return aVar.bUW();
        }
        return null;
    }

    public static void b(a.InterfaceC0633a interfaceC0633a) {
        a aVar = gWa;
        if (aVar != null) {
            aVar.a(interfaceC0633a);
            aVar.bVb();
        }
    }

    public static boolean bUZ() {
        a aVar = gWa;
        if (aVar != null) {
            return aVar.bUZ();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void destroy() {
        synchronized (b.class) {
            a aVar = gWa;
            gWa = null;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}
