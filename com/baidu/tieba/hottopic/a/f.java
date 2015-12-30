package com.baidu.tieba.hottopic.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ a bGb;
    private final /* synthetic */ z bgh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, z zVar) {
        this.bGb = aVar;
        this.bgh = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.bGb.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.bgh.getAuthor().getUserId(), this.bgh.getAuthor().getName_show())));
    }
}
