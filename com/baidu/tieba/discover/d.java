package com.baidu.tieba.discover;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        BaseFragmentActivity baseFragmentActivity;
        a aVar2 = this.a;
        baseFragmentActivity = this.a.b;
        aVar2.a(new CustomMessage(2002001, new com.baidu.tieba.neighbors.k(baseFragmentActivity, true)));
        aVar.d();
    }
}
