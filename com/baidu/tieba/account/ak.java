package com.baidu.tieba.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends com.baidu.tbadk.util.h {
    final /* synthetic */ Register2Activity axQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(Register2Activity register2Activity, Context context) {
        super(context);
        this.axQ = register2Activity;
    }

    @Override // com.baidu.tbadk.util.h, android.text.style.ClickableSpan
    public void onClick(View view) {
        am amVar;
        amVar = this.axQ.axM;
        if (amVar == null) {
            getContext().startActivity(new Intent(getContext(), ProtocolActivity.class));
        }
    }
}
