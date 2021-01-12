package com.baidu.tieba.ala.floating;

import android.content.Context;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.tieba.ala.floating.a;
/* loaded from: classes10.dex */
public class b {
    private static String TAG = "AlaFloatLiveControllerUtil";
    private static a gRt;

    public static a fX(Context context) {
        if (gRt == null) {
            gRt = fY(context);
        }
        return gRt;
    }

    private static synchronized a fY(Context context) {
        a aVar;
        synchronized (b.class) {
            if (gRt == null) {
                gRt = new a(context);
            }
            aVar = gRt;
        }
        return aVar;
    }

    public static AlaLiveInfoData bUe() {
        a aVar = gRt;
        if (aVar != null) {
            return aVar.bUe();
        }
        return null;
    }

    public static void b(a.InterfaceC0627a interfaceC0627a) {
        a aVar = gRt;
        if (aVar != null) {
            aVar.a(interfaceC0627a);
            aVar.bUj();
        }
    }

    public static boolean bUh() {
        a aVar = gRt;
        if (aVar != null) {
            return aVar.bUh();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void destroy() {
        synchronized (b.class) {
            a aVar = gRt;
            gRt = null;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }
}
