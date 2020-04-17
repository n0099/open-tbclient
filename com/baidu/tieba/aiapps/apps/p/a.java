package com.baidu.tieba.aiapps.apps.p;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.process.messaging.service.e;
import com.baidu.swan.veloce.d;
/* loaded from: classes12.dex */
public class a implements com.baidu.swan.veloce.a {
    @Override // com.baidu.swan.veloce.a
    public Bundle e(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -504534151:
                if (str.equals("veloce_sync_account_info")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return ac(bundle);
            default:
                return d.g(str, bundle);
        }
    }

    private Bundle ac(Bundle bundle) {
        if (bundle == null) {
        }
        return null;
    }

    @Override // com.baidu.swan.veloce.a
    public void aEE() {
        m.aoV();
        m.aoU();
        m.aoW();
        try {
            new UnitedSchemeMainDispatcher();
            SwanLauncher.Zy();
            e.ajC();
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.swan.veloce.a
    public void sB(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.facade.b.b.oL(str);
        }
    }
}
