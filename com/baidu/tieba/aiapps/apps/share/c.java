package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes9.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c ebO;
    private IWXAPI ebP;

    public static c aYx() {
        if (ebO == null) {
            synchronized (c.class) {
                if (ebO == null) {
                    ebO = new c();
                }
            }
        }
        return ebO;
    }

    private c() {
    }

    public void eB(Context context) {
        this.ebP = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.ebP.registerApp("wx7088ea0f777314d2");
    }
}
