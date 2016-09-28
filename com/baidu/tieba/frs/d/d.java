package com.baidu.tieba.frs.d;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.y;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a cct;
    private final /* synthetic */ y ccu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, y yVar) {
        this.cct = aVar;
        this.ccu = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        Context context;
        p pVar2;
        p pVar3;
        String str = "";
        pVar = this.cct.bPk;
        if (pVar != null) {
            pVar2 = this.cct.bPk;
            if (pVar2.aMr() != null) {
                pVar3 = this.cct.bPk;
                str = pVar3.aMr().getName();
            }
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.cct.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.ccu.getAuthor().getUserId(), this.ccu.getAuthor().getName_show(), str, AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
