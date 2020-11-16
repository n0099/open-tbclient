package com.baidu.tieba.ala.floating;

import android.content.Context;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.tieba.ala.floating.a;
/* loaded from: classes4.dex */
public class b {
    private static String TAG = "AlaFloatLiveControllerUtil";
    private static a gBo;

    public static a fa(Context context) {
        if (gBo == null) {
            gBo = fb(context);
        }
        return gBo;
    }

    private static synchronized a fb(Context context) {
        a aVar;
        synchronized (b.class) {
            if (gBo == null) {
                gBo = new a(context);
            }
            aVar = gBo;
        }
        return aVar;
    }

    public static AlaLiveInfoData bRF() {
        a aVar = gBo;
        if (aVar != null) {
            return aVar.bRF();
        }
        return null;
    }

    public static void b(a.InterfaceC0640a interfaceC0640a) {
        a aVar = gBo;
        if (aVar != null) {
            aVar.a(interfaceC0640a);
            aVar.bRK();
        }
    }

    public static boolean bRI() {
        a aVar = gBo;
        if (aVar != null) {
            return aVar.bRI();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void destroy() {
        synchronized (b.class) {
            a aVar = gBo;
            gBo = null;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}
