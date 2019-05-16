package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c dfV;
    private IWXAPI dfW;

    public static c aGb() {
        if (dfV == null) {
            synchronized (c.class) {
                if (dfV == null) {
                    dfV = new c();
                }
            }
        }
        return dfV;
    }

    private c() {
    }

    public void dx(Context context) {
        this.dfW = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.dfW.registerApp("wx7088ea0f777314d2");
    }
}
