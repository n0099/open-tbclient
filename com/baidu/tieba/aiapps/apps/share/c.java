package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c dhE;
    private IWXAPI dhF;

    public static c aHA() {
        if (dhE == null) {
            synchronized (c.class) {
                if (dhE == null) {
                    dhE = new c();
                }
            }
        }
        return dhE;
    }

    private c() {
    }

    public void dy(Context context) {
        this.dhF = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.dhF.registerApp("wx7088ea0f777314d2");
    }
}
