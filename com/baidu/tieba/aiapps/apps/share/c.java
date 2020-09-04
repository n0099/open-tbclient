package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes19.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c ftJ;
    private IWXAPI ftK;

    public static c bDk() {
        if (ftJ == null) {
            synchronized (c.class) {
                if (ftJ == null) {
                    ftJ = new c();
                }
            }
        }
        return ftJ;
    }

    private c() {
    }

    public void eG(Context context) {
        this.ftK = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.ftK.registerApp("wx7088ea0f777314d2");
    }
}
