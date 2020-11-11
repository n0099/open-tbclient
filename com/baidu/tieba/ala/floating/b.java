package com.baidu.tieba.ala.floating;

import android.content.Context;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.tieba.ala.floating.a;
/* loaded from: classes4.dex */
public class b {
    private static String TAG = "AlaFloatLiveControllerUtil";
    private static a gBH;

    public static a fa(Context context) {
        if (gBH == null) {
            gBH = fb(context);
        }
        return gBH;
    }

    private static synchronized a fb(Context context) {
        a aVar;
        synchronized (b.class) {
            if (gBH == null) {
                gBH = new a(context);
            }
            aVar = gBH;
        }
        return aVar;
    }

    public static AlaLiveInfoData bSm() {
        a aVar = gBH;
        if (aVar != null) {
            return aVar.bSm();
        }
        return null;
    }

    public static void b(a.InterfaceC0640a interfaceC0640a) {
        a aVar = gBH;
        if (aVar != null) {
            aVar.a(interfaceC0640a);
            aVar.bSr();
        }
    }

    public static boolean bSp() {
        a aVar = gBH;
        if (aVar != null) {
            return aVar.bSp();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void destroy() {
        synchronized (b.class) {
            a aVar = gBH;
            gBH = null;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}
