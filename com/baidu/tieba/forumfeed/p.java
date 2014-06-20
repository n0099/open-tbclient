package com.baidu.tieba.forumfeed;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bb;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ o a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, Context context) {
        this.a = oVar;
        this.b = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfig.SINGLE_SQUARE_CUSTOM_CMD, new bb(this.b)));
    }
}
