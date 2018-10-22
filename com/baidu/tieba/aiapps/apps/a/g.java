package com.baidu.tieba.aiapps.apps.a;

import android.content.Context;
import android.os.Bundle;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
/* loaded from: classes4.dex */
public class g extends ActivityDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        String[] stringArray = this.mParams.getStringArray("param_tpl_list");
        if (stringArray == null || stringArray.length < 1) {
            return true;
        }
        b.a((Context) getAgent(), new TypedCallback<Bundle>() { // from class: com.baidu.tieba.aiapps.apps.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(Bundle bundle) {
                if (bundle != null) {
                    g.this.mResult.putAll(bundle);
                }
                g.this.finish();
            }
        }, stringArray);
        return false;
    }
}
