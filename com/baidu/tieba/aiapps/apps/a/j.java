package com.baidu.tieba.aiapps.apps.a;

import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class j extends ProviderDelegation {
    j() {
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("result", c.getZid(AppRuntime.getAppContext()));
        return bundle2;
    }
}
