package com.baidu.tieba.chat;

import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        if (!z) {
            this.a.a(1, 3);
        }
        if (!UtilHelper.b()) {
            this.a.a(R.string.neterror);
        }
    }
}
