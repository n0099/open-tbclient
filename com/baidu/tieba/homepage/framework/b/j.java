package com.baidu.tieba.homepage.framework.b;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ e cwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.cwb = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.cwb.mContext;
        if (context != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.cwb.mContext;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_SQUARESEARCH, new IntentConfig(context2)));
            TiebaStatic.log(new as("c10378").s("obj_type", 0));
        }
    }
}
