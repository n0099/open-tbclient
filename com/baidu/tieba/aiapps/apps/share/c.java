package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c dhL;
    private IWXAPI dhM;

    public static c aHC() {
        if (dhL == null) {
            synchronized (c.class) {
                if (dhL == null) {
                    dhL = new c();
                }
            }
        }
        return dhL;
    }

    private c() {
    }

    public void dy(Context context) {
        this.dhM = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.dhM.registerApp("wx7088ea0f777314d2");
    }
}
