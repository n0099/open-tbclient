package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes12.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c ega;
    private IWXAPI egb;

    public static c bbg() {
        if (ega == null) {
            synchronized (c.class) {
                if (ega == null) {
                    ega = new c();
                }
            }
        }
        return ega;
    }

    private c() {
    }

    public void eE(Context context) {
        this.egb = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.egb.registerApp("wx7088ea0f777314d2");
    }
}
