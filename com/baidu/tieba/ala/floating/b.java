package com.baidu.tieba.ala.floating;

import android.content.Context;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.tieba.ala.floating.a;
/* loaded from: classes4.dex */
public class b {
    private static String TAG = "AlaFloatLiveControllerUtil";
    private static a glO;

    public static a eZ(Context context) {
        if (glO == null) {
            glO = fa(context);
        }
        return glO;
    }

    private static synchronized a fa(Context context) {
        a aVar;
        synchronized (b.class) {
            if (glO == null) {
                glO = new a(context);
            }
            aVar = glO;
        }
        return aVar;
    }

    public static AlaLiveInfoData bNh() {
        a aVar = glO;
        if (aVar != null) {
            return aVar.bNh();
        }
        return null;
    }

    public static void b(a.InterfaceC0612a interfaceC0612a) {
        a aVar = glO;
        if (aVar != null) {
            aVar.a(interfaceC0612a);
            aVar.bNm();
        }
    }

    public static boolean bNk() {
        a aVar = glO;
        if (aVar != null) {
            return aVar.bNk();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void destroy() {
        synchronized (b.class) {
            a aVar = glO;
            glO = null;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}
