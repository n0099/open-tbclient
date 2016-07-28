package com.baidu.tieba.frs.d;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bRh;
    private final /* synthetic */ v bRi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, v vVar) {
        this.bRh = aVar;
        this.bRi = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        Context context;
        p pVar2;
        p pVar3;
        String str = "";
        pVar = this.bRh.bDM;
        if (pVar != null) {
            pVar2 = this.bRh.bDM;
            if (pVar2.aGX() != null) {
                pVar3 = this.bRh.bDM;
                str = pVar3.aGX().getName();
            }
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.bRh.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.bRi.getAuthor().getUserId(), this.bRi.getAuthor().getName_show(), str, AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
