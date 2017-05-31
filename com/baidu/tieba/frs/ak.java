package com.baidu.tieba.frs;

import com.baidu.tieba.frs.entelechy.b.b;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements bz {
    final /* synthetic */ r bVb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(r rVar) {
        this.bVb = rVar;
    }

    @Override // com.baidu.tieba.frs.bz
    public void a(int i, int i2, ch chVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        b bVar;
        bz bzVar;
        bz bzVar2;
        com.baidu.tieba.frs.f.u uVar;
        b bVar2;
        this.bVb.aag();
        bVar = this.bVb.bUt;
        if (bVar != null) {
            uVar = this.bVb.bUk;
            bVar2 = this.bVb.bUt;
            uVar.ey(bVar2.it(i));
        }
        d.a aVar = new d.a();
        if (chVar != null) {
            aVar.isSuccess = chVar.errCode == 0;
            aVar.errorCode = chVar.errCode;
            aVar.errorMsg = chVar.errMsg;
            if (aVar.isSuccess) {
                if (com.baidu.tbadk.core.util.x.r(arrayList)) {
                    this.bVb.bUa.VD();
                } else if (chVar.hasMore) {
                    this.bVb.bUa.TW();
                } else if (chVar.bXa) {
                    this.bVb.bUa.TY();
                } else {
                    this.bVb.bUa.VD();
                }
            }
        } else {
            chVar = new ch();
            chVar.pn = 1;
            chVar.hasMore = false;
            chVar.bXa = false;
        }
        if (i == 1) {
            this.bVb.bUi = true;
            this.bVb.bUP.a(this.bVb.bUj.getType(), false, aVar);
        } else {
            this.bVb.a(aVar, true);
            if (this.bVb.bUj.acK() != null) {
                this.bVb.bTF = this.bVb.bUj.acK();
            }
            this.bVb.aao();
        }
        bzVar = this.bVb.bVa;
        if (bzVar == null) {
            return;
        }
        bzVar2 = this.bVb.bVa;
        bzVar2.a(i, i2, chVar, arrayList);
    }
}
