package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.data.SignData;
import com.baidu.tieba.util.AntiHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.a.g {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        boolean z;
        String str;
        String str2;
        br brVar;
        com.baidu.tieba.model.bt btVar;
        br brVar2;
        com.baidu.tieba.model.bt btVar2;
        String str3;
        String str4;
        br brVar3;
        br brVar4;
        com.baidu.tieba.model.z zVar;
        String str5;
        String str6;
        br brVar5;
        com.baidu.tieba.model.z zVar2;
        com.baidu.tieba.model.z zVar3;
        com.baidu.tieba.model.z zVar4;
        com.baidu.tieba.model.z zVar5;
        String str7;
        com.baidu.tieba.model.z zVar6;
        com.baidu.tieba.model.z zVar7;
        com.baidu.tieba.model.z zVar8;
        br brVar6;
        br brVar7;
        br brVar8;
        br brVar9;
        int i;
        com.baidu.tieba.model.z zVar9;
        com.baidu.tieba.model.z zVar10;
        br brVar10;
        com.baidu.tieba.model.z zVar11;
        com.baidu.tieba.model.z zVar12;
        com.baidu.tieba.model.z zVar13;
        com.baidu.tieba.model.z zVar14;
        br brVar11;
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
            brVar11 = this.a.p;
            brVar11.w();
        } else {
            str2 = this.a.G;
            if (str2.equals("frs_page")) {
                brVar = this.a.p;
                brVar.y();
            }
        }
        if (z) {
            zVar = this.a.A;
            AntiData e = zVar.e();
            str5 = this.a.G;
            if (str5.equals("normal_page")) {
                brVar10 = this.a.p;
                zVar11 = this.a.A;
                int signed = zVar11.b().getSignData().getSigned();
                zVar12 = this.a.A;
                int bonusPoint = zVar12.b().getSignData().getBonusPoint();
                zVar13 = this.a.A;
                ForumData b = zVar13.b();
                zVar14 = this.a.A;
                brVar10.b(signed, bonusPoint, b, zVar14);
            } else {
                str6 = this.a.G;
                if (str6.equals("frs_page")) {
                    brVar5 = this.a.p;
                    zVar2 = this.a.A;
                    int signed2 = zVar2.b().getSignData().getSigned();
                    zVar3 = this.a.A;
                    int bonusPoint2 = zVar3.b().getSignData().getBonusPoint();
                    zVar4 = this.a.A;
                    ForumData b2 = zVar4.b();
                    zVar5 = this.a.A;
                    brVar5.a(signed2, bonusPoint2, b2, zVar5);
                }
            }
            if (obj != null && (obj instanceof SignData)) {
                brVar9 = this.a.p;
                if (brVar9.e()) {
                    zVar10 = this.a.A;
                    i = zVar10.b().getUser_level() + 1;
                } else {
                    i = -1;
                }
                TiebaApplication g = TiebaApplication.g();
                zVar9 = this.a.A;
                g.a(zVar9.b().getName(), ((SignData) obj).getBonusPoint(), i);
            }
            if (AntiHelper.b(e) || AntiHelper.a(e) || AntiHelper.c(e)) {
                str7 = this.a.g;
                e.setBlock_forum_name(str7);
                zVar6 = this.a.A;
                e.setBlock_forum_id(zVar6.b().getId());
                zVar7 = this.a.A;
                e.setUser_name(zVar7.d().getUserName());
                zVar8 = this.a.A;
                e.setUser_id(zVar8.d().getUserId());
                AntiHelper.a(this.a, e, AntiHelper.OperationType.SIGN, AntiHelper.PageType.FRS);
                return;
            }
            StringBuilder sb = new StringBuilder(100);
            brVar6 = this.a.p;
            if (!brVar6.A()) {
                sb.append(this.a.getString(R.string.sign_success));
                sb.append("!\n");
                sb.append(String.format(this.a.getString(R.string.sign_user), Integer.valueOf(((SignData) obj).getUserSignRank())));
                brVar8 = this.a.p;
                brVar8.a(sb.toString());
                return;
            }
            sb.append(this.a.getString(R.string.sign_success));
            sb.append(",");
            sb.append(String.format(this.a.getString(R.string.sign_point), Integer.valueOf(((SignData) obj).getBonusPoint())));
            sb.append("!\n");
            sb.append(String.format(this.a.getString(R.string.sign_user), Integer.valueOf(((SignData) obj).getUserSignRank())));
            brVar7 = this.a.p;
            brVar7.a(sb.toString());
            return;
        }
        btVar = this.a.D;
        if (btVar.getErrorCode() == 160002) {
            str3 = this.a.G;
            if (str3.equals("normal_page")) {
                brVar4 = this.a.p;
                brVar4.f(1);
            } else {
                str4 = this.a.G;
                if (str4.equals("frs_page")) {
                    brVar3 = this.a.p;
                    brVar3.e(1);
                }
            }
        }
        brVar2 = this.a.p;
        btVar2 = this.a.D;
        brVar2.a(btVar2.getErrorString());
    }
}
