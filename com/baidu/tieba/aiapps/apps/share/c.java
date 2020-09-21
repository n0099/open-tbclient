package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes24.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c fwT;
    private IWXAPI fwU;

    public static c bEw() {
        if (fwT == null) {
            synchronized (c.class) {
                if (fwT == null) {
                    fwT = new c();
                }
            }
        }
        return fwT;
    }

    private c() {
    }

    public void eM(Context context) {
        this.fwU = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.fwU.registerApp("wx7088ea0f777314d2");
    }
}
