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
public class e implements View.OnClickListener {
    private final /* synthetic */ w aXA;
    final /* synthetic */ a boK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, w wVar) {
        this.boK = aVar;
        this.aXA = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.boK.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.aXA.getAuthor().getUserId(), this.aXA.getAuthor().getName_show())));
    }
}
