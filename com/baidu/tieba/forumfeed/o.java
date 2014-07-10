package com.baidu.tieba.forumfeed;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bo;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ n a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, Context context) {
        this.a = nVar;
        this.b = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2010010, new bo(this.b)));
    }
}
