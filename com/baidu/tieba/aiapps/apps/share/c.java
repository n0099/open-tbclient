package com.baidu.tieba.aiapps.apps.share;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes12.dex */
public class c {
    public static final String TAG = c.class.getSimpleName();
    private static volatile c eTo;
    private IWXAPI eTp;

    public static c boH() {
        if (eTo == null) {
            synchronized (c.class) {
                if (eTo == null) {
                    eTo = new c();
                }
            }
        }
        return eTo;
    }

    private c() {
    }

    public void es(Context context) {
        this.eTp = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.eTp.registerApp("wx7088ea0f777314d2");
    }
}
