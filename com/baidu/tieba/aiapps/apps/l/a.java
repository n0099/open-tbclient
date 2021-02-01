package com.baidu.tieba.aiapps.apps.l;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.process.messaging.service.e;
import com.baidu.swan.veloce.c;
/* loaded from: classes9.dex */
public class a implements com.baidu.swan.veloce.a {
    @Override // com.baidu.swan.veloce.a
    public Bundle h(String str, Bundle bundle) {
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
                return ai(bundle);
            default:
                return c.j(str, bundle);
        }
    }

    private Bundle ai(Bundle bundle) {
        if (bundle == null) {
        }
        return null;
    }

    @Override // com.baidu.swan.veloce.a
    public void bfJ() {
        p.aNQ();
        p.aNP();
        p.aNR();
        try {
            new UnitedSchemeMainDispatcher();
            SwanLauncher.atI();
            e.aGn();
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.swan.veloce.a
    public void yW(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.facade.b.b.uO(str);
        }
    }
}
