package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.tieba.frs.c.n;
import com.baidu.tieba.frs.db;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f<FrsGoodActivity> {
    private String aWo;
    private FrsGoodActivity aZA;
    private HorizontalTabView aZK;
    private SparseArray<n.a> aZL;
    private TabData aZM;
    private int aZN;
    private dc aZO;
    private x aZj;

    public af(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.aZL = new SparseArray<>();
        this.aZN = 5;
        this.aZO = new ag(this);
        this.aZA = frsGoodActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oS() {
        this.aZj = new x(this.aZA, this.aZA.aUY);
        this.aZA.a(this.aZj);
        MV();
    }

    private void MV() {
        this.aZK = (HorizontalTabView) this.aZA.findViewById(i.f.frs_good_tabview);
    }

    public void c(com.baidu.tieba.tbadkCore.n nVar) {
        ArrayList<com.baidu.tbadk.core.data.k> good_classify;
        if (nVar != null && nVar.acG() != null && nVar.acG().getGood_classify() != null && (good_classify = nVar.acG().getGood_classify()) != null) {
            this.aWo = this.aZA.getPageContext().getResources().getString(i.C0057i.forum_list_menu_all);
            this.aZM = new TabData();
            com.baidu.tieba.frs.tab.g gVar = new com.baidu.tieba.frs.tab.g();
            gVar.baT = 0;
            gVar.name = this.aWo;
            this.aZM.add(gVar);
            for (com.baidu.tbadk.core.data.k kVar : good_classify) {
                if (kVar != null && kVar.rK() > 0 && !TextUtils.isEmpty(kVar.rJ()) && !TextUtils.isEmpty(kVar.rJ().trim())) {
                    com.baidu.tieba.frs.tab.g gVar2 = new com.baidu.tieba.frs.tab.g();
                    gVar2.baT = kVar.rK();
                    gVar2.name = kVar.rJ();
                    this.aZM.add(gVar2);
                }
            }
            this.aZK.setData(this.aZM, this.aZN);
        }
    }

    public HorizontalTabView MW() {
        return this.aZK;
    }

    public void a(db dbVar) {
        if (this.aZK != null) {
            this.aZK.setDataLoadInterface(dbVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aZK != null) {
            this.aZK.vD();
        }
    }
}
