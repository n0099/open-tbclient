package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SapiFastRegActivity extends com.baidu.tieba.j {
    private be a = new bu(this);

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, SapiFastRegActivity.class), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_spi_webview_fastreg);
        a();
    }

    protected void a() {
        SapiWebView sapiWebView = (SapiWebView) findViewById(R.id.sapi_webview);
        sapiWebView.setOnFinishCallback(new bs(this));
        sapiWebView.setAuthorizationListener(new bt(this));
        sapiWebView.loadFastReg();
    }

    public static void a(Context context) {
        SapiAccountManager.getInstance().init(new SapiConfiguration.Builder(context).setProductLineInfo("tb", SocialConstants.TRUE, "6e93e7659ae637845c7f83abee68a740").setRuntimeEnvironment(Domain.DOMAIN_ONLINE).loginShareStrategy(LoginShareStrategy.DISABLED).skin("file:///android_asset/sapi_theme/style.css").debug(true).build());
    }
}
