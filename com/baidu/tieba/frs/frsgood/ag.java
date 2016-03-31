package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.tieba.frs.c.o;
import com.baidu.tieba.frs.fo;
import com.baidu.tieba.frs.fp;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.base.f<FrsGoodActivity> {
    private String bnG;
    private HorizontalTabView bsD;
    private SparseArray<o.a> bsE;
    private TabData bsF;
    private int bsG;
    private fp bsH;
    private y bsd;
    private FrsGoodActivity bsu;

    public ag(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.bsE = new SparseArray<>();
        this.bsG = 5;
        this.bsH = new ah(this);
        this.bsu = frsGoodActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oJ() {
        this.bsd = new y(this.bsu, this.bsu.bkV);
        this.bsu.a(this.bsd);
        SS();
    }

    private void SS() {
        this.bsD = (HorizontalTabView) this.bsu.findViewById(t.g.frs_good_tabview);
    }

    public void c(com.baidu.tieba.tbadkCore.o oVar) {
        ArrayList<com.baidu.tbadk.core.data.t> good_classify;
        if (oVar != null && oVar.avu() != null && oVar.avu().getGood_classify() != null && (good_classify = oVar.avu().getGood_classify()) != null) {
            this.bnG = this.bsu.getPageContext().getResources().getString(t.j.forum_list_menu_all);
            this.bsF = new TabData();
            com.baidu.tieba.frs.tab.h hVar = new com.baidu.tieba.frs.tab.h();
            hVar.btZ = 0;
            hVar.name = this.bnG;
            this.bsF.add(hVar);
            for (com.baidu.tbadk.core.data.t tVar : good_classify) {
                if (tVar != null && tVar.rR() > 0 && !TextUtils.isEmpty(tVar.rQ()) && !TextUtils.isEmpty(tVar.rQ().trim())) {
                    com.baidu.tieba.frs.tab.h hVar2 = new com.baidu.tieba.frs.tab.h();
                    hVar2.btZ = tVar.rR();
                    hVar2.name = tVar.rQ();
                    this.bsF.add(hVar2);
                }
            }
            this.bsD.c(this.bsF, 0, this.bsG);
        }
    }

    public HorizontalTabView ST() {
        return this.bsD;
    }

    public void a(fo foVar) {
        if (this.bsD != null) {
            this.bsD.setDataLoadInterface(foVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bsD != null) {
            this.bsD.xy();
        }
    }
}
