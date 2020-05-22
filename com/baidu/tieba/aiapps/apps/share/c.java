package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes12.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c eTd;
    private IWXAPI eTe;

    public static c boF() {
        if (eTd == null) {
            synchronized (c.class) {
                if (eTd == null) {
                    eTd = new c();
                }
            }
        }
        return eTd;
    }

    private c() {
    }

    public void es(Context context) {
        this.eTe = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.eTe.registerApp("wx7088ea0f777314d2");
    }
}
