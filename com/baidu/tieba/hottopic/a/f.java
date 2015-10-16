package com.baidu.tieba.hottopic.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ w aXr;
    final /* synthetic */ a bog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, w wVar) {
        this.bog = aVar;
        this.aXr = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.bog.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.aXr.getAuthor().getUserId(), this.aXr.getAuthor().getName_show())));
    }
}
