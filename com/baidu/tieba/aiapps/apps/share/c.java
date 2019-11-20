package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c drY;
    private IWXAPI drZ;

    public static c aIo() {
        if (drY == null) {
            synchronized (c.class) {
                if (drY == null) {
                    drY = new c();
                }
            }
        }
        return drY;
    }

    private c() {
    }

    public void di(Context context) {
        this.drZ = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.drZ.registerApp("wx7088ea0f777314d2");
    }
}
