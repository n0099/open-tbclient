package com.baidu.tieba.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends com.baidu.tbadk.util.h {
    final /* synthetic */ Register2Activity awk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(Register2Activity register2Activity, Context context) {
        super(context);
        this.awk = register2Activity;
    }

    @Override // com.baidu.tbadk.util.h, android.text.style.ClickableSpan
    public void onClick(View view) {
        ah ahVar;
        ahVar = this.awk.awg;
        if (ahVar == null) {
            getContext().startActivity(new Intent(getContext(), ProtocolActivity.class));
        }
    }
}
