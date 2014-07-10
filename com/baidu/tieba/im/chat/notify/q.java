package com.baidu.tieba.im.chat.notify;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(d dVar) {
        this.a = dVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        if (!z) {
            this.a.g();
        }
        if (!UtilHelper.isNetOk()) {
            this.a.a(y.neterror);
        }
    }
}
