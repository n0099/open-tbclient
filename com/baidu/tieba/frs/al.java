package com.baidu.tieba.frs;

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
        cu cuVar;
        com.baidu.tieba.model.bb bbVar;
        com.baidu.tieba.model.bb bbVar2;
        String str3;
        String str4;
        cu cuVar2;
        cu cuVar3;
        g gVar;
        String str5;
        String str6;
        cu cuVar4;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        String str7;
        g gVar6;
        g gVar7;
        g gVar8;
        cu cuVar5;
        cu cuVar6;
        g gVar9;
        g gVar10;
        cu cuVar7;
        g gVar11;
        g gVar12;
        g gVar13;
        g gVar14;
        cu cuVar8;
        String str8;
        g gVar15;
        if (obj == null || !(obj instanceof SignData)) {
            signData = null;
            z = false;
        } else {
            signData = (SignData) obj;
            f a = f.a();
            str8 = this.a.q;
            a.a(str8, false);
            gVar15 = this.a.L;
            gVar15.a(signData);
            z = true;
        }
        str = this.a.R;
        if (str.equals("normal_page")) {
            cuVar8 = this.a.z;
            cuVar8.C();
        } else {
            str2 = this.a.R;
            if (str2.equals("frs_page")) {
                cuVar = this.a.z;
                cuVar.E();
            }
        }
        if (z) {
            gVar = this.a.L;
            AntiData l = gVar.l();
            str5 = this.a.R;
            if (str5.equals("normal_page")) {
                cuVar7 = this.a.z;
                gVar11 = this.a.L;
                int signed = gVar11.i().getSignData().getSigned();
                gVar12 = this.a.L;
                int bonusPoint = gVar12.i().getSignData().getBonusPoint();
                gVar13 = this.a.L;
                ForumData i = gVar13.i();
                gVar14 = this.a.L;
                cuVar7.b(signed, bonusPoint, i, gVar14);
            } else {
                str6 = this.a.R;
                if (str6.equals("frs_page")) {
                    cuVar4 = this.a.z;
                    gVar2 = this.a.L;
                    int signed2 = gVar2.i().getSignData().getSigned();
                    gVar3 = this.a.L;
                    int bonusPoint2 = gVar3.i().getSignData().getBonusPoint();
                    gVar4 = this.a.L;
                    ForumData i2 = gVar4.i();
                    gVar5 = this.a.L;
                    cuVar4.a(signed2, bonusPoint2, i2, gVar5);
                }
            }
            if (signData != null) {
                int i3 = -1;
                cuVar6 = this.a.z;
                if (cuVar6.m()) {
                    gVar10 = this.a.L;
                    i3 = gVar10.i().getUser_level() + 1;
                }
                com.baidu.tieba.ai c = com.baidu.tieba.ai.c();
                gVar9 = this.a.L;
                c.a(gVar9.i().getName(), signData.getBonusPoint(), i3);
            }
            if (AntiHelper.b(l) || AntiHelper.a(l) || AntiHelper.c(l)) {
                str7 = this.a.q;
                l.setBlock_forum_name(str7);
                gVar6 = this.a.L;
                l.setBlock_forum_id(gVar6.i().getId());
                gVar7 = this.a.L;
                l.setUser_name(gVar7.k().getUserName());
                gVar8 = this.a.L;
                l.setUser_id(gVar8.k().getUserId());
                AntiHelper.a(this.a, l, AntiHelper.OperationType.SIGN, AntiHelper.PageType.FRS);
                return;
            }
            StringBuilder sb = new StringBuilder(100);
            if (signData != null) {
                cuVar5 = this.a.z;
                if (!cuVar5.G()) {
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
        bbVar = this.a.O;
        if (bbVar.getErrorCode() == 160002) {
            str3 = this.a.R;
            if (str3.equals("normal_page")) {
                cuVar3 = this.a.z;
                cuVar3.f(1);
            } else {
                str4 = this.a.R;
                if (str4.equals("frs_page")) {
                    cuVar2 = this.a.z;
                    cuVar2.e(1);
                }
            }
        }
        FrsActivity frsActivity = this.a;
        bbVar2 = this.a.O;
        frsActivity.showToast(bbVar2.getErrorString());
    }
}
