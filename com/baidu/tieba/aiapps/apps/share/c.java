package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes8.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c gjP;
    private IWXAPI gjQ;

    public static c bNd() {
        if (gjP == null) {
            synchronized (c.class) {
                if (gjP == null) {
                    gjP = new c();
                }
            }
        }
        return gjP;
    }

    private c() {
    }

    public void fR(Context context) {
        this.gjQ = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.gjQ.registerApp("wx7088ea0f777314d2");
    }
}
