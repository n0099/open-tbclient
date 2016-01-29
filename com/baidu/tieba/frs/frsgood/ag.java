package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.tieba.frs.c.o;
import com.baidu.tieba.frs.fe;
import com.baidu.tieba.frs.ff;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.base.f<FrsGoodActivity> {
    private String biW;
    private HorizontalTabView bnG;
    private SparseArray<o.a> bnH;
    private TabData bnI;
    private int bnJ;
    private ff bnK;
    private y bng;
    private FrsGoodActivity bnx;

    public ag(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.bnH = new SparseArray<>();
        this.bnJ = 5;
        this.bnK = new ah(this);
        this.bnx = frsGoodActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oQ() {
        this.bng = new y(this.bnx, this.bnx.bgj);
        this.bnx.a(this.bng);
        Rf();
    }

    private void Rf() {
        this.bnG = (HorizontalTabView) this.bnx.findViewById(t.g.frs_good_tabview);
    }

    public void c(com.baidu.tieba.tbadkCore.o oVar) {
        ArrayList<com.baidu.tbadk.core.data.p> good_classify;
        if (oVar != null && oVar.aoE() != null && oVar.aoE().getGood_classify() != null && (good_classify = oVar.aoE().getGood_classify()) != null) {
            this.biW = this.bnx.getPageContext().getResources().getString(t.j.forum_list_menu_all);
            this.bnI = new TabData();
            com.baidu.tieba.frs.tab.h hVar = new com.baidu.tieba.frs.tab.h();
            hVar.boX = 0;
            hVar.name = this.biW;
            this.bnI.add(hVar);
            for (com.baidu.tbadk.core.data.p pVar : good_classify) {
                if (pVar != null && pVar.sl() > 0 && !TextUtils.isEmpty(pVar.sk()) && !TextUtils.isEmpty(pVar.sk().trim())) {
                    com.baidu.tieba.frs.tab.h hVar2 = new com.baidu.tieba.frs.tab.h();
                    hVar2.boX = pVar.sl();
                    hVar2.name = pVar.sk();
                    this.bnI.add(hVar2);
                }
            }
            this.bnG.d(this.bnI, this.bnJ);
        }
    }

    public HorizontalTabView Rg() {
        return this.bnG;
    }

    public void a(fe feVar) {
        if (this.bnG != null) {
            this.bnG.setDataLoadInterface(feVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bnG != null) {
            this.bnG.xf();
        }
    }
}
