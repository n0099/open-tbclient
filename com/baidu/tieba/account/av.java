package com.baidu.tieba.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends com.baidu.tieba.util.p {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f659a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av(Register2Activity register2Activity, Context context) {
        super(context);
        this.f659a = register2Activity;
    }

    @Override // com.baidu.tieba.util.p, android.text.style.ClickableSpan
    public void onClick(View view) {
        ax axVar;
        axVar = this.f659a.R;
        if (axVar == null) {
            a().startActivity(new Intent(a(), ProtocolActivity.class));
        }
    }
}
