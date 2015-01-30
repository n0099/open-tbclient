package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.i {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        com.baidu.tieba.tbadkCore.ac acVar;
        com.baidu.tieba.tbadkCore.ac acVar2;
        String str;
        String str2;
        bp bpVar;
        com.baidu.tieba.tbadkCore.e eVar;
        com.baidu.tieba.tbadkCore.e eVar2;
        bp bpVar2;
        String str3;
        com.baidu.tieba.tbadkCore.e eVar3;
        bp bpVar3;
        com.baidu.tieba.tbadkCore.e eVar4;
        com.baidu.tieba.tbadkCore.e eVar5;
        String str4;
        com.baidu.tieba.tbadkCore.e eVar6;
        boolean z = false;
        if (obj != null && (obj instanceof com.baidu.tieba.tbadkCore.ae)) {
            com.baidu.tieba.tbadkCore.d aeH = com.baidu.tieba.tbadkCore.d.aeH();
            str4 = this.aDW.aCQ;
            aeH.B(str4, false);
            ((com.baidu.tieba.tbadkCore.ae) obj).setLike(1);
            eVar6 = this.aDW.aDi;
            eVar6.a((com.baidu.tieba.tbadkCore.ae) obj);
            z = true;
        }
        if (!z) {
            acVar = this.aDW.zm;
            if (acVar.getErrorCode() == 22) {
                this.aDW.showToast(this.aDW.getPageContext().getString(com.baidu.tieba.z.had_liked_forum));
            } else {
                FrsActivity frsActivity = this.aDW;
                acVar2 = this.aDW.zm;
                frsActivity.showToast(acVar2.getErrorString());
            }
            this.aDW.refresh();
            return;
        }
        str = this.aDW.mPageType;
        if (str.equals("normal_page")) {
            bpVar3 = this.aDW.aCY;
            eVar4 = this.aDW.aDi;
            ForumData aeN = eVar4.aeN();
            eVar5 = this.aDW.aDi;
            bpVar3.b(1, aeN, eVar5, true);
        } else {
            str2 = this.aDW.mPageType;
            if (str2.equals("frs_page")) {
                bpVar = this.aDW.aCY;
                eVar = this.aDW.aDi;
                ForumData aeN2 = eVar.aeN();
                eVar2 = this.aDW.aDi;
                bpVar.a(1, aeN2, eVar2, true);
            }
        }
        bpVar2 = this.aDW.aCY;
        bpVar2.bU(true);
        this.aDW.showToast(this.aDW.getPageContext().getString(com.baidu.tieba.z.like_success));
        TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
        str3 = this.aDW.aCQ;
        m255getInst.addLikeForum(str3);
        FrsActivity frsActivity2 = this.aDW;
        eVar3 = this.aDW.aDi;
        frsActivity2.g(true, eVar3.aeN().getId());
    }
}
