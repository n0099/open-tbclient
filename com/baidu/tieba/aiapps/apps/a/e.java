package com.baidu.tieba.aiapps.apps.a;

import android.os.Bundle;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class e extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        HashMap hashMap = new HashMap();
        hashMap.put("bd_box_bduss", "");
        hashMap.put("bd_box_ptoken", "");
        HashMap hashMap2 = (HashMap) c.j(getAgent().getContext(), hashMap);
        if (hashMap2 == null || hashMap2.size() == 0) {
            return bundle2;
        }
        bundle2.putSerializable(p.cZK, hashMap2);
        bundle2.putStringArrayList(p.cZM, (ArrayList) SapiUtils.getAuthorizedDomains(getAgent().getContext()));
        bundle2.putStringArrayList(p.cZL, (ArrayList) SapiUtils.getAuthorizedDomainsForPtoken(getAgent().getContext()));
        return bundle2;
    }
}
