package com.baidu.tieba.frs.c;

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
    final /* synthetic */ a brR;
    private final /* synthetic */ r brS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, r rVar) {
        this.brR = aVar;
        this.brS = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        Context context;
        o oVar2;
        o oVar3;
        String str = "";
        oVar = this.brR.bgq;
        if (oVar != null) {
            oVar2 = this.brR.bgq;
            if (oVar2.avA() != null) {
                oVar3 = this.brR.bgq;
                str = oVar3.avA().getName();
            }
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.brR.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(context, this.brS.getAuthor().getUserId(), this.brS.getAuthor().getName_show(), str, AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }
}
