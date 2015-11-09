package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f<FrsGoodActivity> {
    private String aWr;
    private x aZZ;
    private HorizontalTabView baA;
    private SparseArray<o.a> baB;
    private TabData baC;
    private int baD;
    private ed baE;
    private FrsGoodActivity baq;

    public af(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.baB = new SparseArray<>();
        this.baD = 5;
        this.baE = new ag(this);
        this.baq = frsGoodActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oR() {
        this.aZZ = new x(this.baq, this.baq.aUF);
        this.baq.a(this.aZZ);
        Ni();
    }

    private void Ni() {
        this.baA = (HorizontalTabView) this.baq.findViewById(i.f.frs_good_tabview);
    }

    public void b(com.baidu.tieba.tbadkCore.o oVar) {
        ArrayList<com.baidu.tbadk.core.data.k> good_classify;
        if (oVar != null && oVar.afg() != null && oVar.afg().getGood_classify() != null && (good_classify = oVar.afg().getGood_classify()) != null) {
            this.aWr = this.baq.getPageContext().getResources().getString(i.h.forum_list_menu_all);
            this.baC = new TabData();
            com.baidu.tieba.frs.tab.h hVar = new com.baidu.tieba.frs.tab.h();
            hVar.bbN = 0;
            hVar.name = this.aWr;
            this.baC.add(hVar);
            for (com.baidu.tbadk.core.data.k kVar : good_classify) {
                if (kVar != null && kVar.rD() > 0 && !TextUtils.isEmpty(kVar.rC()) && !TextUtils.isEmpty(kVar.rC().trim())) {
                    com.baidu.tieba.frs.tab.h hVar2 = new com.baidu.tieba.frs.tab.h();
                    hVar2.bbN = kVar.rD();
                    hVar2.name = kVar.rC();
                    this.baC.add(hVar2);
                }
            }
            this.baA.setData(this.baC, this.baD);
        }
    }

    public HorizontalTabView Nj() {
        return this.baA;
    }

    public void a(ec ecVar) {
        if (this.baA != null) {
            this.baA.setDataLoadInterface(ecVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.baA != null) {
            this.baA.vB();
        }
    }
}
