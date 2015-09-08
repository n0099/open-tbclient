package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.tieba.frs.c.n;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.di;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f<FrsGoodActivity> {
    private String aWF;
    private x aZC;
    private FrsGoodActivity aZT;
    private HorizontalTabView bac;
    private SparseArray<n.a> bad;
    private TabData bae;
    private int baf;
    private di bag;

    public af(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.bad = new SparseArray<>();
        this.baf = 5;
        this.bag = new ag(this);
        this.aZT = frsGoodActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oP() {
        this.aZC = new x(this.aZT, this.aZT.aVm);
        this.aZT.a(this.aZC);
        MV();
    }

    private void MV() {
        this.bac = (HorizontalTabView) this.aZT.findViewById(i.f.frs_good_tabview);
    }

    public void b(com.baidu.tieba.tbadkCore.o oVar) {
        ArrayList<com.baidu.tbadk.core.data.k> good_classify;
        if (oVar != null && oVar.acP() != null && oVar.acP().getGood_classify() != null && (good_classify = oVar.acP().getGood_classify()) != null) {
            this.aWF = this.aZT.getPageContext().getResources().getString(i.h.forum_list_menu_all);
            this.bae = new TabData();
            com.baidu.tieba.frs.tab.g gVar = new com.baidu.tieba.frs.tab.g();
            gVar.bbn = 0;
            gVar.name = this.aWF;
            this.bae.add(gVar);
            for (com.baidu.tbadk.core.data.k kVar : good_classify) {
                if (kVar != null && kVar.rJ() > 0 && !TextUtils.isEmpty(kVar.rI()) && !TextUtils.isEmpty(kVar.rI().trim())) {
                    com.baidu.tieba.frs.tab.g gVar2 = new com.baidu.tieba.frs.tab.g();
                    gVar2.bbn = kVar.rJ();
                    gVar2.name = kVar.rI();
                    this.bae.add(gVar2);
                }
            }
            this.bac.setData(this.bae, this.baf);
        }
    }

    public HorizontalTabView MW() {
        return this.bac;
    }

    public void a(dh dhVar) {
        if (this.bac != null) {
            this.bac.setDataLoadInterface(dhVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bac != null) {
            this.bac.vI();
        }
    }
}
