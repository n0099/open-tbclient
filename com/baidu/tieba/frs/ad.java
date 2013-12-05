package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.data.SignData;
import com.baidu.tieba.model.cd;
import com.baidu.tieba.util.AntiHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1363a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FrsActivity frsActivity) {
        this.f1363a = frsActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        boolean z;
        String str;
        String str2;
        bn bnVar;
        cd cdVar;
        bn bnVar2;
        cd cdVar2;
        String str3;
        String str4;
        bn bnVar3;
        bn bnVar4;
        com.baidu.tieba.model.ak akVar;
        String str5;
        String str6;
        bn bnVar5;
        com.baidu.tieba.model.ak akVar2;
        com.baidu.tieba.model.ak akVar3;
        com.baidu.tieba.model.ak akVar4;
        com.baidu.tieba.model.ak akVar5;
        String str7;
        com.baidu.tieba.model.ak akVar6;
        com.baidu.tieba.model.ak akVar7;
        com.baidu.tieba.model.ak akVar8;
        bn bnVar6;
        bn bnVar7;
        bn bnVar8;
        bn bnVar9;
        int i;
        com.baidu.tieba.model.ak akVar9;
        com.baidu.tieba.model.ak akVar10;
        bn bnVar10;
        com.baidu.tieba.model.ak akVar11;
        com.baidu.tieba.model.ak akVar12;
        com.baidu.tieba.model.ak akVar13;
        com.baidu.tieba.model.ak akVar14;
        bn bnVar11;
        String str8;
        com.baidu.tieba.model.ak akVar15;
        if (obj == null || !(obj instanceof SignData)) {
            z = false;
        } else {
            com.baidu.tieba.model.z a2 = com.baidu.tieba.model.z.a();
            str8 = this.f1363a.f;
            a2.b(str8);
            akVar15 = this.f1363a.w;
            akVar15.a((SignData) obj);
            z = true;
        }
        str = this.f1363a.C;
        if (str.equals("normal_page")) {
            bnVar11 = this.f1363a.n;
            bnVar11.v();
        } else {
            str2 = this.f1363a.C;
            if (str2.equals("frs_page")) {
                bnVar = this.f1363a.n;
                bnVar.x();
            }
        }
        if (z) {
            akVar = this.f1363a.w;
            AntiData d = akVar.d();
            str5 = this.f1363a.C;
            if (str5.equals("normal_page")) {
                bnVar10 = this.f1363a.n;
                akVar11 = this.f1363a.w;
                int signed = akVar11.a().getSignData().getSigned();
                akVar12 = this.f1363a.w;
                int bonusPoint = akVar12.a().getSignData().getBonusPoint();
                akVar13 = this.f1363a.w;
                ForumData a3 = akVar13.a();
                akVar14 = this.f1363a.w;
                bnVar10.b(signed, bonusPoint, a3, akVar14);
            } else {
                str6 = this.f1363a.C;
                if (str6.equals("frs_page")) {
                    bnVar5 = this.f1363a.n;
                    akVar2 = this.f1363a.w;
                    int signed2 = akVar2.a().getSignData().getSigned();
                    akVar3 = this.f1363a.w;
                    int bonusPoint2 = akVar3.a().getSignData().getBonusPoint();
                    akVar4 = this.f1363a.w;
                    ForumData a4 = akVar4.a();
                    akVar5 = this.f1363a.w;
                    bnVar5.a(signed2, bonusPoint2, a4, akVar5);
                }
            }
            if (obj != null && (obj instanceof SignData)) {
                bnVar9 = this.f1363a.n;
                if (bnVar9.e()) {
                    akVar10 = this.f1363a.w;
                    i = akVar10.a().getUser_level() + 1;
                } else {
                    i = -1;
                }
                TiebaApplication h = TiebaApplication.h();
                akVar9 = this.f1363a.w;
                h.a(akVar9.a().getName(), ((SignData) obj).getBonusPoint(), i);
            }
            if (AntiHelper.b(d) || AntiHelper.a(d) || AntiHelper.c(d)) {
                str7 = this.f1363a.f;
                d.setBlock_forum_name(str7);
                akVar6 = this.f1363a.w;
                d.setBlock_forum_id(akVar6.a().getId());
                akVar7 = this.f1363a.w;
                d.setUser_name(akVar7.c().getName());
                akVar8 = this.f1363a.w;
                d.setUser_id(akVar8.c().getId());
                AntiHelper.a(this.f1363a, d, AntiHelper.OperationType.SIGN, AntiHelper.PageType.FRS);
                return;
            }
            StringBuilder sb = new StringBuilder(100);
            bnVar6 = this.f1363a.n;
            if (!bnVar6.z()) {
                sb.append(this.f1363a.getString(R.string.sign_success));
                sb.append("!\n");
                sb.append(String.format(this.f1363a.getString(R.string.sign_user), Integer.valueOf(((SignData) obj).getUserSignRank())));
                bnVar8 = this.f1363a.n;
                bnVar8.a(sb.toString());
                return;
            }
            sb.append(this.f1363a.getString(R.string.sign_success));
            sb.append(",");
            sb.append(String.format(this.f1363a.getString(R.string.sign_point), Integer.valueOf(((SignData) obj).getBonusPoint())));
            sb.append("!\n");
            sb.append(String.format(this.f1363a.getString(R.string.sign_user), Integer.valueOf(((SignData) obj).getUserSignRank())));
            bnVar7 = this.f1363a.n;
            bnVar7.a(sb.toString());
            return;
        }
        cdVar = this.f1363a.z;
        if (cdVar.getErrorCode() == 160002) {
            str3 = this.f1363a.C;
            if (str3.equals("normal_page")) {
                bnVar4 = this.f1363a.n;
                bnVar4.f(1);
            } else {
                str4 = this.f1363a.C;
                if (str4.equals("frs_page")) {
                    bnVar3 = this.f1363a.n;
                    bnVar3.e(1);
                }
            }
        }
        bnVar2 = this.f1363a.n;
        cdVar2 = this.f1363a.z;
        bnVar2.a(cdVar2.getErrorString());
    }
}
