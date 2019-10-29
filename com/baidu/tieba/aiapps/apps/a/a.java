package com.baidu.tieba.aiapps.apps.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.LoginStatusChangeCallback;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private b dml;
    private List<com.baidu.swan.apps.a.c> mListeners;
    public static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
        this.mListeners = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0319a {
        private static final a dmn = new a();
    }

    public static a aFo() {
        return C0319a.dmn;
    }

    public void init(Context context) {
        cV(context);
        cU(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cU(Context context) {
        if (this.dml == null) {
            this.dml = new b();
            this.dml.dmo = com.baidu.swan.apps.storage.b.f.SR().getString("bd_box_avatar_url", "");
            this.dml.bduss = com.baidu.swan.apps.storage.b.f.SR().getString("bd_box_bduss", "");
            this.dml.dmp = com.baidu.swan.apps.storage.b.f.SR().getString("bd_box_ptoken", "");
            this.dml.uid = com.baidu.swan.apps.storage.b.f.SR().getString("bd_box_uid", "");
            this.dml.displayName = com.baidu.swan.apps.storage.b.f.SR().getString("bd_box_display_name", "");
        }
    }

    private void cV(final Context context) {
        SapiAccountManager.registerSilentShareListener(new SapiAccountManager.SilentShareListener() { // from class: com.baidu.tieba.aiapps.apps.a.a.1
            @Override // com.baidu.sapi2.SapiAccountManager.SilentShareListener
            public void onSilentShare() {
                context.sendBroadcast(new Intent("com.baidu.intent.action.SILENT_SHARE"));
                SapiAccountManager.unregisterSilentShareListener();
            }
        });
        SapiAccountManager.registerReceiveShareListener(new SapiAccountManager.ReceiveShareListener() { // from class: com.baidu.tieba.aiapps.apps.a.a.2
            @Override // com.baidu.sapi2.SapiAccountManager.ReceiveShareListener
            public void onReceiveShare() {
                a.this.cU(context);
            }
        });
        PassportSDK.setLoginStatusChangeCallback(new LoginStatusChangeCallback() { // from class: com.baidu.tieba.aiapps.apps.a.a.3
            @Override // com.baidu.sapi2.callback.LoginStatusChangeCallback
            public void onChange() {
            }
        });
    }

    public void a(com.baidu.swan.apps.a.c cVar) {
        this.mListeners.add(cVar);
    }
}
