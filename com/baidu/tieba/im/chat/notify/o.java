package com.baidu.tieba.im.chat.notify;

import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        if (!z) {
            this.a.a(1, 3);
        }
        if (!UtilHelper.isNetOk()) {
            this.a.a(y.neterror);
        }
    }
}
