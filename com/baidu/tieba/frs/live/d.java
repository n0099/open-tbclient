package com.baidu.tieba.frs.live;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bhq;
    private final /* synthetic */ k bhr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, k kVar) {
        this.bhq = aVar;
        this.bhr = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        Context context;
        p pVar2;
        p pVar3;
        String str = "";
        pVar = this.bhq.aZs;
        if (pVar != null) {
            pVar2 = this.bhq.aZs;
            if (pVar2.ajy() != null) {
                pVar3 = this.bhq.aZs;
                str = pVar3.ajy().getName();
            }
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.bhq.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.bhr.getAuthor().getUserId(), this.bhr.getAuthor().getName_show(), str, AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
