package com.baidu.tieba.im.groupActivity;

import com.baidu.tieba.im.message.bu;
import com.baidu.tieba.im.message.by;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ GroupActivityActivity a;

    private p(GroupActivityActivity groupActivityActivity) {
        this.a = groupActivityActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(GroupActivityActivity groupActivityActivity, p pVar) {
        this(groupActivityActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        q qVar;
        q qVar2;
        q qVar3;
        r rVar;
        q qVar4;
        r rVar2;
        q qVar5;
        q qVar6;
        q qVar7;
        q qVar8;
        q qVar9;
        q qVar10;
        q qVar11;
        if (sVar == null) {
            this.a.hideProgressBar();
            this.a.showToast(R.string.neterror);
        } else if (sVar.w() == -127) {
            if (!(sVar instanceof by)) {
                qVar10 = this.a.b;
                qVar11 = this.a.b;
                qVar10.c(qVar11.b());
                return;
            }
            by byVar = (by) sVar;
            qVar4 = this.a.b;
            if (qVar4.e() == byVar.o()) {
                if (!byVar.l()) {
                    rVar2 = this.a.a;
                    rVar2.a(byVar.a(), true);
                    qVar5 = this.a.b;
                    qVar5.a(byVar.a());
                    qVar6 = this.a.b;
                    qVar7 = this.a.b;
                    qVar6.c(qVar7.b());
                    return;
                }
                qVar8 = this.a.b;
                qVar9 = this.a.b;
                qVar8.c(qVar9.b());
            }
        } else if (sVar.w() == 103015) {
            this.a.hideProgressBar();
            if (!(sVar instanceof by)) {
                this.a.showToast(R.string.neterror);
                return;
            }
            by byVar2 = (by) sVar;
            qVar2 = this.a.b;
            if (qVar2.f() == byVar2.o()) {
                if (byVar2.m() == 2230504) {
                    this.a.showToast(byVar2.n(), false);
                    this.a.finish();
                } else if (!byVar2.l()) {
                    qVar3 = this.a.b;
                    qVar3.a(byVar2.a());
                    rVar = this.a.a;
                    rVar.a(byVar2.a(), false);
                } else {
                    this.a.showToast(R.string.neterror);
                }
            }
        } else if (sVar.w() == 103121) {
            this.a.hideProgressBar();
            if (!(sVar instanceof bu)) {
                this.a.showToast(R.string.neterror);
                return;
            }
            bu buVar = (bu) sVar;
            qVar = this.a.b;
            if (qVar.g() == buVar.o()) {
                if (buVar.l()) {
                    this.a.showToast(buVar.n());
                    return;
                }
                this.a.showToast(R.string.group_activity_delete_succ, false);
                this.a.finish();
            }
        }
    }
}
