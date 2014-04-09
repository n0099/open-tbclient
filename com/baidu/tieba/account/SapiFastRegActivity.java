package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.plugins.BdSapiCoreLightDelegate;
/* loaded from: classes.dex */
public class SapiFastRegActivity extends com.baidu.tbadk.a {
    private static boolean f;
    com.baidu.tbadk.coreExtra.view.p a = null;
    private String b = null;
    private BdSapiCoreLightDelegate c = null;
    private final Handler d = new Handler();
    private final com.baidu.tbadk.core.a.u e = new ai(this);

    static {
        TbadkApplication.j().a(com.baidu.tbadk.core.b.al.class, SapiFastRegActivity.class);
        f = false;
    }

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, SapiFastRegActivity.class), 22002);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.baidu.tbplugin.k.a() == null) {
            Register2Activity.a(this, 12007);
            finish();
            return;
        }
        this.c = (BdSapiCoreLightDelegate) com.baidu.tbplugin.k.a().a(BdSapiCoreLightDelegate.class);
        if (this.c == null) {
            Register2Activity.a(this, 12007);
            finish();
            return;
        }
        if (!f) {
            a((Context) this);
        }
        try {
            setContentView(com.baidu.tieba.a.i.pass_spi_webview_fastreg);
            this.c.setCallback(new ak(this));
            this.c.setupViews(findViewById(com.baidu.tieba.a.h.sapi_webview));
        } catch (Exception e) {
            Register2Activity.a(this, 12007);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(SapiFastRegActivity sapiFastRegActivity, AccountData accountData) {
        if (sapiFastRegActivity.a == null) {
            sapiFastRegActivity.a = new com.baidu.tbadk.coreExtra.view.p(sapiFastRegActivity);
            sapiFastRegActivity.a.a(new am(sapiFastRegActivity));
        }
        sapiFastRegActivity.a.e();
        sapiFastRegActivity.a.a(accountData);
        sapiFastRegActivity.a.a();
    }

    public static synchronized void a(Context context) {
        synchronized (SapiFastRegActivity.class) {
            if (!f) {
                try {
                    BdSapiCoreLightDelegate bdSapiCoreLightDelegate = (BdSapiCoreLightDelegate) com.baidu.tbplugin.k.a().a(BdSapiCoreLightDelegate.class);
                    if (bdSapiCoreLightDelegate != null) {
                        bdSapiCoreLightDelegate.initSapi(context, "tb", "1", "6e93e7659ae637845c7f83abee68a740", "file:///android_asset/sapi_theme/style.css");
                    }
                    f = true;
                } catch (Exception e) {
                }
            }
        }
    }
}
