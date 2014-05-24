package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.util.AntiHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.base.e {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.base.e
    public void a(Object obj) {
        boolean z;
        String str;
        String str2;
        ct ctVar;
        com.baidu.tieba.model.az azVar;
        ct ctVar2;
        com.baidu.tieba.model.az azVar2;
        String str3;
        String str4;
        ct ctVar3;
        ct ctVar4;
        g gVar;
        String str5;
        String str6;
        ct ctVar5;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        String str7;
        g gVar6;
        g gVar7;
        g gVar8;
        ct ctVar6;
        ct ctVar7;
        ct ctVar8;
        ct ctVar9;
        int i;
        g gVar9;
        g gVar10;
        ct ctVar10;
        g gVar11;
        g gVar12;
        g gVar13;
        g gVar14;
        ct ctVar11;
        String str8;
        g gVar15;
        if (obj == null || !(obj instanceof SignData)) {
            z = false;
        } else {
            f a = f.a();
            str8 = this.a.n;
            a.b(str8);
            gVar15 = this.a.I;
            gVar15.a((SignData) obj);
            z = true;
        }
        str = this.a.O;
        if (str.equals("normal_page")) {
            ctVar11 = this.a.w;
            ctVar11.E();
        } else {
            str2 = this.a.O;
            if (str2.equals("frs_page")) {
                ctVar = this.a.w;
                ctVar.G();
            }
        }
        if (z) {
            gVar = this.a.I;
            AntiData j = gVar.j();
            str5 = this.a.O;
            if (str5.equals("normal_page")) {
                ctVar10 = this.a.w;
                gVar11 = this.a.I;
                int signed = gVar11.g().getSignData().getSigned();
                gVar12 = this.a.I;
                int bonusPoint = gVar12.g().getSignData().getBonusPoint();
                gVar13 = this.a.I;
                ForumData g = gVar13.g();
                gVar14 = this.a.I;
                ctVar10.b(signed, bonusPoint, g, gVar14);
            } else {
                str6 = this.a.O;
                if (str6.equals("frs_page")) {
                    ctVar5 = this.a.w;
                    gVar2 = this.a.I;
                    int signed2 = gVar2.g().getSignData().getSigned();
                    gVar3 = this.a.I;
                    int bonusPoint2 = gVar3.g().getSignData().getBonusPoint();
                    gVar4 = this.a.I;
                    ForumData g2 = gVar4.g();
                    gVar5 = this.a.I;
                    ctVar5.a(signed2, bonusPoint2, g2, gVar5);
                }
            }
            if (obj != null && (obj instanceof SignData)) {
                ctVar9 = this.a.w;
                if (ctVar9.m()) {
                    gVar10 = this.a.I;
                    i = gVar10.g().getUser_level() + 1;
                } else {
                    i = -1;
                }
                com.baidu.tieba.ai c = com.baidu.tieba.ai.c();
                gVar9 = this.a.I;
                c.a(gVar9.g().getName(), ((SignData) obj).getBonusPoint(), i);
            }
            if (AntiHelper.b(j) || AntiHelper.a(j) || AntiHelper.c(j)) {
                str7 = this.a.n;
                j.setBlock_forum_name(str7);
                gVar6 = this.a.I;
                j.setBlock_forum_id(gVar6.g().getId());
                gVar7 = this.a.I;
                j.setUser_name(gVar7.i().getUserName());
                gVar8 = this.a.I;
                j.setUser_id(gVar8.i().getUserId());
                AntiHelper.a(this.a, j, AntiHelper.OperationType.SIGN, AntiHelper.PageType.FRS);
                return;
            }
            StringBuilder sb = new StringBuilder(100);
            ctVar6 = this.a.w;
            if (!ctVar6.I()) {
                sb.append(this.a.getString(com.baidu.tieba.y.sign_success));
                sb.append("!\n");
                sb.append(String.format(this.a.getString(com.baidu.tieba.y.sign_user), Integer.valueOf(((SignData) obj).getUserSignRank())));
                ctVar8 = this.a.w;
                ctVar8.a(sb.toString());
                return;
            }
            sb.append(this.a.getString(com.baidu.tieba.y.sign_success));
            sb.append(",");
            sb.append(String.format(this.a.getString(com.baidu.tieba.y.sign_point), Integer.valueOf(((SignData) obj).getBonusPoint())));
            sb.append("!\n");
            sb.append(String.format(this.a.getString(com.baidu.tieba.y.sign_user), Integer.valueOf(((SignData) obj).getUserSignRank())));
            ctVar7 = this.a.w;
            ctVar7.a(sb.toString());
            return;
        }
        azVar = this.a.L;
        if (azVar.getErrorCode() == 160002) {
            str3 = this.a.O;
            if (str3.equals("normal_page")) {
                ctVar4 = this.a.w;
                ctVar4.f(1);
            } else {
                str4 = this.a.O;
                if (str4.equals("frs_page")) {
                    ctVar3 = this.a.w;
                    ctVar3.e(1);
                }
            }
        }
        ctVar2 = this.a.w;
        azVar2 = this.a.L;
        ctVar2.a(azVar2.getErrorString());
    }
}
