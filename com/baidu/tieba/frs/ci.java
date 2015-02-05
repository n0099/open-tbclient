package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements View.OnClickListener {
    final /* synthetic */ cf aGq;
    private final /* synthetic */ com.baidu.tbadk.core.data.x aGu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(cf cfVar, com.baidu.tbadk.core.data.x xVar) {
        this.aGq = cfVar;
        this.aGu = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.aGq.mContext;
        messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, this.aGu.getAuthor().getUserId(), this.aGu.getAuthor().getName_show(), this.aGq.aEF.aeI().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
