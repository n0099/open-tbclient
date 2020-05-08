package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes12.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c eGz;
    private IWXAPI eGA;

    public static c bjo() {
        if (eGz == null) {
            synchronized (c.class) {
                if (eGz == null) {
                    eGz = new c();
                }
            }
        }
        return eGz;
    }

    private c() {
    }

    public void ed(Context context) {
        this.eGA = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.eGA.registerApp("wx7088ea0f777314d2");
    }
}
