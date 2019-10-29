package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c dsQ;
    private IWXAPI dsR;

    public static c aIq() {
        if (dsQ == null) {
            synchronized (c.class) {
                if (dsQ == null) {
                    dsQ = new c();
                }
            }
        }
        return dsQ;
    }

    private c() {
    }

    public void di(Context context) {
        this.dsR = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.dsR.registerApp("wx7088ea0f777314d2");
    }
}
