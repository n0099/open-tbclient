package com.baidu.tieba.frs.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.r;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a btb;
    private final /* synthetic */ r btc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, r rVar) {
        this.btb = aVar;
        this.btc = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        Context context;
        o oVar2;
        o oVar3;
        String str = "";
        oVar = this.btb.bkq;
        if (oVar != null) {
            oVar2 = this.btb.bkq;
            if (oVar2.avu() != null) {
                oVar3 = this.btb.bkq;
                str = oVar3.avu().getName();
            }
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.btb.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.btc.getAuthor().getUserId(), this.btc.getAuthor().getName_show(), str, AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
