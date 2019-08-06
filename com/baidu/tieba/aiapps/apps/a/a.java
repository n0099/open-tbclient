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
    private b dbd;
    private List<com.baidu.swan.apps.a.c> mListeners;
    public static final String TAG = a.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
        this.mListeners = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.aiapps.apps.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0278a {
        private static final a dbf = new a();
    }

    public static a aEy() {
        return C0278a.dbf;
    }

    public void init(Context context) {
        dj(context);
        di(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(Context context) {
        if (this.dbd == null) {
            this.dbd = new b();
            this.dbd.dbg = com.baidu.swan.apps.storage.b.f.NX().getString("bd_box_avatar_url", "");
            this.dbd.bduss = com.baidu.swan.apps.storage.b.f.NX().getString("bd_box_bduss", "");
            this.dbd.dbh = com.baidu.swan.apps.storage.b.f.NX().getString("bd_box_ptoken", "");
            this.dbd.uid = com.baidu.swan.apps.storage.b.f.NX().getString("bd_box_uid", "");
            this.dbd.displayName = com.baidu.swan.apps.storage.b.f.NX().getString("bd_box_display_name", "");
        }
    }

    private void dj(final Context context) {
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
                a.this.di(context);
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
