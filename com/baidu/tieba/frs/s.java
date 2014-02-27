package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.data.SignData;
import com.baidu.tieba.util.AntiHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class s extends com.baidu.adp.a.g {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.a.g
    public final void a(Object obj) {
        boolean z;
        String str;
        String str2;
        bs bsVar;
        com.baidu.tieba.model.bt btVar;
        bs bsVar2;
        com.baidu.tieba.model.bt btVar2;
        String str3;
        String str4;
        bs bsVar3;
        bs bsVar4;
        com.baidu.tieba.model.z zVar;
        String str5;
        String str6;
        bs bsVar5;
        com.baidu.tieba.model.z zVar2;
        com.baidu.tieba.model.z zVar3;
        com.baidu.tieba.model.z zVar4;
        com.baidu.tieba.model.z zVar5;
        String str7;
        com.baidu.tieba.model.z zVar6;
        com.baidu.tieba.model.z zVar7;
        com.baidu.tieba.model.z zVar8;
        bs bsVar6;
        bs bsVar7;
        bs bsVar8;
        bs bsVar9;
        int i;
        com.baidu.tieba.model.z zVar9;
        com.baidu.tieba.model.z zVar10;
        bs bsVar10;
        com.baidu.tieba.model.z zVar11;
        com.baidu.tieba.model.z zVar12;
        com.baidu.tieba.model.z zVar13;
        com.baidu.tieba.model.z zVar14;
        bs bsVar11;
        String str8;
        com.baidu.tieba.model.z zVar15;
        if (obj == null || !(obj instanceof SignData)) {
            z = false;
        } else {
            com.baidu.tieba.model.o a = com.baidu.tieba.model.o.a();
            str8 = this.a.g;
            a.b(str8);
            zVar15 = this.a.A;
            zVar15.a((SignData) obj);
            z = true;
        }
        str = this.a.G;
        if (str.equals("normal_page")) {
            bsVar11 = this.a.p;
            bsVar11.u();
        } else {
            str2 = this.a.G;
            if (str2.equals("frs_page")) {
                bsVar = this.a.p;
                bsVar.w();
            }
        }
        if (z) {
            zVar = this.a.A;
            AntiData i2 = zVar.i();
            str5 = this.a.G;
            if (str5.equals("normal_page")) {
                bsVar10 = this.a.p;
                zVar11 = this.a.A;
                int signed = zVar11.f().getSignData().getSigned();
                zVar12 = this.a.A;
                int bonusPoint = zVar12.f().getSignData().getBonusPoint();
                zVar13 = this.a.A;
                ForumData f = zVar13.f();
                zVar14 = this.a.A;
                bsVar10.b(signed, bonusPoint, f, zVar14);
            } else {
                str6 = this.a.G;
                if (str6.equals("frs_page")) {
                    bsVar5 = this.a.p;
                    zVar2 = this.a.A;
                    int signed2 = zVar2.f().getSignData().getSigned();
                    zVar3 = this.a.A;
                    int bonusPoint2 = zVar3.f().getSignData().getBonusPoint();
                    zVar4 = this.a.A;
                    ForumData f2 = zVar4.f();
                    zVar5 = this.a.A;
                    bsVar5.a(signed2, bonusPoint2, f2, zVar5);
                }
            }
            if (obj != null && (obj instanceof SignData)) {
                bsVar9 = this.a.p;
                if (bsVar9.e()) {
                    zVar10 = this.a.A;
                    i = zVar10.f().getUser_level() + 1;
                } else {
                    i = -1;
                }
                TiebaApplication g = TiebaApplication.g();
                zVar9 = this.a.A;
                g.a(zVar9.f().getName(), ((SignData) obj).getBonusPoint(), i);
            }
            if (AntiHelper.b(i2) || AntiHelper.a(i2) || AntiHelper.c(i2)) {
                str7 = this.a.g;
                i2.setBlock_forum_name(str7);
                zVar6 = this.a.A;
                i2.setBlock_forum_id(zVar6.f().getId());
                zVar7 = this.a.A;
                i2.setUser_name(zVar7.h().getUserName());
                zVar8 = this.a.A;
                i2.setUser_id(zVar8.h().getUserId());
                AntiHelper.a(this.a, i2, AntiHelper.OperationType.SIGN, AntiHelper.PageType.FRS);
                return;
            }
            StringBuilder sb = new StringBuilder(100);
            bsVar6 = this.a.p;
            if (!bsVar6.y()) {
                sb.append(this.a.getString(R.string.sign_success));
                sb.append("!\n");
                sb.append(String.format(this.a.getString(R.string.sign_user), Integer.valueOf(((SignData) obj).getUserSignRank())));
                bsVar8 = this.a.p;
                bsVar8.a(sb.toString());
                return;
            }
            sb.append(this.a.getString(R.string.sign_success));
            sb.append(",");
            sb.append(String.format(this.a.getString(R.string.sign_point), Integer.valueOf(((SignData) obj).getBonusPoint())));
            sb.append("!\n");
            sb.append(String.format(this.a.getString(R.string.sign_user), Integer.valueOf(((SignData) obj).getUserSignRank())));
            bsVar7 = this.a.p;
            bsVar7.a(sb.toString());
            return;
        }
        btVar = this.a.D;
        if (btVar.getErrorCode() == 160002) {
            str3 = this.a.G;
            if (str3.equals("normal_page")) {
                bsVar4 = this.a.p;
                bsVar4.f(1);
            } else {
                str4 = this.a.G;
                if (str4.equals("frs_page")) {
                    bsVar3 = this.a.p;
                    bsVar3.e(1);
                }
            }
        }
        bsVar2 = this.a.p;
        btVar2 = this.a.D;
        bsVar2.a(btVar2.getErrorString());
    }
}
