package com.baidu.tieba.aiapps.apps.a;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.agent.provider.ProcessDelegateBaseProvider;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import java.util.ArrayList;
import kotlin.jvm.internal.p;
/* loaded from: classes4.dex */
public final class d extends ProviderDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
    public Bundle execCall(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        ArrayList<String> stringArrayList = bundle != null ? bundle.getStringArrayList("key_list") : null;
        if (stringArrayList != null) {
            for (String str : stringArrayList) {
                if (str != null) {
                    switch (str.hashCode()) {
                        case -338203957:
                            if (str.equals("portrait_url")) {
                                String portraitUrl = b.getPortraitUrl();
                                if (portraitUrl != null) {
                                    bundle2.putString(str, portraitUrl);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case 70690926:
                            if (str.equals("nickname")) {
                                ProcessDelegateBaseProvider agent = getAgent();
                                p.g(agent, "agent");
                                String ce = b.ce(agent.getContext());
                                if (ce != null) {
                                    bundle2.putString(str, ce);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                    }
                }
            }
        }
        return bundle2;
    }
}
