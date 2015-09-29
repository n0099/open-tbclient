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
    private String aVY;
    private FrsGoodActivity aZM;
    private HorizontalTabView aZV;
    private SparseArray<o.a> aZW;
    private TabData aZX;
    private int aZY;
    private eb aZZ;
    private x aZv;

    public af(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.aZW = new SparseArray<>();
        this.aZY = 5;
        this.aZZ = new ag(this);
        this.aZM = frsGoodActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oQ() {
        this.aZv = new x(this.aZM, this.aZM.aUm);
        this.aZM.a(this.aZv);
        MU();
    }

    private void MU() {
        this.aZV = (HorizontalTabView) this.aZM.findViewById(i.f.frs_good_tabview);
    }

    public void b(com.baidu.tieba.tbadkCore.o oVar) {
        ArrayList<com.baidu.tbadk.core.data.j> good_classify;
        if (oVar != null && oVar.aeN() != null && oVar.aeN().getGood_classify() != null && (good_classify = oVar.aeN().getGood_classify()) != null) {
            this.aVY = this.aZM.getPageContext().getResources().getString(i.h.forum_list_menu_all);
            this.aZX = new TabData();
            com.baidu.tieba.frs.tab.g gVar = new com.baidu.tieba.frs.tab.g();
            gVar.bbg = 0;
            gVar.name = this.aVY;
            this.aZX.add(gVar);
            for (com.baidu.tbadk.core.data.j jVar : good_classify) {
                if (jVar != null && jVar.rE() > 0 && !TextUtils.isEmpty(jVar.rD()) && !TextUtils.isEmpty(jVar.rD().trim())) {
                    com.baidu.tieba.frs.tab.g gVar2 = new com.baidu.tieba.frs.tab.g();
                    gVar2.bbg = jVar.rE();
                    gVar2.name = jVar.rD();
                    this.aZX.add(gVar2);
                }
            }
            this.aZV.setData(this.aZX, this.aZY);
        }
    }

    public HorizontalTabView MV() {
        return this.aZV;
    }

    public void a(ea eaVar) {
        if (this.aZV != null) {
            this.aZV.setDataLoadInterface(eaVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aZV != null) {
            this.aZV.vA();
        }
    }
}
