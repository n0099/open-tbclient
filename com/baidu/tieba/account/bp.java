package com.baidu.tieba.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends com.baidu.tieba.util.am {
    final /* synthetic */ Register2Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bp(Register2Activity register2Activity, Context context) {
        super(context);
        this.a = register2Activity;
    }

    @Override // com.baidu.tieba.util.am, android.text.style.ClickableSpan
    public void onClick(View view) {
        br brVar;
        brVar = this.a.O;
        if (brVar == null) {
            a().startActivity(new Intent(a(), ProtocolActivity.class));
        }
    }
}
