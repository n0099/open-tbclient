package com.baidu.tieba.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends com.baidu.tieba.util.aj {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f1061a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(Register2Activity register2Activity, Context context) {
        super(context);
        this.f1061a = register2Activity;
    }

    @Override // com.baidu.tieba.util.aj, android.text.style.ClickableSpan
    public void onClick(View view) {
        az azVar;
        azVar = this.f1061a.O;
        if (azVar == null) {
            a().startActivity(new Intent(a(), ProtocolActivity.class));
        }
    }
}
