package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes25.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c fJc;
    private IWXAPI fJd;

    public static c bHi() {
        if (fJc == null) {
            synchronized (c.class) {
                if (fJc == null) {
                    fJc = new c();
                }
            }
        }
        return fJc;
    }

    private c() {
    }

    public void eT(Context context) {
        this.fJd = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.fJd.registerApp("wx7088ea0f777314d2");
    }
}
