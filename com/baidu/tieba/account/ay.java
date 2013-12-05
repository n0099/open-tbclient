package com.baidu.tieba.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends com.baidu.tieba.util.ag {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f1072a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(Register2Activity register2Activity, Context context) {
        super(context);
        this.f1072a = register2Activity;
    }

    @Override // com.baidu.tieba.util.ag, android.text.style.ClickableSpan
    public void onClick(View view) {
        ba baVar;
        baVar = this.f1072a.O;
        if (baVar == null) {
            a().startActivity(new Intent(a(), ProtocolActivity.class));
        }
    }
}
