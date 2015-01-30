package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ o aJb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(o oVar) {
        this.aJb = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        tbPageContext = this.aJb.mContext;
        Context context = tbPageContext.getContext();
        str = this.aJb.aIr;
        messageManager.sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(context, str, "2", "1")));
    }
}
