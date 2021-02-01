package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes9.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c gmw;
    private IWXAPI gmx;

    public static c bNE() {
        if (gmw == null) {
            synchronized (c.class) {
                if (gmw == null) {
                    gmw = new c();
                }
            }
        }
        return gmw;
    }

    private c() {
    }

    public void fQ(Context context) {
        this.gmx = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.gmx.registerApp("wx7088ea0f777314d2");
    }
}
