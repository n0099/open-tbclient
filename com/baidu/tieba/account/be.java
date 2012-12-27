package com.baidu.tieba.account;

import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class be implements View.OnClickListener {
    final /* synthetic */ RegisterActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(RegisterActivity registerActivity) {
        this.a = registerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.startActivity(new Intent(this.a, ProtocolActivity.class));
    }
}
