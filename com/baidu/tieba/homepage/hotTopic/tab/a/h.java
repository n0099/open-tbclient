package com.baidu.tieba.homepage.hotTopic.tab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class h {
    private List<com.baidu.adp.widget.ListView.a> bky;
    private v imM;
    private g jBC;
    private l jBD;
    private b jBE;
    private d jBF;
    private c jBG;
    private e jBH;
    private f jBI;
    private TbPageContext mPageContext;

    public h(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.imM = vVar;
        LY();
    }

    private void LY() {
        this.bky = new ArrayList();
        this.bky.add(new j(this.mPageContext));
        this.bky.add(new k(this.mPageContext));
        this.bky.add(new i(this.mPageContext));
        this.bky.add(new w(this.mPageContext));
        this.jBC = new g(this.mPageContext);
        this.jBC.a(this.imM);
        this.bky.add(this.jBC);
        this.jBD = new l(this.mPageContext);
        this.jBD.a(this.imM);
        this.bky.add(this.jBD);
        this.jBE = new b(this.mPageContext);
        this.jBE.a(this.imM);
        this.bky.add(this.jBE);
        this.jBF = new d(this.mPageContext);
        this.jBF.a(this.imM);
        this.bky.add(this.jBF);
        this.jBG = new c(this.mPageContext);
        this.jBG.a(this.imM);
        this.bky.add(this.jBG);
        this.jBH = new e(this.mPageContext);
        this.jBH.a(this.imM);
        this.bky.add(this.jBH);
        this.jBI = new f(this.mPageContext);
        this.jBI.a(this.imM);
        this.bky.add(this.jBI);
        this.imM.addAdapters(this.bky);
    }

    public void notifyDataSetChanged() {
        if (this.imM != null) {
            this.imM.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.imM.setData(list);
    }

    public List<q> getData() {
        return this.imM.getData();
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
            aVar.setPageId(bdUniqueId);
        }
    }

    public void setOnItemCoverListener(com.baidu.tbadk.h.f fVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
            if (aVar instanceof a) {
                ((a) aVar).setOnItemCoverListener(fVar);
            }
        }
    }
}
