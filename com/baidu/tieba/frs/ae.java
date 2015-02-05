package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends com.baidu.adp.base.i {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FrsActivity frsActivity) {
        this.aDT = frsActivity;
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
            com.baidu.tieba.tbadkCore.d aeC = com.baidu.tieba.tbadkCore.d.aeC();
            str4 = this.aDT.aCN;
            aeC.B(str4, false);
            ((com.baidu.tieba.tbadkCore.ae) obj).setLike(1);
            eVar6 = this.aDT.aDf;
            eVar6.a((com.baidu.tieba.tbadkCore.ae) obj);
            z = true;
        }
        if (!z) {
            acVar = this.aDT.zj;
            if (acVar.getErrorCode() == 22) {
                this.aDT.showToast(this.aDT.getPageContext().getString(com.baidu.tieba.z.had_liked_forum));
            } else {
                FrsActivity frsActivity = this.aDT;
                acVar2 = this.aDT.zj;
                frsActivity.showToast(acVar2.getErrorString());
            }
            this.aDT.refresh();
            return;
        }
        str = this.aDT.mPageType;
        if (str.equals("normal_page")) {
            bpVar3 = this.aDT.aCV;
            eVar4 = this.aDT.aDf;
            ForumData aeI = eVar4.aeI();
            eVar5 = this.aDT.aDf;
            bpVar3.b(1, aeI, eVar5, true);
        } else {
            str2 = this.aDT.mPageType;
            if (str2.equals("frs_page")) {
                bpVar = this.aDT.aCV;
                eVar = this.aDT.aDf;
                ForumData aeI2 = eVar.aeI();
                eVar2 = this.aDT.aDf;
                bpVar.a(1, aeI2, eVar2, true);
            }
        }
        bpVar2 = this.aDT.aCV;
        bpVar2.bU(true);
        this.aDT.showToast(this.aDT.getPageContext().getString(com.baidu.tieba.z.like_success));
        TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
        str3 = this.aDT.aCN;
        m255getInst.addLikeForum(str3);
        FrsActivity frsActivity2 = this.aDT;
        eVar3 = this.aDT.aDf;
        frsActivity2.g(true, eVar3.aeI().getId());
    }
}
