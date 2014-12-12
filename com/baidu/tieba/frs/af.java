package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tieba.tbadkCore.av {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.av
    public void f(String str, long j) {
        String str2;
        com.baidu.tieba.tbadkCore.e eVar;
        String str3;
        String str4;
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        com.baidu.tieba.tbadkCore.d aed = com.baidu.tieba.tbadkCore.d.aed();
        str2 = this.aCV.aBP;
        aed.C(str2, false);
        eVar = this.aCV.aCh;
        eVar.aej().setLike(0);
        str3 = this.aCV.mPageType;
        if (str3.equals("normal_page")) {
            bqVar3 = this.aCV.aBX;
            bqVar3.eR(0);
        } else {
            str4 = this.aCV.mPageType;
            if (str4.equals("frs_page")) {
                bqVar = this.aCV.aBX;
                bqVar.eS(0);
            }
        }
        bqVar2 = this.aCV.aBX;
        bqVar2.bR(false);
        TbadkCoreApplication.m255getInst().delLikeForum(str);
        this.aCV.g(false, new StringBuilder(String.valueOf(j)).toString());
        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, new StringBuilder(String.valueOf(j)).toString()));
    }

    @Override // com.baidu.tieba.tbadkCore.av
    public void g(String str, long j) {
    }
}
