package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes9.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c gow;
    private IWXAPI gox;

    public static c bQU() {
        if (gow == null) {
            synchronized (c.class) {
                if (gow == null) {
                    gow = new c();
                }
            }
        }
        return gow;
    }

    private c() {
    }

    public void fT(Context context) {
        this.gox = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.gox.registerApp("wx7088ea0f777314d2");
    }
}
