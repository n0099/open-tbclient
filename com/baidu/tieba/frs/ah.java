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
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        SignData signData;
        boolean z;
        String str;
        String str2;
        bq bqVar;
        de deVar;
        de deVar2;
        String str3;
        String str4;
        bq bqVar2;
        bq bqVar3;
        com.baidu.tieba.tbadkCore.e eVar;
        com.baidu.tieba.tbadkCore.e eVar2;
        com.baidu.tieba.tbadkCore.e eVar3;
        String str5;
        String str6;
        bq bqVar4;
        com.baidu.tieba.tbadkCore.e eVar4;
        com.baidu.tieba.tbadkCore.e eVar5;
        com.baidu.tieba.tbadkCore.e eVar6;
        String str7;
        com.baidu.tieba.tbadkCore.e eVar7;
        com.baidu.tieba.tbadkCore.e eVar8;
        com.baidu.tieba.tbadkCore.e eVar9;
        bq bqVar5;
        bq bqVar6;
        com.baidu.tieba.tbadkCore.e eVar10;
        com.baidu.tieba.tbadkCore.e eVar11;
        bq bqVar7;
        com.baidu.tieba.tbadkCore.e eVar12;
        com.baidu.tieba.tbadkCore.e eVar13;
        com.baidu.tieba.tbadkCore.e eVar14;
        bq bqVar8;
        String str8;
        com.baidu.tieba.tbadkCore.e eVar15;
        com.baidu.tieba.tbadkCore.e eVar16;
        if (obj == null || !(obj instanceof SignData)) {
            signData = null;
            z = false;
        } else {
            signData = (SignData) obj;
            com.baidu.tieba.tbadkCore.d aed = com.baidu.tieba.tbadkCore.d.aed();
            str8 = this.aCV.aBP;
            aed.C(str8, false);
            eVar15 = this.aCV.aCh;
            eVar15.d(signData);
            eVar16 = this.aCV.aCh;
            signData.setForumId(eVar16.aej().getId());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001228, signData));
            z = true;
        }
        str = this.aCV.mPageType;
        if (str.equals("normal_page")) {
            bqVar8 = this.aCV.aBX;
            bqVar8.GB();
        } else {
            str2 = this.aCV.mPageType;
            if (str2.equals("frs_page")) {
                bqVar = this.aCV.aBX;
                bqVar.GD();
            }
        }
        if (z) {
            eVar = this.aCV.aCh;
            if (eVar != null) {
                eVar2 = this.aCV.aCh;
                if (eVar2.aej() != null) {
                    eVar3 = this.aCV.aCh;
                    AntiData mP = eVar3.mP();
                    str5 = this.aCV.mPageType;
                    if (str5.equals("normal_page")) {
                        bqVar7 = this.aCV.aBX;
                        eVar12 = this.aCV.aCh;
                        SignData signData2 = eVar12.aej().getSignData();
                        eVar13 = this.aCV.aCh;
                        ForumData aej = eVar13.aej();
                        eVar14 = this.aCV.aCh;
                        bqVar7.b(signData2, aej, eVar14);
                    } else {
                        str6 = this.aCV.mPageType;
                        if (str6.equals("frs_page")) {
                            bqVar4 = this.aCV.aBX;
                            eVar4 = this.aCV.aCh;
                            SignData signData3 = eVar4.aej().getSignData();
                            eVar5 = this.aCV.aCh;
                            ForumData aej2 = eVar5.aej();
                            eVar6 = this.aCV.aCh;
                            bqVar4.a(signData3, aej2, eVar6);
                        }
                    }
                    if (signData != null) {
                        int i = -1;
                        bqVar6 = this.aCV.aBX;
                        if (bqVar6.Gn()) {
                            eVar11 = this.aCV.aCh;
                            i = eVar11.aej().getUser_level() + 1;
                        }
                        TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
                        eVar10 = this.aCV.aCh;
                        m255getInst.addSignedForum(eVar10.aej().getName(), signData.getBonusPoint(), i);
                    }
                    if (AntiHelper.d(mP) || AntiHelper.c(mP) || AntiHelper.e(mP)) {
                        str7 = this.aCV.aBP;
                        mP.setBlock_forum_name(str7);
                        eVar7 = this.aCV.aCh;
                        mP.setBlock_forum_id(eVar7.aej().getId());
                        eVar8 = this.aCV.aCh;
                        mP.setUser_name(eVar8.getUserData().getUserName());
                        eVar9 = this.aCV.aCh;
                        mP.setUser_id(eVar9.getUserData().getUserId());
                        AntiHelper.a(this.aCV.getPageContext().getPageActivity(), mP, AntiHelper.OperationType.SIGN, PageType.FRS);
                        return;
                    } else if (signData != null) {
                        bqVar5 = this.aCV.aBX;
                        if (!bqVar5.GF()) {
                            this.aCV.showToast(this.aCV.getPageContext().getResources().getString(com.baidu.tieba.z.frs_sign_success, Integer.valueOf(signData.getUserSignRank())));
                            return;
                        } else {
                            this.aCV.showToast(this.aCV.getPageContext().getResources().getString(com.baidu.tieba.z.frs_sign_pointer, Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())));
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
        deVar = this.aCV.aCj;
        if (deVar.getErrorCode() == 160002) {
            str3 = this.aCV.mPageType;
            if (str3.equals("normal_page")) {
                bqVar3 = this.aCV.aBX;
                bqVar3.eQ(1);
            } else {
                str4 = this.aCV.mPageType;
                if (str4.equals("frs_page")) {
                    bqVar2 = this.aCV.aBX;
                    bqVar2.eP(1);
                }
            }
        }
        FrsActivity frsActivity = this.aCV;
        deVar2 = this.aCV.aCj;
        frsActivity.showToast(deVar2.getErrorString());
    }
}
