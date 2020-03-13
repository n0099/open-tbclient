package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes12.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c ego;
    private IWXAPI egp;

    public static c bbj() {
        if (ego == null) {
            synchronized (c.class) {
                if (ego == null) {
                    ego = new c();
                }
            }
        }
        return ego;
    }

    private c() {
    }

    public void eE(Context context) {
        this.egp = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.egp.registerApp("wx7088ea0f777314d2");
    }
}
