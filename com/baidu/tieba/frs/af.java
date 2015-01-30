package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tieba.tbadkCore.av {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FrsActivity frsActivity) {
        this.aDW = frsActivity;
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
        com.baidu.tieba.tbadkCore.d aeH = com.baidu.tieba.tbadkCore.d.aeH();
        str2 = this.aDW.aCQ;
        aeH.B(str2, false);
        eVar = this.aDW.aDi;
        eVar.aeN().setLike(0);
        str3 = this.aDW.mPageType;
        if (str3.equals("normal_page")) {
            bpVar3 = this.aDW.aCY;
            bpVar3.eX(0);
        } else {
            str4 = this.aDW.mPageType;
            if (str4.equals("frs_page")) {
                bpVar = this.aDW.aCY;
                bpVar.eY(0);
            }
        }
        bpVar2 = this.aDW.aCY;
        bpVar2.bU(false);
        TbadkCoreApplication.m255getInst().delLikeForum(str);
        this.aDW.g(false, new StringBuilder(String.valueOf(j)).toString());
        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, new StringBuilder(String.valueOf(j)).toString()));
    }

    @Override // com.baidu.tieba.tbadkCore.av
    public void g(String str, long j) {
    }
}
