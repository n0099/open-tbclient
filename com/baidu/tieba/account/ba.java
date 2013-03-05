package com.baidu.tieba.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends com.baidu.tieba.c.r {
    final /* synthetic */ Register2Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(Register2Activity register2Activity, Context context) {
        super(context);
        this.a = register2Activity;
    }

    @Override // com.baidu.tieba.c.r, android.text.style.ClickableSpan
    public void onClick(View view) {
        bc bcVar;
        bcVar = this.a.R;
        if (bcVar == null) {
            a().startActivity(new Intent(a(), ProtocolActivity.class));
        }
    }
}
