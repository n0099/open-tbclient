package com.baidu.tieba.ala.floating;

import android.content.Context;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.tieba.ala.floating.a;
/* loaded from: classes11.dex */
public class b {
    private static String TAG = "AlaFloatLiveControllerUtil";
    private static a gUr;

    public static a fW(Context context) {
        if (gUr == null) {
            gUr = fX(context);
        }
        return gUr;
    }

    private static synchronized a fX(Context context) {
        a aVar;
        synchronized (b.class) {
            if (gUr == null) {
                gUr = new a(context);
            }
            aVar = gUr;
        }
        return aVar;
    }

    public static AlaLiveInfoData bUQ() {
        a aVar = gUr;
        if (aVar != null) {
            return aVar.bUQ();
        }
        return null;
    }

    public static void b(a.InterfaceC0627a interfaceC0627a) {
        a aVar = gUr;
        if (aVar != null) {
            aVar.a(interfaceC0627a);
            aVar.bUV();
        }
    }

    public static boolean bUT() {
        a aVar = gUr;
        if (aVar != null) {
            return aVar.bUT();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void destroy() {
        synchronized (b.class) {
            a aVar = gUr;
            gUr = null;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}
