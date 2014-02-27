package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SapiFastRegActivity extends com.baidu.tieba.f {
    y a = null;
    private String b = null;
    private Handler c = new Handler();
    private az d = new bn(this);

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, SapiFastRegActivity.class), 22002);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_spi_webview_fastreg);
        SapiWebView sapiWebView = (SapiWebView) findViewById(R.id.sapi_webview);
        sapiWebView.setOnFinishCallback(new bp(this));
        sapiWebView.setAuthorizationListener(new bq(this));
        sapiWebView.loadFastReg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(SapiFastRegActivity sapiFastRegActivity, AccountData accountData) {
        if (sapiFastRegActivity.a == null) {
            sapiFastRegActivity.a = new y(sapiFastRegActivity);
            sapiFastRegActivity.a.a(new bs(sapiFastRegActivity));
        }
        sapiFastRegActivity.a.e();
        sapiFastRegActivity.a.a(accountData);
        sapiFastRegActivity.a.a();
    }

    public static void a(Context context) {
        SapiAccountManager.getInstance().init(new SapiConfiguration.Builder(context).setProductLineInfo("tb", SocialConstants.TRUE, "6e93e7659ae637845c7f83abee68a740").setRuntimeEnvironment(Domain.DOMAIN_ONLINE).loginShareStrategy(LoginShareStrategy.DISABLED).skin("file:///android_asset/sapi_theme/style.css").debug(true).build());
    }
}
