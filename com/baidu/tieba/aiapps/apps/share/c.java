package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes25.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c gff;
    private IWXAPI gfg;

    public static c bOB() {
        if (gff == null) {
            synchronized (c.class) {
                if (gff == null) {
                    gff = new c();
                }
            }
        }
        return gff;
    }

    private c() {
    }

    public void fz(Context context) {
        this.gfg = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.gfg.registerApp("wx7088ea0f777314d2");
    }
}
