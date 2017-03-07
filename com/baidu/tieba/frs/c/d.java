package com.baidu.tieba.frs.c;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bYX;
    private final /* synthetic */ ab bYY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, ab abVar) {
        this.bYX = aVar;
        this.bYY = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        n nVar;
        Context context;
        n nVar2;
        n nVar3;
        String str = "";
        nVar = this.bYX.bMO;
        if (nVar != null) {
            nVar2 = this.bYX.bMO;
            if (nVar2.aJp() != null) {
                nVar3 = this.bYX.bMO;
                str = nVar3.aJp().getName();
            }
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.bYX.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.bYY.getAuthor().getUserId(), this.bYY.getAuthor().getName_show(), str, AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
