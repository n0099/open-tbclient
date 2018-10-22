package com.baidu.tieba.aiapps.apps.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class i extends ProviderDelegation {
    i() {
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("result", b.isLogin(getAgent().getContext()));
        return bundle2;
    }
}
