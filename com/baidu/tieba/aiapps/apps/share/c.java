package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes12.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c egE;
    private IWXAPI egF;

    public static c bbn() {
        if (egE == null) {
            synchronized (c.class) {
                if (egE == null) {
                    egE = new c();
                }
            }
        }
        return egE;
    }

    private c() {
    }

    public void eD(Context context) {
        this.egF = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.egF.registerApp("wx7088ea0f777314d2");
    }
}
