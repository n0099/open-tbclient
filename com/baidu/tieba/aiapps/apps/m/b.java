package com.baidu.tieba.aiapps.apps.m;

import android.content.Context;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.sofire.ac.FH;
import com.baidu.swan.apps.t.b.k;
/* loaded from: classes19.dex */
public class b implements k {
    @Override // com.baidu.swan.apps.t.b.k
    public String bV(Context context) {
        return !ProcessUtils.isMainProcess() ? da(context) : getZid(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getZid(Context context) {
        return FH.gzfi(context, null, 0, null);
    }

    private String da(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, a.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }
}
