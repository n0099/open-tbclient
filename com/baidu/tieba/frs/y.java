package com.baidu.tieba.frs;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ForumData;
import com.baidu.tieba.data.SignData;
import com.baidu.tieba.model.cc;
import com.baidu.tieba.util.AntiHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.a.g {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        boolean z;
        String str;
        String str2;
        bk bkVar;
        cc ccVar;
        bk bkVar2;
        cc ccVar2;
        String str3;
        String str4;
        bk bkVar3;
        bk bkVar4;
        com.baidu.tieba.model.ak akVar;
        String str5;
        String str6;
        bk bkVar5;
        com.baidu.tieba.model.ak akVar2;
        com.baidu.tieba.model.ak akVar3;
        com.baidu.tieba.model.ak akVar4;
        com.baidu.tieba.model.ak akVar5;
        String str7;
        com.baidu.tieba.model.ak akVar6;
        com.baidu.tieba.model.ak akVar7;
        com.baidu.tieba.model.ak akVar8;
        bk bkVar6;
        bk bkVar7;
        bk bkVar8;
        bk bkVar9;
        int i;
        com.baidu.tieba.model.ak akVar9;
        com.baidu.tieba.model.ak akVar10;
        bk bkVar10;
        com.baidu.tieba.model.ak akVar11;
        com.baidu.tieba.model.ak akVar12;
        com.baidu.tieba.model.ak akVar13;
        com.baidu.tieba.model.ak akVar14;
        bk bkVar11;
        String str8;
        com.baidu.tieba.model.ak akVar15;
        if (obj == null || !(obj instanceof SignData)) {
            z = false;
        } else {
            com.baidu.tieba.model.z a = com.baidu.tieba.model.z.a();
            str8 = this.a.f;
            a.b(str8);
            akVar15 = this.a.w;
            akVar15.a((SignData) obj);
            z = true;
        }
        str = this.a.C;
        if (str.equals("normal_page")) {
            bkVar11 = this.a.n;
            bkVar11.w();
        } else {
            str2 = this.a.C;
            if (str2.equals("frs_page")) {
                bkVar = this.a.n;
                bkVar.y();
            }
        }
        if (z) {
            akVar = this.a.w;
            AntiData e = akVar.e();
            str5 = this.a.C;
            if (str5.equals("normal_page")) {
                bkVar10 = this.a.n;
                akVar11 = this.a.w;
                int signed = akVar11.b().getSignData().getSigned();
                akVar12 = this.a.w;
                int bonusPoint = akVar12.b().getSignData().getBonusPoint();
                akVar13 = this.a.w;
                ForumData b = akVar13.b();
                akVar14 = this.a.w;
                bkVar10.b(signed, bonusPoint, b, akVar14);
            } else {
                str6 = this.a.C;
                if (str6.equals("frs_page")) {
                    bkVar5 = this.a.n;
                    akVar2 = this.a.w;
                    int signed2 = akVar2.b().getSignData().getSigned();
                    akVar3 = this.a.w;
                    int bonusPoint2 = akVar3.b().getSignData().getBonusPoint();
                    akVar4 = this.a.w;
                    ForumData b2 = akVar4.b();
                    akVar5 = this.a.w;
                    bkVar5.a(signed2, bonusPoint2, b2, akVar5);
                }
            }
            if (obj != null && (obj instanceof SignData)) {
                bkVar9 = this.a.n;
                if (bkVar9.e()) {
                    akVar10 = this.a.w;
                    i = akVar10.b().getUser_level() + 1;
                } else {
                    i = -1;
                }
                TiebaApplication h = TiebaApplication.h();
                akVar9 = this.a.w;
                h.a(akVar9.b().getName(), ((SignData) obj).getBonusPoint(), i);
            }
            if (AntiHelper.b(e) || AntiHelper.a(e) || AntiHelper.c(e)) {
                str7 = this.a.f;
                e.setBlock_forum_name(str7);
                akVar6 = this.a.w;
                e.setBlock_forum_id(akVar6.b().getId());
                akVar7 = this.a.w;
                e.setUser_name(akVar7.d().getName());
                akVar8 = this.a.w;
                e.setUser_id(akVar8.d().getId());
                AntiHelper.a(this.a, e, AntiHelper.OperationType.SIGN, AntiHelper.PageType.FRS);
                return;
            }
            StringBuilder sb = new StringBuilder(100);
            bkVar6 = this.a.n;
            if (!bkVar6.A()) {
                sb.append(this.a.getString(R.string.sign_success));
                sb.append("!\n");
                sb.append(String.format(this.a.getString(R.string.sign_user), Integer.valueOf(((SignData) obj).getUserSignRank())));
                bkVar8 = this.a.n;
                bkVar8.a(sb.toString());
                return;
            }
            sb.append(this.a.getString(R.string.sign_success));
            sb.append(",");
            sb.append(String.format(this.a.getString(R.string.sign_point), Integer.valueOf(((SignData) obj).getBonusPoint())));
            sb.append("!\n");
            sb.append(String.format(this.a.getString(R.string.sign_user), Integer.valueOf(((SignData) obj).getUserSignRank())));
            bkVar7 = this.a.n;
            bkVar7.a(sb.toString());
            return;
        }
        ccVar = this.a.z;
        if (ccVar.getErrorCode() == 160002) {
            str3 = this.a.C;
            if (str3.equals("normal_page")) {
                bkVar4 = this.a.n;
                bkVar4.f(1);
            } else {
                str4 = this.a.C;
                if (str4.equals("frs_page")) {
                    bkVar3 = this.a.n;
                    bkVar3.e(1);
                }
            }
        }
        bkVar2 = this.a.n;
        ccVar2 = this.a.z;
        bkVar2.a(ccVar2.getErrorString());
    }
}
