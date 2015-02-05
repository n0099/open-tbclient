package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tieba.tbadkCore.av {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.av
    public void f(String str, long j) {
        String str2;
        com.baidu.tieba.tbadkCore.e eVar;
        String str3;
        String str4;
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        com.baidu.tieba.tbadkCore.d aeC = com.baidu.tieba.tbadkCore.d.aeC();
        str2 = this.aDT.aCN;
        aeC.B(str2, false);
        eVar = this.aDT.aDf;
        eVar.aeI().setLike(0);
        str3 = this.aDT.mPageType;
        if (str3.equals("normal_page")) {
            bpVar3 = this.aDT.aCV;
            bpVar3.eX(0);
        } else {
            str4 = this.aDT.mPageType;
            if (str4.equals("frs_page")) {
                bpVar = this.aDT.aCV;
                bpVar.eY(0);
            }
        }
        bpVar2 = this.aDT.aCV;
        bpVar2.bU(false);
        TbadkCoreApplication.m255getInst().delLikeForum(str);
        this.aDT.g(false, new StringBuilder(String.valueOf(j)).toString());
        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, new StringBuilder(String.valueOf(j)).toString()));
    }

    @Override // com.baidu.tieba.tbadkCore.av
    public void g(String str, long j) {
    }
}
