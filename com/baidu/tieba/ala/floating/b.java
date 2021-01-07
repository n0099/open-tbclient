package com.baidu.tieba.ala.floating;

import android.content.Context;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.tieba.ala.floating.a;
/* loaded from: classes11.dex */
public class b {
    private static String TAG = "AlaFloatLiveControllerUtil";
    private static a gVZ;

    public static a fZ(Context context) {
        if (gVZ == null) {
            gVZ = ga(context);
        }
        return gVZ;
    }

    private static synchronized a ga(Context context) {
        a aVar;
        synchronized (b.class) {
            if (gVZ == null) {
                gVZ = new a(context);
            }
            aVar = gVZ;
        }
        return aVar;
    }

    public static AlaLiveInfoData bXW() {
        a aVar = gVZ;
        if (aVar != null) {
            return aVar.bXW();
        }
        return null;
    }

    public static void b(a.InterfaceC0644a interfaceC0644a) {
        a aVar = gVZ;
        if (aVar != null) {
            aVar.a(interfaceC0644a);
            aVar.bYb();
        }
    }

    public static boolean bXZ() {
        a aVar = gVZ;
        if (aVar != null) {
            return aVar.bXZ();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void destroy() {
        synchronized (b.class) {
            a aVar = gVZ;
            gVZ = null;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}
