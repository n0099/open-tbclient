package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c dfW;
    private IWXAPI dfX;

    public static c aGe() {
        if (dfW == null) {
            synchronized (c.class) {
                if (dfW == null) {
                    dfW = new c();
                }
            }
        }
        return dfW;
    }

    private c() {
    }

    public void dx(Context context) {
        this.dfX = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.dfX.registerApp("wx7088ea0f777314d2");
    }
}
