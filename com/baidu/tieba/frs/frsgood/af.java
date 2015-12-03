package com.baidu.tieba.frs.frsgood;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.frs.et;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f<FrsGoodActivity> {
    private String bcm;
    private FrsGoodActivity bgJ;
    private HorizontalTabView bgS;
    private SparseArray<o.a> bgT;
    private TabData bgU;
    private int bgV;
    private eu bgW;
    private x bgr;

    public af(FrsGoodActivity frsGoodActivity) {
        super(frsGoodActivity.getPageContext());
        this.bgT = new SparseArray<>();
        this.bgV = 5;
        this.bgW = new ag(this);
        this.bgJ = frsGoodActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oX() {
        this.bgr = new x(this.bgJ, this.bgJ.aZT);
        this.bgJ.a(this.bgr);
        OK();
    }

    private void OK() {
        this.bgS = (HorizontalTabView) this.bgJ.findViewById(n.f.frs_good_tabview);
    }

    public void c(com.baidu.tieba.tbadkCore.p pVar) {
        ArrayList<com.baidu.tbadk.core.data.m> good_classify;
        if (pVar != null && pVar.ajy() != null && pVar.ajy().getGood_classify() != null && (good_classify = pVar.ajy().getGood_classify()) != null) {
            this.bcm = this.bgJ.getPageContext().getResources().getString(n.i.forum_list_menu_all);
            this.bgU = new TabData();
            com.baidu.tieba.frs.tab.h hVar = new com.baidu.tieba.frs.tab.h();
            hVar.bis = 0;
            hVar.name = this.bcm;
            this.bgU.add(hVar);
            for (com.baidu.tbadk.core.data.m mVar : good_classify) {
                if (mVar != null && mVar.rY() > 0 && !TextUtils.isEmpty(mVar.rX()) && !TextUtils.isEmpty(mVar.rX().trim())) {
                    com.baidu.tieba.frs.tab.h hVar2 = new com.baidu.tieba.frs.tab.h();
                    hVar2.bis = mVar.rY();
                    hVar2.name = mVar.rX();
                    this.bgU.add(hVar2);
                }
            }
            this.bgS.setData(this.bgU, this.bgV);
        }
    }

    public HorizontalTabView OL() {
        return this.bgS;
    }

    public void a(et etVar) {
        if (this.bgS != null) {
            this.bgS.setDataLoadInterface(etVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.bgS != null) {
            this.bgS.wh();
        }
    }
}
