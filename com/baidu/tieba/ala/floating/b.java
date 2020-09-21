package com.baidu.tieba.ala.floating;

import android.content.Context;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.tieba.ala.floating.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private static String TAG = "AlaFloatLiveControllerUtil";
    private static a fZw;

    public static a eS(Context context) {
        if (fZw == null) {
            fZw = eT(context);
        }
        return fZw;
    }

    private static synchronized a eT(Context context) {
        a aVar;
        synchronized (b.class) {
            if (fZw == null) {
                fZw = new a(context);
            }
            aVar = fZw;
        }
        return aVar;
    }

    public static AlaLiveInfoData bKx() {
        a aVar = fZw;
        if (aVar != null) {
            return aVar.bKx();
        }
        return null;
    }

    public static void b(a.InterfaceC0595a interfaceC0595a) {
        a aVar = fZw;
        if (aVar != null) {
            aVar.a(interfaceC0595a);
            aVar.bKC();
        }
    }

    public static boolean bKA() {
        a aVar = fZw;
        if (aVar != null) {
            return aVar.bKA();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void dp(JSONObject jSONObject) {
        synchronized (b.class) {
            a aVar = fZw;
            if (aVar != null) {
                aVar.m40do(jSONObject);
            }
        }
    }
}
