package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.base.i {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        SignData signData;
        boolean z;
        String str;
        String str2;
        bp bpVar;
        df dfVar;
        df dfVar2;
        String str3;
        String str4;
        bp bpVar2;
        bp bpVar3;
        com.baidu.tieba.tbadkCore.e eVar;
        com.baidu.tieba.tbadkCore.e eVar2;
        com.baidu.tieba.tbadkCore.e eVar3;
        String str5;
        String str6;
        bp bpVar4;
        com.baidu.tieba.tbadkCore.e eVar4;
        com.baidu.tieba.tbadkCore.e eVar5;
        com.baidu.tieba.tbadkCore.e eVar6;
        String str7;
        com.baidu.tieba.tbadkCore.e eVar7;
        com.baidu.tieba.tbadkCore.e eVar8;
        com.baidu.tieba.tbadkCore.e eVar9;
        bp bpVar5;
        bp bpVar6;
        com.baidu.tieba.tbadkCore.e eVar10;
        com.baidu.tieba.tbadkCore.e eVar11;
        bp bpVar7;
        com.baidu.tieba.tbadkCore.e eVar12;
        com.baidu.tieba.tbadkCore.e eVar13;
        com.baidu.tieba.tbadkCore.e eVar14;
        bp bpVar8;
        String str8;
        com.baidu.tieba.tbadkCore.e eVar15;
        com.baidu.tieba.tbadkCore.e eVar16;
        if (obj == null || !(obj instanceof SignData)) {
            signData = null;
            z = false;
        } else {
            signData = (SignData) obj;
            com.baidu.tieba.tbadkCore.d aeC = com.baidu.tieba.tbadkCore.d.aeC();
            str8 = this.aDT.aCN;
            aeC.B(str8, false);
            eVar15 = this.aDT.aDf;
            eVar15.d(signData);
            eVar16 = this.aDT.aDf;
            signData.setForumId(eVar16.aeI().getId());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001228, signData));
            z = true;
        }
        str = this.aDT.mPageType;
        if (str.equals("normal_page")) {
            bpVar8 = this.aDT.aCV;
            bpVar8.GS();
        } else {
            str2 = this.aDT.mPageType;
            if (str2.equals("frs_page")) {
                bpVar = this.aDT.aCV;
                bpVar.GU();
            }
        }
        if (z) {
            eVar = this.aDT.aDf;
            if (eVar != null) {
                eVar2 = this.aDT.aDf;
                if (eVar2.aeI() != null) {
                    eVar3 = this.aDT.aDf;
                    AntiData mK = eVar3.mK();
                    str5 = this.aDT.mPageType;
                    if (str5.equals("normal_page")) {
                        bpVar7 = this.aDT.aCV;
                        eVar12 = this.aDT.aDf;
                        SignData signData2 = eVar12.aeI().getSignData();
                        eVar13 = this.aDT.aDf;
                        ForumData aeI = eVar13.aeI();
                        eVar14 = this.aDT.aDf;
                        bpVar7.b(signData2, aeI, eVar14);
                    } else {
                        str6 = this.aDT.mPageType;
                        if (str6.equals("frs_page")) {
                            bpVar4 = this.aDT.aCV;
                            eVar4 = this.aDT.aDf;
                            SignData signData3 = eVar4.aeI().getSignData();
                            eVar5 = this.aDT.aDf;
                            ForumData aeI2 = eVar5.aeI();
                            eVar6 = this.aDT.aDf;
                            bpVar4.a(signData3, aeI2, eVar6);
                        }
                    }
                    if (signData != null) {
                        int i = -1;
                        bpVar6 = this.aDT.aCV;
                        if (bpVar6.GE()) {
                            eVar11 = this.aDT.aDf;
                            i = eVar11.aeI().getUser_level() + 1;
                        }
                        TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
                        eVar10 = this.aDT.aDf;
                        m255getInst.addSignedForum(eVar10.aeI().getName(), signData.getBonusPoint(), i);
                    }
                    if (AntiHelper.d(mK) || AntiHelper.c(mK) || AntiHelper.e(mK)) {
                        str7 = this.aDT.aCN;
                        mK.setBlock_forum_name(str7);
                        eVar7 = this.aDT.aDf;
                        mK.setBlock_forum_id(eVar7.aeI().getId());
                        eVar8 = this.aDT.aDf;
                        mK.setUser_name(eVar8.getUserData().getUserName());
                        eVar9 = this.aDT.aDf;
                        mK.setUser_id(eVar9.getUserData().getUserId());
                        AntiHelper.a(this.aDT.getPageContext().getPageActivity(), mK, AntiHelper.OperationType.SIGN, PageType.FRS);
                        return;
                    } else if (signData != null) {
                        bpVar5 = this.aDT.aCV;
                        if (!bpVar5.GW()) {
                            this.aDT.showToast(this.aDT.getPageContext().getResources().getString(com.baidu.tieba.z.frs_sign_success, Integer.valueOf(signData.getUserSignRank())));
                            return;
                        } else {
                            this.aDT.showToast(this.aDT.getPageContext().getResources().getString(com.baidu.tieba.z.frs_sign_pointer, Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())));
                            return;
                        }
                    } else {
                        return;
                    }
                }
                return;
            }
            return;
        }
        dfVar = this.aDT.aDh;
        if (dfVar.getErrorCode() == 160002) {
            str3 = this.aDT.mPageType;
            if (str3.equals("normal_page")) {
                bpVar3 = this.aDT.aCV;
                bpVar3.eW(1);
            } else {
                str4 = this.aDT.mPageType;
                if (str4.equals("frs_page")) {
                    bpVar2 = this.aDT.aCV;
                    bpVar2.eV(1);
                }
            }
        }
        FrsActivity frsActivity = this.aDT;
        dfVar2 = this.aDT.aDh;
        frsActivity.showToast(dfVar2.getErrorString());
    }
}
