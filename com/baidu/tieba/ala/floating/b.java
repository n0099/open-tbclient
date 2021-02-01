package com.baidu.tieba.ala.floating;

import android.content.Context;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.tieba.ala.floating.a;
/* loaded from: classes11.dex */
public class b {
    private static String TAG = "AlaFloatLiveControllerUtil";
    private static a gUd;

    public static a fW(Context context) {
        if (gUd == null) {
            gUd = fX(context);
        }
        return gUd;
    }

    private static synchronized a fX(Context context) {
        a aVar;
        synchronized (b.class) {
            if (gUd == null) {
                gUd = new a(context);
            }
            aVar = gUd;
        }
        return aVar;
    }

    public static AlaLiveInfoData bUJ() {
        a aVar = gUd;
        if (aVar != null) {
            return aVar.bUJ();
        }
        return null;
    }

    public static void b(a.InterfaceC0626a interfaceC0626a) {
        a aVar = gUd;
        if (aVar != null) {
            aVar.a(interfaceC0626a);
            aVar.bUO();
        }
    }

    public static boolean bUM() {
        a aVar = gUd;
        if (aVar != null) {
            return aVar.bUM();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void destroy() {
        synchronized (b.class) {
            a aVar = gUd;
            gUd = null;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}
