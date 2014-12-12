package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.i {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        com.baidu.tieba.tbadkCore.ac acVar;
        com.baidu.tieba.tbadkCore.ac acVar2;
        String str;
        String str2;
        bq bqVar;
        com.baidu.tieba.tbadkCore.e eVar;
        com.baidu.tieba.tbadkCore.e eVar2;
        bq bqVar2;
        String str3;
        com.baidu.tieba.tbadkCore.e eVar3;
        bq bqVar3;
        com.baidu.tieba.tbadkCore.e eVar4;
        com.baidu.tieba.tbadkCore.e eVar5;
        String str4;
        com.baidu.tieba.tbadkCore.e eVar6;
        boolean z = false;
        if (obj != null && (obj instanceof com.baidu.tieba.tbadkCore.ae)) {
            com.baidu.tieba.tbadkCore.d aed = com.baidu.tieba.tbadkCore.d.aed();
            str4 = this.aCV.aBP;
            aed.C(str4, false);
            ((com.baidu.tieba.tbadkCore.ae) obj).setLike(1);
            eVar6 = this.aCV.aCh;
            eVar6.a((com.baidu.tieba.tbadkCore.ae) obj);
            z = true;
        }
        if (!z) {
            acVar = this.aCV.zm;
            if (acVar.getErrorCode() == 22) {
                this.aCV.showToast(this.aCV.getPageContext().getString(com.baidu.tieba.z.had_liked_forum));
            } else {
                FrsActivity frsActivity = this.aCV;
                acVar2 = this.aCV.zm;
                frsActivity.showToast(acVar2.getErrorString());
            }
            this.aCV.refresh();
            return;
        }
        str = this.aCV.mPageType;
        if (str.equals("normal_page")) {
            bqVar3 = this.aCV.aBX;
            eVar4 = this.aCV.aCh;
            ForumData aej = eVar4.aej();
            eVar5 = this.aCV.aCh;
            bqVar3.b(1, aej, eVar5, true);
        } else {
            str2 = this.aCV.mPageType;
            if (str2.equals("frs_page")) {
                bqVar = this.aCV.aBX;
                eVar = this.aCV.aCh;
                ForumData aej2 = eVar.aej();
                eVar2 = this.aCV.aCh;
                bqVar.a(1, aej2, eVar2, true);
            }
        }
        bqVar2 = this.aCV.aBX;
        bqVar2.bR(true);
        this.aCV.showToast(this.aCV.getPageContext().getString(com.baidu.tieba.z.like_success));
        TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
        str3 = this.aCV.aBP;
        m255getInst.addLikeForum(str3);
        FrsActivity frsActivity2 = this.aCV;
        eVar3 = this.aCV.aCh;
        frsActivity2.g(true, eVar3.aej().getId());
    }
}
