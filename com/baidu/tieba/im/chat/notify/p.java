package com.baidu.tieba.im.chat.notify;

import android.view.View;
/* loaded from: classes.dex */
final class p implements View.OnClickListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(b bVar) {
        this.a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.a().b("is_shut_down_validate", true);
        this.a.d(false);
        this.a.a(false);
    }
}
