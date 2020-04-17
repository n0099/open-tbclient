package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes12.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c eGu;
    private IWXAPI eGv;

    public static c bjq() {
        if (eGu == null) {
            synchronized (c.class) {
                if (eGu == null) {
                    eGu = new c();
                }
            }
        }
        return eGu;
    }

    private c() {
    }

    public void ep(Context context) {
        this.eGv = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.eGv.registerApp("wx7088ea0f777314d2");
    }
}
