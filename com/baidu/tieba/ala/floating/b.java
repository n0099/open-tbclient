package com.baidu.tieba.ala.floating;

import android.content.Context;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.tieba.ala.floating.a;
/* loaded from: classes4.dex */
public class b {
    private static String TAG = "AlaFloatLiveControllerUtil";
    private static a gKn;

    public static a fG(Context context) {
        if (gKn == null) {
            gKn = fH(context);
        }
        return gKn;
    }

    private static synchronized a fH(Context context) {
        a aVar;
        synchronized (b.class) {
            if (gKn == null) {
                gKn = new a(context);
            }
            aVar = gKn;
        }
        return aVar;
    }

    public static AlaLiveInfoData bVq() {
        a aVar = gKn;
        if (aVar != null) {
            return aVar.bVq();
        }
        return null;
    }

    public static void b(a.InterfaceC0653a interfaceC0653a) {
        a aVar = gKn;
        if (aVar != null) {
            aVar.a(interfaceC0653a);
            aVar.bVv();
        }
    }

    public static boolean bVt() {
        a aVar = gKn;
        if (aVar != null) {
            return aVar.bVt();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void destroy() {
        synchronized (b.class) {
            a aVar = gKn;
            gKn = null;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}
