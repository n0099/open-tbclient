package com.baidu.tieba.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.tieba.util.k {
    final /* synthetic */ Register2Activity afJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(Register2Activity register2Activity, Context context) {
        super(context);
        this.afJ = register2Activity;
    }

    @Override // com.baidu.tieba.util.k, android.text.style.ClickableSpan
    public void onClick(View view) {
        z zVar;
        zVar = this.afJ.afF;
        if (zVar == null) {
            getContext().startActivity(new Intent(getContext(), ProtocolActivity.class));
        }
    }
}
