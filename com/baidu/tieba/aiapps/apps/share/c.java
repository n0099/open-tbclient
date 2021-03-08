package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes8.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c got;
    private IWXAPI gou;

    public static c bNR() {
        if (got == null) {
            synchronized (c.class) {
                if (got == null) {
                    got = new c();
                }
            }
        }
        return got;
    }

    private c() {
    }

    public void fP(Context context) {
        this.gou = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.gou.registerApp("wx7088ea0f777314d2");
    }
}
