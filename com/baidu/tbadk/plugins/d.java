package com.baidu.tbadk.plugins;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.tbplugin.h;
import com.baidu.tbadk.tbplugin.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements k {
    final /* synthetic */ a a;
    private final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, h hVar) {
        this.a = aVar;
        this.b = hVar;
    }

    @Override // com.baidu.tbadk.tbplugin.k
    public void a(int i, String str) {
        if (i != 0) {
            BdLog.e("Installation Error: " + str);
        }
        if (this.b != null) {
            this.b.a();
        }
    }

    @Override // com.baidu.tbadk.tbplugin.k
    public void a(int i) {
    }
}
