package com.baidu.tieba.ala.floating;

import android.content.Context;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.tieba.ala.floating.a;
/* loaded from: classes4.dex */
public class b {
    private static String TAG = "AlaFloatLiveControllerUtil";
    private static a gKl;

    public static a fG(Context context) {
        if (gKl == null) {
            gKl = fH(context);
        }
        return gKl;
    }

    private static synchronized a fH(Context context) {
        a aVar;
        synchronized (b.class) {
            if (gKl == null) {
                gKl = new a(context);
            }
            aVar = gKl;
        }
        return aVar;
    }

    public static AlaLiveInfoData bVp() {
        a aVar = gKl;
        if (aVar != null) {
            return aVar.bVp();
        }
        return null;
    }

    public static void b(a.InterfaceC0653a interfaceC0653a) {
        a aVar = gKl;
        if (aVar != null) {
            aVar.a(interfaceC0653a);
            aVar.bVu();
        }
    }

    public static boolean bVs() {
        a aVar = gKl;
        if (aVar != null) {
            return aVar.bVs();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void destroy() {
        synchronized (b.class) {
            a aVar = gKl;
            gKl = null;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}
