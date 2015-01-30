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
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsActivity frsActivity) {
        this.aDW = frsActivity;
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
            com.baidu.tieba.tbadkCore.d aeH = com.baidu.tieba.tbadkCore.d.aeH();
            str8 = this.aDW.aCQ;
            aeH.B(str8, false);
            eVar15 = this.aDW.aDi;
            eVar15.d(signData);
            eVar16 = this.aDW.aDi;
            signData.setForumId(eVar16.aeN().getId());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001228, signData));
            z = true;
        }
        str = this.aDW.mPageType;
        if (str.equals("normal_page")) {
            bpVar8 = this.aDW.aCY;
            bpVar8.GY();
        } else {
            str2 = this.aDW.mPageType;
            if (str2.equals("frs_page")) {
                bpVar = this.aDW.aCY;
                bpVar.Ha();
            }
        }
        if (z) {
            eVar = this.aDW.aDi;
            if (eVar != null) {
                eVar2 = this.aDW.aDi;
                if (eVar2.aeN() != null) {
                    eVar3 = this.aDW.aDi;
                    AntiData mR = eVar3.mR();
                    str5 = this.aDW.mPageType;
                    if (str5.equals("normal_page")) {
                        bpVar7 = this.aDW.aCY;
                        eVar12 = this.aDW.aDi;
                        SignData signData2 = eVar12.aeN().getSignData();
                        eVar13 = this.aDW.aDi;
                        ForumData aeN = eVar13.aeN();
                        eVar14 = this.aDW.aDi;
                        bpVar7.b(signData2, aeN, eVar14);
                    } else {
                        str6 = this.aDW.mPageType;
                        if (str6.equals("frs_page")) {
                            bpVar4 = this.aDW.aCY;
                            eVar4 = this.aDW.aDi;
                            SignData signData3 = eVar4.aeN().getSignData();
                            eVar5 = this.aDW.aDi;
                            ForumData aeN2 = eVar5.aeN();
                            eVar6 = this.aDW.aDi;
                            bpVar4.a(signData3, aeN2, eVar6);
                        }
                    }
                    if (signData != null) {
                        int i = -1;
                        bpVar6 = this.aDW.aCY;
                        if (bpVar6.GK()) {
                            eVar11 = this.aDW.aDi;
                            i = eVar11.aeN().getUser_level() + 1;
                        }
                        TbadkCoreApplication m255getInst = TbadkCoreApplication.m255getInst();
                        eVar10 = this.aDW.aDi;
                        m255getInst.addSignedForum(eVar10.aeN().getName(), signData.getBonusPoint(), i);
                    }
                    if (AntiHelper.d(mR) || AntiHelper.c(mR) || AntiHelper.e(mR)) {
                        str7 = this.aDW.aCQ;
                        mR.setBlock_forum_name(str7);
                        eVar7 = this.aDW.aDi;
                        mR.setBlock_forum_id(eVar7.aeN().getId());
                        eVar8 = this.aDW.aDi;
                        mR.setUser_name(eVar8.getUserData().getUserName());
                        eVar9 = this.aDW.aDi;
                        mR.setUser_id(eVar9.getUserData().getUserId());
                        AntiHelper.a(this.aDW.getPageContext().getPageActivity(), mR, AntiHelper.OperationType.SIGN, PageType.FRS);
                        return;
                    } else if (signData != null) {
                        bpVar5 = this.aDW.aCY;
                        if (!bpVar5.Hc()) {
                            this.aDW.showToast(this.aDW.getPageContext().getResources().getString(com.baidu.tieba.z.frs_sign_success, Integer.valueOf(signData.getUserSignRank())));
                            return;
                        } else {
                            this.aDW.showToast(this.aDW.getPageContext().getResources().getString(com.baidu.tieba.z.frs_sign_pointer, Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())));
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
        dfVar = this.aDW.aDk;
        if (dfVar.getErrorCode() == 160002) {
            str3 = this.aDW.mPageType;
            if (str3.equals("normal_page")) {
                bpVar3 = this.aDW.aCY;
                bpVar3.eW(1);
            } else {
                str4 = this.aDW.mPageType;
                if (str4.equals("frs_page")) {
                    bpVar2 = this.aDW.aCY;
                    bpVar2.eV(1);
                }
            }
        }
        FrsActivity frsActivity = this.aDW;
        dfVar2 = this.aDW.aDk;
        frsActivity.showToast(dfVar2.getErrorString());
    }
}
