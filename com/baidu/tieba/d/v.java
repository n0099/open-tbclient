package com.baidu.tieba.d;

import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements BaiduAccount.CallbackListener {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.a = tVar;
    }

    @Override // com.baidu.tieba.BaiduAccount.BaiduAccount.CallbackListener
    public void callback() {
        w wVar;
        wVar = this.a.a;
        wVar.b(TiebaApplication.d().getString(R.string.error_unkown));
    }
}
