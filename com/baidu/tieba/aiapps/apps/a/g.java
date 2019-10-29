package com.baidu.tieba.aiapps.apps.a;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class g extends ProviderDelegation {
    g() {
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Set<String> keySet = bundle.keySet();
        Bundle bundle2 = new Bundle();
        for (String str : keySet) {
            if (!TextUtils.isEmpty(str)) {
                String string = bundle.getString(str, "");
                bundle2.putString(str, c.p(getAgent().getContext(), str, TextUtils.isEmpty(string) ? "" : string));
            }
        }
        return bundle2;
    }
}
