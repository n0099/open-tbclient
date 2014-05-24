package com.baidu.tbadk.plugins;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.tbplugin.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements k {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tbadk.tbplugin.k
    public void onFinish(int i, String str) {
        if (i != 0) {
            BdLog.e("Installation Error: " + str);
        }
    }

    @Override // com.baidu.tbadk.tbplugin.k
    public void onProgress(int i) {
    }
}
