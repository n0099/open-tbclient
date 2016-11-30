package com.baidu.tieba.frs.e;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.frs.cp;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements cf {
    final /* synthetic */ i cgA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cgA = iVar;
    }

    @Override // com.baidu.tieba.frs.cf
    public void a(int i, int i2, cp cpVar, ArrayList<v> arrayList) {
        int i3;
        cf cfVar;
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.tbadkCore.p pVar3;
        cf cfVar2;
        this.cgA.cgp = false;
        i3 = this.cgA.cgl;
        if (i == i3) {
            cfVar = this.cgA.cgu;
            if (cfVar != null) {
                this.cgA.cgo = cpVar;
                this.cgA.b(i, i2, cpVar);
                ArrayList<v> arrayList2 = new ArrayList<>();
                if (arrayList != null) {
                    arrayList2.addAll(arrayList);
                }
                pVar = this.cgA.bRX;
                pVar.aD(arrayList2);
                if ((i == 1 || i == 2 || i == 5) && !this.cgA.agD()) {
                    pVar2 = this.cgA.bRX;
                    pVar2.blb();
                    pVar3 = this.cgA.bRX;
                    pVar3.blc();
                }
                cfVar2 = this.cgA.cgu;
                cfVar2.a(i, i2, cpVar, arrayList);
            }
        }
    }
}
