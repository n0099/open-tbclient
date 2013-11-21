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
    final /* synthetic */ FrsActivity f1312a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FrsActivity frsActivity) {
        this.f1312a = frsActivity;
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
        com.baidu.tieba.model.ak akVar9;
        com.baidu.tieba.model.ak akVar10;
        com.baidu.tieba.model.ak akVar11;
        com.baidu.tieba.model.ak akVar12;
        bn bnVar10;
        String str8;
        com.baidu.tieba.model.ak akVar13;
        com.baidu.tieba.model.ak akVar14;
        if (obj == null || !(obj instanceof SignData)) {
            z = false;
        } else {
            SignData signData = (SignData) obj;
            com.baidu.tieba.model.z a2 = com.baidu.tieba.model.z.a();
            str8 = this.f1312a.f;
            a2.b(str8);
            akVar13 = this.f1312a.w;
            akVar13.a(signData);
            TiebaApplication g = TiebaApplication.g();
            akVar14 = this.f1312a.w;
            g.a(akVar14.a().getName(), signData.getBonusPoint());
            z = true;
        }
        str = this.f1312a.C;
        if (str.equals("normal_page")) {
            bnVar10 = this.f1312a.n;
            bnVar10.u();
        } else {
            str2 = this.f1312a.C;
            if (str2.equals("frs_page")) {
                bnVar = this.f1312a.n;
                bnVar.w();
            }
        }
        if (z) {
            akVar = this.f1312a.w;
            AntiData d = akVar.d();
            str5 = this.f1312a.C;
            if (str5.equals("normal_page")) {
                bnVar9 = this.f1312a.n;
                akVar9 = this.f1312a.w;
                int signed = akVar9.a().getSignData().getSigned();
                akVar10 = this.f1312a.w;
                int bonusPoint = akVar10.a().getSignData().getBonusPoint();
                akVar11 = this.f1312a.w;
                ForumData a3 = akVar11.a();
                akVar12 = this.f1312a.w;
                bnVar9.b(signed, bonusPoint, a3, akVar12);
            } else {
                str6 = this.f1312a.C;
                if (str6.equals("frs_page")) {
                    bnVar5 = this.f1312a.n;
                    akVar2 = this.f1312a.w;
                    int signed2 = akVar2.a().getSignData().getSigned();
                    akVar3 = this.f1312a.w;
                    int bonusPoint2 = akVar3.a().getSignData().getBonusPoint();
                    akVar4 = this.f1312a.w;
                    ForumData a4 = akVar4.a();
                    akVar5 = this.f1312a.w;
                    bnVar5.a(signed2, bonusPoint2, a4, akVar5);
                }
            }
            if (AntiHelper.b(d) || AntiHelper.a(d) || AntiHelper.c(d)) {
                str7 = this.f1312a.f;
                d.setBlock_forum_name(str7);
                akVar6 = this.f1312a.w;
                d.setBlock_forum_id(akVar6.a().getId());
                akVar7 = this.f1312a.w;
                d.setUser_name(akVar7.c().getName());
                akVar8 = this.f1312a.w;
                d.setUser_id(akVar8.c().getId());
                AntiHelper.a(this.f1312a, d, AntiHelper.OperationType.SIGN, AntiHelper.PageType.FRS);
                return;
            }
            StringBuilder sb = new StringBuilder(100);
            bnVar6 = this.f1312a.n;
            if (!bnVar6.y()) {
                sb.append(this.f1312a.getString(R.string.sign_success));
                sb.append("!\n");
                sb.append(String.format(this.f1312a.getString(R.string.sign_user), Integer.valueOf(((SignData) obj).getUserSignRank())));
                bnVar8 = this.f1312a.n;
                bnVar8.a(sb.toString());
                return;
            }
            sb.append(this.f1312a.getString(R.string.sign_success));
            sb.append(",");
            sb.append(String.format(this.f1312a.getString(R.string.sign_point), Integer.valueOf(((SignData) obj).getBonusPoint())));
            sb.append("!\n");
            sb.append(String.format(this.f1312a.getString(R.string.sign_user), Integer.valueOf(((SignData) obj).getUserSignRank())));
            bnVar7 = this.f1312a.n;
            bnVar7.a(sb.toString());
            return;
        }
        cdVar = this.f1312a.z;
        if (cdVar.getErrorCode() == 160002) {
            str3 = this.f1312a.C;
            if (str3.equals("normal_page")) {
                bnVar4 = this.f1312a.n;
                bnVar4.f(1);
            } else {
                str4 = this.f1312a.C;
                if (str4.equals("frs_page")) {
                    bnVar3 = this.f1312a.n;
                    bnVar3.e(1);
                }
            }
        }
        bnVar2 = this.f1312a.n;
        cdVar2 = this.f1312a.z;
        bnVar2.a(cdVar2.getErrorString());
    }
}
