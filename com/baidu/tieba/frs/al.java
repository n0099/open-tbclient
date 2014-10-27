package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends com.baidu.adp.base.h {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        SignData signData;
        boolean z;
        String str;
        String str2;
        bu buVar;
        com.baidu.tieba.model.ay ayVar;
        com.baidu.tieba.model.ay ayVar2;
        String str3;
        String str4;
        bu buVar2;
        bu buVar3;
        b bVar;
        b bVar2;
        b bVar3;
        String str5;
        String str6;
        bu buVar4;
        b bVar4;
        b bVar5;
        b bVar6;
        String str7;
        b bVar7;
        b bVar8;
        b bVar9;
        bu buVar5;
        bu buVar6;
        b bVar10;
        b bVar11;
        bu buVar7;
        b bVar12;
        b bVar13;
        b bVar14;
        bu buVar8;
        String str8;
        b bVar15;
        b bVar16;
        if (obj == null || !(obj instanceof SignData)) {
            signData = null;
            z = false;
        } else {
            signData = (SignData) obj;
            a EV = a.EV();
            str8 = this.aBk.aAn;
            EV.u(str8, false);
            bVar15 = this.aBk.azE;
            bVar15.a(signData);
            bVar16 = this.aBk.azE;
            signData.setForumId(bVar16.zJ().getId());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001228, signData));
            z = true;
        }
        str = this.aBk.mPageType;
        if (str.equals("normal_page")) {
            buVar8 = this.aBk.aAv;
            buVar8.Gu();
        } else {
            str2 = this.aBk.mPageType;
            if (str2.equals("frs_page")) {
                buVar = this.aBk.aAv;
                buVar.Gw();
            }
        }
        if (z) {
            bVar = this.aBk.azE;
            if (bVar != null) {
                bVar2 = this.aBk.azE;
                if (bVar2.zJ() != null) {
                    bVar3 = this.aBk.azE;
                    AntiData jZ = bVar3.jZ();
                    str5 = this.aBk.mPageType;
                    if (str5.equals("normal_page")) {
                        buVar7 = this.aBk.aAv;
                        bVar12 = this.aBk.azE;
                        SignData signData2 = bVar12.zJ().getSignData();
                        bVar13 = this.aBk.azE;
                        ForumData zJ = bVar13.zJ();
                        bVar14 = this.aBk.azE;
                        buVar7.b(signData2, zJ, bVar14);
                    } else {
                        str6 = this.aBk.mPageType;
                        if (str6.equals("frs_page")) {
                            buVar4 = this.aBk.aAv;
                            bVar4 = this.aBk.azE;
                            SignData signData3 = bVar4.zJ().getSignData();
                            bVar5 = this.aBk.azE;
                            ForumData zJ2 = bVar5.zJ();
                            bVar6 = this.aBk.azE;
                            buVar4.a(signData3, zJ2, bVar6);
                        }
                    }
                    if (signData != null) {
                        int i = -1;
                        buVar6 = this.aBk.aAv;
                        if (buVar6.Gh()) {
                            bVar11 = this.aBk.azE;
                            i = bVar11.zJ().getUser_level() + 1;
                        }
                        com.baidu.tieba.aj wk = com.baidu.tieba.aj.wk();
                        bVar10 = this.aBk.azE;
                        wk.f(bVar10.zJ().getName(), signData.getBonusPoint(), i);
                    }
                    if (AntiHelper.d(jZ) || AntiHelper.c(jZ) || AntiHelper.e(jZ)) {
                        str7 = this.aBk.aAn;
                        jZ.setBlock_forum_name(str7);
                        bVar7 = this.aBk.azE;
                        jZ.setBlock_forum_id(bVar7.zJ().getId());
                        bVar8 = this.aBk.azE;
                        jZ.setUser_name(bVar8.getUserData().getUserName());
                        bVar9 = this.aBk.azE;
                        jZ.setUser_id(bVar9.getUserData().getUserId());
                        AntiHelper.a(this.aBk, jZ, AntiHelper.OperationType.SIGN, AntiHelper.PageType.FRS);
                        return;
                    } else if (signData != null) {
                        buVar5 = this.aBk.aAv;
                        if (!buVar5.Gy()) {
                            this.aBk.showToast(this.aBk.getString(com.baidu.tieba.y.frs_sign_success, new Object[]{Integer.valueOf(signData.getUserSignRank())}));
                            return;
                        } else {
                            this.aBk.showToast(this.aBk.getString(com.baidu.tieba.y.frs_sign_pointer, new Object[]{Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())}));
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
        ayVar = this.aBk.aAG;
        if (ayVar.getErrorCode() == 160002) {
            str3 = this.aBk.mPageType;
            if (str3.equals("normal_page")) {
                buVar3 = this.aBk.aAv;
                buVar3.eS(1);
            } else {
                str4 = this.aBk.mPageType;
                if (str4.equals("frs_page")) {
                    buVar2 = this.aBk.aAv;
                    buVar2.eR(1);
                }
            }
        }
        FrsActivity frsActivity = this.aBk;
        ayVar2 = this.aBk.aAG;
        frsActivity.showToast(ayVar2.getErrorString());
    }
}
