package com.baidu.tieba.aiapps.apps.m;

import android.content.Context;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.t.b.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes19.dex */
public class b implements k {
    @Override // com.baidu.swan.apps.t.b.k
    public String cb(Context context) {
        return !ProcessUtils.isMainProcess() ? dg(context) : getZid(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getZid(Context context) {
        return TbadkCoreApplication.getInst().getZid(context, null, 0, null);
    }

    private String dg(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, a.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }
}
