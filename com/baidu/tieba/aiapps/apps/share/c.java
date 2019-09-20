package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c djw;
    private IWXAPI djx;

    public static c aIg() {
        if (djw == null) {
            synchronized (c.class) {
                if (djw == null) {
                    djw = new c();
                }
            }
        }
        return djw;
    }

    private c() {
    }

    public void dz(Context context) {
        this.djx = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.djx.registerApp("wx7088ea0f777314d2");
    }
}
