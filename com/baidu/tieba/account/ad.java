package com.baidu.tieba.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
final class ad extends com.baidu.tieba.util.l {
    final /* synthetic */ Register2Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(Register2Activity register2Activity, Context context) {
        super(context);
        this.a = register2Activity;
    }

    @Override // com.baidu.tieba.util.l, android.text.style.ClickableSpan
    public final void onClick(View view) {
        af afVar;
        afVar = this.a.O;
        if (afVar == null) {
            a().startActivity(new Intent(a(), ProtocolActivity.class));
        }
    }
}
