package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes25.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c fRx;
    private IWXAPI fRy;

    public static c bJb() {
        if (fRx == null) {
            synchronized (c.class) {
                if (fRx == null) {
                    fRx = new c();
                }
            }
        }
        return fRx;
    }

    private c() {
    }

    public void eT(Context context) {
        this.fRy = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.fRy.registerApp("wx7088ea0f777314d2");
    }
}
