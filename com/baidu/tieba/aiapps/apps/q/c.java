package com.baidu.tieba.aiapps.apps.q;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.adaptation.a.m;
/* loaded from: classes9.dex */
public class c implements m {
    @Override // com.baidu.swan.apps.adaptation.a.m
    public void a(Activity activity, Bundle bundle, final com.baidu.swan.apps.media.chooser.c.d dVar) {
        if (ProcessUtils.isMainProcess()) {
            com.baidu.swan.apps.as.m.postOnIO(new b(activity, bundle, dVar), "main process compress files");
        } else {
            DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, a.class, bundle, new DelegateListener() { // from class: com.baidu.tieba.aiapps.apps.q.c.1
                @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
                public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                    Bundle bundle2 = delegateResult.mResult;
                    if (dVar != null) {
                        dVar.onResult(true, null, bundle2.getParcelableArrayList("mediaModels"));
                    }
                }
            });
        }
    }
}
