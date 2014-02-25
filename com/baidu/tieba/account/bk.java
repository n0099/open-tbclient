package com.baidu.tieba.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk extends com.baidu.tieba.util.ao {
    final /* synthetic */ Register2Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bk(Register2Activity register2Activity, Context context) {
        super(context);
        this.a = register2Activity;
    }

    @Override // com.baidu.tieba.util.ao, android.text.style.ClickableSpan
    public void onClick(View view) {
        bm bmVar;
        bmVar = this.a.O;
        if (bmVar == null) {
            a().startActivity(new Intent(a(), ProtocolActivity.class));
        }
    }
}
