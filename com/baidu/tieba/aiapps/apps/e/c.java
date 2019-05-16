package com.baidu.tieba.aiapps.apps.e;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* loaded from: classes4.dex */
public class c extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(@NonNull Bundle bundle) {
        int i = bundle.getInt("type");
        b bVar = new b();
        String string = bundle.getString("param1");
        Bundle bundle2 = new Bundle();
        switch (i) {
            case 1:
                bundle2.putBoolean("result", bVar.shouldAcceptCookie(string, bundle.getString("param2")));
                break;
            case 2:
                bundle2.putBoolean("result", bVar.shouldSendCookie(string, bundle.getString("param2")));
                break;
            case 3:
                bVar.storeCookie(string, bundle.getStringArrayList("param2"));
                break;
            case 4:
                bundle2.putString("result", bVar.getCookie(string));
                break;
        }
        return bundle2;
    }
}
