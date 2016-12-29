package com.baidu.tieba.frs;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.data.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
class af implements com.baidu.tieba.tbadkCore.q {
    final /* synthetic */ FrsActivity bzl;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FrsActivity frsActivity) {
        this.bzl = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public void hc(int i) {
        this.startTime = System.nanoTime();
        if (this.bzl.byg != null) {
            switch (i) {
                case 1:
                case 2:
                    this.bzl.byg.Xj();
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public void a(int i, boolean z, d.a aVar) {
        boolean z2;
        com.baidu.tieba.frs.h.ab abVar;
        com.baidu.tieba.frs.d.h hVar;
        f fVar;
        com.baidu.tieba.frs.d.h hVar2;
        boolean z3;
        com.baidu.tieba.frs.h.ab abVar2;
        boolean z4;
        z2 = this.bzl.byD;
        if (z2) {
            this.bzl.byD = false;
            com.baidu.tieba.frs.utils.s.a(this.bzl.byg, this.bzl.byh, this.bzl.getForumId(), false, null);
        }
        if (this.bzl.byg.Xc() != null) {
            z4 = this.bzl.mIsLogin;
            if (z4) {
                this.bzl.byg.Xc().setVisibility(0);
            }
        }
        abVar = this.bzl.byu;
        if (abVar != null) {
            z3 = this.bzl.mIsLogin;
            if (z3) {
                abVar2 = this.bzl.byu;
                abVar2.dS(true);
            }
        }
        this.bzl.Wr();
        this.bzl.bym = true;
        if (aVar != null && aVar.isSuccess) {
            this.bzl.byg.Xu().dO(com.baidu.tbadk.core.util.aw.vm().vo());
            FrsActivity.byj = 0L;
            FrsActivity.byk = 0L;
            FrsActivity.byl = 0;
        } else {
            FrsActivity.byl = 1;
        }
        if (!this.bzl.byr.aaZ() && (i == 3 || i == 6)) {
            hVar2 = this.bzl.byL;
            hVar2.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.bzl.byr.ZZ() != null) {
            this.bzl.byh = this.bzl.byr.ZZ();
        }
        if (i != 7) {
            if (this.bzl.byh.getPage() != null) {
                this.bzl.setHasMore(this.bzl.byh.getPage().qE());
            }
            this.bzl.Ws();
            this.bzl.byg.XM();
            if (i != 4) {
                switch (i) {
                    case 1:
                        this.bzl.byg.Xj();
                        break;
                    case 2:
                        this.bzl.byg.Xj();
                        break;
                    case 3:
                    case 6:
                        if (this.bzl.byh != null) {
                            this.bzl.byh.beN();
                        }
                        if (this.bzl.byP != null) {
                            this.bzl.byP.refresh();
                            break;
                        }
                        break;
                }
                this.bzl.Wt();
                if (aVar == null || aVar.errorCode == 0) {
                    if (this.bzl.byh != null) {
                        this.bzl.byg.hf(i);
                        this.bzl.n(false, i == 5);
                        FrsActivity.byj = (System.nanoTime() - this.startTime) / 1000000;
                        if (aVar != null) {
                            FrsActivity.byk = aVar.fdp;
                        }
                    } else {
                        return;
                    }
                } else if (this.bzl.byh == null || com.baidu.tbadk.core.util.x.t(this.bzl.byh.getThreadList())) {
                    this.bzl.a(aVar, false);
                } else if (aVar.fdo) {
                    this.bzl.showToast(this.bzl.getPageContext().getResources().getString(r.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                }
                if (this.bzl.byh.bdX() == 1) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11384"));
                }
                if (this.bzl.bpV > -1) {
                    com.baidu.tieba.frs.utils.s.a(this.bzl.byr, this.bzl.bpV);
                    this.bzl.bpV = -1L;
                }
                this.bzl.aCf = System.currentTimeMillis() - currentTimeMillis;
                System.gc();
                return;
            }
            if (!this.bzl.byr.aaZ() && TbadkCoreApplication.m9getInst().isRecAppExist() && this.bzl.byr.aaO() == 1) {
                this.bzl.byh.bp(this.bzl.getPageContext().getPageActivity());
            }
            hVar = this.bzl.byL;
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = this.bzl.byh.getThreadList();
            fVar = this.bzl.byd;
            ArrayList<com.baidu.adp.widget.ListView.v> a = hVar.a(false, false, threadList, fVar);
            if (a != null) {
                this.bzl.byh.at(a);
                this.bzl.byh.beO();
                this.bzl.byg.a(a, this.bzl.byh);
            }
            if (this.bzl.byr != null) {
                com.baidu.tieba.frs.g.b.a(this.bzl.byh, this.bzl.byr.aaU(), 2);
                return;
            }
            return;
        }
        this.bzl.ha(this.bzl.byh.bet());
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public void b(com.baidu.tieba.tbadkCore.m mVar) {
        if (mVar != null) {
            if (!"normal_page".equals(this.bzl.byr.aaK()) && !"frs_page".equals(this.bzl.byr.aaK()) && !"book_page".equals(this.bzl.byr.aaK())) {
                return;
            }
            this.bzl.a(mVar);
        }
    }
}
