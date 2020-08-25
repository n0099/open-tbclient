package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes19.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c ftF;
    private IWXAPI ftG;

    public static c bDj() {
        if (ftF == null) {
            synchronized (c.class) {
                if (ftF == null) {
                    ftF = new c();
                }
            }
        }
        return ftF;
    }

    private c() {
    }

    public void eG(Context context) {
        this.ftG = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.ftG.registerApp("wx7088ea0f777314d2");
    }
}
