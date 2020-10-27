package com.baidu.tieba.ala.floating;

import android.content.Context;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.tieba.ala.floating.a;
/* loaded from: classes4.dex */
public class b {
    private static String TAG = "AlaFloatLiveControllerUtil";
    private static a gvT;

    public static a fa(Context context) {
        if (gvT == null) {
            gvT = fb(context);
        }
        return gvT;
    }

    private static synchronized a fb(Context context) {
        a aVar;
        synchronized (b.class) {
            if (gvT == null) {
                gvT = new a(context);
            }
            aVar = gvT;
        }
        return aVar;
    }

    public static AlaLiveInfoData bPM() {
        a aVar = gvT;
        if (aVar != null) {
            return aVar.bPM();
        }
        return null;
    }

    public static void b(a.InterfaceC0628a interfaceC0628a) {
        a aVar = gvT;
        if (aVar != null) {
            aVar.a(interfaceC0628a);
            aVar.bPR();
        }
    }

    public static boolean bPP() {
        a aVar = gvT;
        if (aVar != null) {
            return aVar.bPP();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void destroy() {
        synchronized (b.class) {
            a aVar = gvT;
            gvT = null;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}
