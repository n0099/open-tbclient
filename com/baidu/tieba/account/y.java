package com.baidu.tieba.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.f {
    final /* synthetic */ Register2Activity ani;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(Register2Activity register2Activity, Context context) {
        super(context);
        this.ani = register2Activity;
    }

    @Override // com.baidu.tbadk.util.f, android.text.style.ClickableSpan
    public void onClick(View view) {
        aa aaVar;
        aaVar = this.ani.ane;
        if (aaVar == null) {
            getContext().startActivity(new Intent(getContext(), ProtocolActivity.class));
        }
    }
}
