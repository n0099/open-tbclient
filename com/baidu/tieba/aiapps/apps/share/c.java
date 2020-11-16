package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes24.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c fWU;
    private IWXAPI fWV;

    public static c bKT() {
        if (fWU == null) {
            synchronized (c.class) {
                if (fWU == null) {
                    fWU = new c();
                }
            }
        }
        return fWU;
    }

    private c() {
    }

    public void eT(Context context) {
        this.fWV = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.fWV.registerApp("wx7088ea0f777314d2");
    }
}
