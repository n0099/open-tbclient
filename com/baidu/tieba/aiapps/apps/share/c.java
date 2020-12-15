package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes25.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c gfh;
    private IWXAPI gfi;

    public static c bOC() {
        if (gfh == null) {
            synchronized (c.class) {
                if (gfh == null) {
                    gfh = new c();
                }
            }
        }
        return gfh;
    }

    private c() {
    }

    public void fz(Context context) {
        this.gfi = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.gfi.registerApp("wx7088ea0f777314d2");
    }
}
