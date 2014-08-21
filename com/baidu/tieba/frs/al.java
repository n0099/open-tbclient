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
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        SignData signData;
        boolean z;
        String str;
        String str2;
        cv cvVar;
        com.baidu.tieba.model.bb bbVar;
        com.baidu.tieba.model.bb bbVar2;
        String str3;
        String str4;
        cv cvVar2;
        cv cvVar3;
        g gVar;
        String str5;
        String str6;
        cv cvVar4;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        String str7;
        g gVar6;
        g gVar7;
        g gVar8;
        cv cvVar5;
        cv cvVar6;
        g gVar9;
        g gVar10;
        cv cvVar7;
        g gVar11;
        g gVar12;
        g gVar13;
        g gVar14;
        cv cvVar8;
        String str8;
        g gVar15;
        g gVar16;
        if (obj == null || !(obj instanceof SignData)) {
            signData = null;
            z = false;
        } else {
            signData = (SignData) obj;
            f a = f.a();
            str8 = this.a.q;
            a.a(str8, false);
            gVar15 = this.a.N;
            gVar15.a(signData);
            gVar16 = this.a.N;
            signData.setForumId(gVar16.i().getId());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001228, signData));
            z = true;
        }
        str = this.a.T;
        if (str.equals("normal_page")) {
            cvVar8 = this.a.B;
            cvVar8.C();
        } else {
            str2 = this.a.T;
            if (str2.equals("frs_page")) {
                cvVar = this.a.B;
                cvVar.E();
            }
        }
        if (z) {
            gVar = this.a.N;
            AntiData l = gVar.l();
            str5 = this.a.T;
            if (str5.equals("normal_page")) {
                cvVar7 = this.a.B;
                gVar11 = this.a.N;
                int signed = gVar11.i().getSignData().getSigned();
                gVar12 = this.a.N;
                int bonusPoint = gVar12.i().getSignData().getBonusPoint();
                gVar13 = this.a.N;
                ForumData i = gVar13.i();
                gVar14 = this.a.N;
                cvVar7.b(signed, bonusPoint, i, gVar14);
            } else {
                str6 = this.a.T;
                if (str6.equals("frs_page")) {
                    cvVar4 = this.a.B;
                    gVar2 = this.a.N;
                    int signed2 = gVar2.i().getSignData().getSigned();
                    gVar3 = this.a.N;
                    int bonusPoint2 = gVar3.i().getSignData().getBonusPoint();
                    gVar4 = this.a.N;
                    ForumData i2 = gVar4.i();
                    gVar5 = this.a.N;
                    cvVar4.a(signed2, bonusPoint2, i2, gVar5);
                }
            }
            if (signData != null) {
                int i3 = -1;
                cvVar6 = this.a.B;
                if (cvVar6.m()) {
                    gVar10 = this.a.N;
                    i3 = gVar10.i().getUser_level() + 1;
                }
                com.baidu.tieba.ai c = com.baidu.tieba.ai.c();
                gVar9 = this.a.N;
                c.a(gVar9.i().getName(), signData.getBonusPoint(), i3);
            }
            if (AntiHelper.b(l) || AntiHelper.a(l) || AntiHelper.c(l)) {
                str7 = this.a.q;
                l.setBlock_forum_name(str7);
                gVar6 = this.a.N;
                l.setBlock_forum_id(gVar6.i().getId());
                gVar7 = this.a.N;
                l.setUser_name(gVar7.k().getUserName());
                gVar8 = this.a.N;
                l.setUser_id(gVar8.k().getUserId());
                AntiHelper.a(this.a, l, AntiHelper.OperationType.SIGN, AntiHelper.PageType.FRS);
                return;
            }
            StringBuilder sb = new StringBuilder(100);
            if (signData != null) {
                cvVar5 = this.a.B;
                if (!cvVar5.G()) {
                    sb.append(this.a.getString(com.baidu.tieba.x.sign_success));
                    sb.append("!\n");
                    sb.append(String.format(this.a.getString(com.baidu.tieba.x.sign_user), Integer.valueOf(signData.getUserSignRank())));
                    this.a.showToast(sb.toString());
                    return;
                }
                sb.append(this.a.getString(com.baidu.tieba.x.sign_success));
                sb.append(",");
                sb.append(String.format(this.a.getString(com.baidu.tieba.x.sign_point), Integer.valueOf(signData.getBonusPoint())));
                sb.append("!\n");
                sb.append(String.format(this.a.getString(com.baidu.tieba.x.sign_user), Integer.valueOf(signData.getUserSignRank())));
                this.a.showToast(sb.toString());
                return;
            }
            return;
        }
        bbVar = this.a.Q;
        if (bbVar.getErrorCode() == 160002) {
            str3 = this.a.T;
            if (str3.equals("normal_page")) {
                cvVar3 = this.a.B;
                cvVar3.f(1);
            } else {
                str4 = this.a.T;
                if (str4.equals("frs_page")) {
                    cvVar2 = this.a.B;
                    cvVar2.e(1);
                }
            }
        }
        FrsActivity frsActivity = this.a;
        bbVar2 = this.a.Q;
        frsActivity.showToast(bbVar2.getErrorString());
    }
}
