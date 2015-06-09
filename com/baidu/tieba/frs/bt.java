package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {
    final /* synthetic */ bq aOx;
    private final /* synthetic */ com.baidu.tbadk.core.data.w aOy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bq bqVar, com.baidu.tbadk.core.data.w wVar) {
        this.aOx = bqVar;
        this.aOy = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.aOx.mContext;
        messageManager.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(context, this.aOy.getAuthor().getUserId(), this.aOy.getAuthor().getName_show(), this.aOx.aLm.aas().getName(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
