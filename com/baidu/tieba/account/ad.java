package com.baidu.tieba.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.baidu.tieba.account.Register2Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends com.baidu.tbadk.util.e {
    final /* synthetic */ Register2Activity aFh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(Register2Activity register2Activity, Context context) {
        super(context);
        this.aFh = register2Activity;
    }

    @Override // com.baidu.tbadk.util.e, android.text.style.ClickableSpan
    public void onClick(View view) {
        Register2Activity.b bVar;
        bVar = this.aFh.aFd;
        if (bVar == null) {
            getContext().startActivity(new Intent(getContext(), ProtocolActivity.class));
        }
    }
}
