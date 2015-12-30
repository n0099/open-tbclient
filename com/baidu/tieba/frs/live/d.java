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
    final /* synthetic */ a blh;
    private final /* synthetic */ k bli;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, k kVar) {
        this.blh = aVar;
        this.bli = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        Context context;
        p pVar2;
        p pVar3;
        String str = "";
        pVar = this.blh.bdo;
        if (pVar != null) {
            pVar2 = this.blh.bdo;
            if (pVar2.akG() != null) {
                pVar3 = this.blh.bdo;
                str = pVar3.akG().getName();
            }
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.blh.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.bli.getAuthor().getUserId(), this.bli.getAuthor().getName_show(), str, AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
