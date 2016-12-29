package com.baidu.tieba.frs.c;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    private final /* synthetic */ z bLA;
    final /* synthetic */ a bLz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, z zVar) {
        this.bLz = aVar;
        this.bLA = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        Context context;
        o oVar2;
        o oVar3;
        String str = "";
        oVar = this.bLz.byh;
        if (oVar != null) {
            oVar2 = this.bLz.byh;
            if (oVar2.aIk() != null) {
                oVar3 = this.bLz.byh;
                str = oVar3.aIk().getName();
            }
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.bLz.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.bLA.getAuthor().getUserId(), this.bLA.getAuthor().getName_show(), str, AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
