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
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsActivity frsActivity) {
        this.aBu = frsActivity;
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
            a EX = a.EX();
            str8 = this.aBu.aAx;
            EX.u(str8, false);
            bVar15 = this.aBu.azN;
            bVar15.a(signData);
            bVar16 = this.aBu.azN;
            signData.setForumId(bVar16.zL().getId());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001228, signData));
            z = true;
        }
        str = this.aBu.mPageType;
        if (str.equals("normal_page")) {
            buVar8 = this.aBu.aAF;
            buVar8.Gw();
        } else {
            str2 = this.aBu.mPageType;
            if (str2.equals("frs_page")) {
                buVar = this.aBu.aAF;
                buVar.Gy();
            }
        }
        if (z) {
            bVar = this.aBu.azN;
            if (bVar != null) {
                bVar2 = this.aBu.azN;
                if (bVar2.zL() != null) {
                    bVar3 = this.aBu.azN;
                    AntiData jZ = bVar3.jZ();
                    str5 = this.aBu.mPageType;
                    if (str5.equals("normal_page")) {
                        buVar7 = this.aBu.aAF;
                        bVar12 = this.aBu.azN;
                        SignData signData2 = bVar12.zL().getSignData();
                        bVar13 = this.aBu.azN;
                        ForumData zL = bVar13.zL();
                        bVar14 = this.aBu.azN;
                        buVar7.b(signData2, zL, bVar14);
                    } else {
                        str6 = this.aBu.mPageType;
                        if (str6.equals("frs_page")) {
                            buVar4 = this.aBu.aAF;
                            bVar4 = this.aBu.azN;
                            SignData signData3 = bVar4.zL().getSignData();
                            bVar5 = this.aBu.azN;
                            ForumData zL2 = bVar5.zL();
                            bVar6 = this.aBu.azN;
                            buVar4.a(signData3, zL2, bVar6);
                        }
                    }
                    if (signData != null) {
                        int i = -1;
                        buVar6 = this.aBu.aAF;
                        if (buVar6.Gj()) {
                            bVar11 = this.aBu.azN;
                            i = bVar11.zL().getUser_level() + 1;
                        }
                        com.baidu.tieba.aj wm = com.baidu.tieba.aj.wm();
                        bVar10 = this.aBu.azN;
                        wm.f(bVar10.zL().getName(), signData.getBonusPoint(), i);
                    }
                    if (AntiHelper.d(jZ) || AntiHelper.c(jZ) || AntiHelper.e(jZ)) {
                        str7 = this.aBu.aAx;
                        jZ.setBlock_forum_name(str7);
                        bVar7 = this.aBu.azN;
                        jZ.setBlock_forum_id(bVar7.zL().getId());
                        bVar8 = this.aBu.azN;
                        jZ.setUser_name(bVar8.getUserData().getUserName());
                        bVar9 = this.aBu.azN;
                        jZ.setUser_id(bVar9.getUserData().getUserId());
                        AntiHelper.a(this.aBu, jZ, AntiHelper.OperationType.SIGN, AntiHelper.PageType.FRS);
                        return;
                    } else if (signData != null) {
                        buVar5 = this.aBu.aAF;
                        if (!buVar5.GA()) {
                            this.aBu.showToast(this.aBu.getString(com.baidu.tieba.y.frs_sign_success, new Object[]{Integer.valueOf(signData.getUserSignRank())}));
                            return;
                        } else {
                            this.aBu.showToast(this.aBu.getString(com.baidu.tieba.y.frs_sign_pointer, new Object[]{Integer.valueOf(signData.getBonusPoint()), Integer.valueOf(signData.getUserSignRank())}));
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
        ayVar = this.aBu.aAQ;
        if (ayVar.getErrorCode() == 160002) {
            str3 = this.aBu.mPageType;
            if (str3.equals("normal_page")) {
                buVar3 = this.aBu.aAF;
                buVar3.eS(1);
            } else {
                str4 = this.aBu.mPageType;
                if (str4.equals("frs_page")) {
                    buVar2 = this.aBu.aAF;
                    buVar2.eR(1);
                }
            }
        }
        FrsActivity frsActivity = this.aBu;
        ayVar2 = this.aBu.aAQ;
        frsActivity.showToast(ayVar2.getErrorString());
    }
}
