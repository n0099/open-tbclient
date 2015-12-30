package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ev;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f<FrsGoodActivity> {
    private String bgl;
    private FrsGoodActivity bkA;
    private HorizontalTabView bkJ;
    private SparseArray<o.a> bkK;
    private TabData bkL;
    private int bkM;
    private ev bkN;
    private x bkj;

    public af(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.bkK = new SparseArray<>();
        this.bkM = 5;
        this.bkN = new ag(this);
        this.bkA = frsGoodActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ov() {
        this.bkj = new x(this.bkA, this.bkA.bdQ);
        this.bkA.a(this.bkj);
        Pc();
    }

    private void Pc() {
        this.bkJ = (HorizontalTabView) this.bkA.findViewById(n.g.frs_good_tabview);
    }

    public void c(com.baidu.tieba.tbadkCore.p pVar) {
        ArrayList<com.baidu.tbadk.core.data.m> good_classify;
        if (pVar != null && pVar.akG() != null && pVar.akG().getGood_classify() != null && (good_classify = pVar.akG().getGood_classify()) != null) {
            this.bgl = this.bkA.getPageContext().getResources().getString(n.j.forum_list_menu_all);
            this.bkL = new TabData();
            com.baidu.tieba.frs.tab.h hVar = new com.baidu.tieba.frs.tab.h();
            hVar.bmi = 0;
            hVar.name = this.bgl;
            this.bkL.add(hVar);
            for (com.baidu.tbadk.core.data.m mVar : good_classify) {
                if (mVar != null && mVar.rH() > 0 && !TextUtils.isEmpty(mVar.rG()) && !TextUtils.isEmpty(mVar.rG().trim())) {
                    com.baidu.tieba.frs.tab.h hVar2 = new com.baidu.tieba.frs.tab.h();
                    hVar2.bmi = mVar.rH();
                    hVar2.name = mVar.rG();
                    this.bkL.add(hVar2);
                }
            }
            this.bkJ.setData(this.bkL, this.bkM);
        }
    }

    public HorizontalTabView Pd() {
        return this.bkJ;
    }

    public void a(eu euVar) {
        if (this.bkJ != null) {
            this.bkJ.setDataLoadInterface(euVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bkJ != null) {
            this.bkJ.vR();
        }
    }
}
