package com.baidu.tbadk.plugins;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.tbplugin.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements k {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tbadk.tbplugin.k
    public void a(int i, String str) {
        if (i != 0) {
            BdLog.e("BdSocialShareSdkDelegate Installation Error: " + str);
        } else {
            BdLog.i("BdSocialShareSdkDelegate Installation Success");
        }
    }

    @Override // com.baidu.tbadk.tbplugin.k
    public void a(int i) {
    }
}
