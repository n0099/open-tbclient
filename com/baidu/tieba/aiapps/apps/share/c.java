package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes12.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c egb;
    private IWXAPI egc;

    public static c bbi() {
        if (egb == null) {
            synchronized (c.class) {
                if (egb == null) {
                    egb = new c();
                }
            }
        }
        return egb;
    }

    private c() {
    }

    public void eE(Context context) {
        this.egc = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.egc.registerApp("wx7088ea0f777314d2");
    }
}
