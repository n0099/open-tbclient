package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.frs.ea;
import com.baidu.tieba.frs.eb;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f<FrsGoodActivity> {
    private String aWj;
    private x aZG;
    private FrsGoodActivity aZX;
    private HorizontalTabView bag;
    private SparseArray<o.a> bah;
    private TabData bai;
    private int baj;
    private eb bak;

    public af(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.bah = new SparseArray<>();
        this.baj = 5;
        this.bak = new ag(this);
        this.aZX = frsGoodActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oQ() {
        this.aZG = new x(this.aZX, this.aZX.aUx);
        this.aZX.a(this.aZG);
        MU();
    }

    private void MU() {
        this.bag = (HorizontalTabView) this.aZX.findViewById(i.f.frs_good_tabview);
    }

    public void b(com.baidu.tieba.tbadkCore.o oVar) {
        ArrayList<com.baidu.tbadk.core.data.k> good_classify;
        if (oVar != null && oVar.aeN() != null && oVar.aeN().getGood_classify() != null && (good_classify = oVar.aeN().getGood_classify()) != null) {
            this.aWj = this.aZX.getPageContext().getResources().getString(i.h.forum_list_menu_all);
            this.bai = new TabData();
            com.baidu.tieba.frs.tab.g gVar = new com.baidu.tieba.frs.tab.g();
            gVar.bbr = 0;
            gVar.name = this.aWj;
            this.bai.add(gVar);
            for (com.baidu.tbadk.core.data.k kVar : good_classify) {
                if (kVar != null && kVar.rE() > 0 && !TextUtils.isEmpty(kVar.rD()) && !TextUtils.isEmpty(kVar.rD().trim())) {
                    com.baidu.tieba.frs.tab.g gVar2 = new com.baidu.tieba.frs.tab.g();
                    gVar2.bbr = kVar.rE();
                    gVar2.name = kVar.rD();
                    this.bai.add(gVar2);
                }
            }
            this.bag.setData(this.bai, this.baj);
        }
    }

    public HorizontalTabView MV() {
        return this.bag;
    }

    public void a(ea eaVar) {
        if (this.bag != null) {
            this.bag.setDataLoadInterface(eaVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bag != null) {
            this.bag.vA();
        }
    }
}
