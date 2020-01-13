package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes10.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c ebX;
    private IWXAPI ebY;

    public static c aYR() {
        if (ebX == null) {
            synchronized (c.class) {
                if (ebX == null) {
                    ebX = new c();
                }
            }
        }
        return ebX;
    }

    private c() {
    }

    public void eB(Context context) {
        this.ebY = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.ebY.registerApp("wx7088ea0f777314d2");
    }
}
