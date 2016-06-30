package com.baidu.tieba.frs.d;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bPu;
    private final /* synthetic */ t bPv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, t tVar) {
        this.bPu = aVar;
        this.bPv = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        Context context;
        p pVar2;
        p pVar3;
        String str = "";
        pVar = this.bPu.bCF;
        if (pVar != null) {
            pVar2 = this.bPu.bCF;
            if (pVar2.aDN() != null) {
                pVar3 = this.bPu.bCF;
                str = pVar3.aDN().getName();
            }
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.bPu.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.bPv.getAuthor().getUserId(), this.bPv.getAuthor().getName_show(), str, AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
