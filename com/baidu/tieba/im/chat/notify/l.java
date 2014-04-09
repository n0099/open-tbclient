package com.baidu.tieba.im.chat.notify;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public final void a(boolean z) {
        if (!z) {
            b.b(this.a, 1, 3);
        }
        if (!UtilHelper.a()) {
            this.a.a(com.baidu.tieba.im.j.neterror);
        }
    }
}
