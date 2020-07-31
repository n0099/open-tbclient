package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes19.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c fih;
    private IWXAPI fii;

    public static c buo() {
        if (fih == null) {
            synchronized (c.class) {
                if (fih == null) {
                    fih = new c();
                }
            }
        }
        return fih;
    }

    private c() {
    }

    public void ey(Context context) {
        this.fii = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.fii.registerApp("wx7088ea0f777314d2");
    }
}
