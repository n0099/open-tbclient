package com.baidu.tieba.aiapps.apps.m;

import android.content.Context;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.sofire.ac.FH;
import com.baidu.swan.apps.u.b.k;
/* loaded from: classes12.dex */
public class b implements k {
    @Override // com.baidu.swan.apps.u.b.k
    public String bR(Context context) {
        return !ProcessUtils.isMainProcess() ? cU(context) : getZid(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getZid(Context context) {
        return FH.gzfi(context, null, 0, null);
    }

    private String cU(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, a.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }
}
