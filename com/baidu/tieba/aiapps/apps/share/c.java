package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes12.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c fdz;
    private IWXAPI fdA;

    public static c bri() {
        if (fdz == null) {
            synchronized (c.class) {
                if (fdz == null) {
                    fdz = new c();
                }
            }
        }
        return fdz;
    }

    private c() {
    }

    public void et(Context context) {
        this.fdA = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.fdA.registerApp("wx7088ea0f777314d2");
    }
}
