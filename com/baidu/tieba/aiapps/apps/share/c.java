package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes9.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c gmK;
    private IWXAPI gmL;

    public static c bNL() {
        if (gmK == null) {
            synchronized (c.class) {
                if (gmK == null) {
                    gmK = new c();
                }
            }
        }
        return gmK;
    }

    private c() {
    }

    public void fQ(Context context) {
        this.gmL = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.gmL.registerApp("wx7088ea0f777314d2");
    }
}
