package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<n>> {
    public BdUniqueId bII;
    private c.a bPd;
    private int cardShowType;
    private v egi;
    private n ejQ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bPd = null;
        this.cardShowType = 0;
        this.egi = new v<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.k kVar) {
                r.alt().dk(true);
                if (view != null && e.this.ejQ != null && e.this.ejQ.getView() != null && kVar != null && kVar.WE() != null && !StringUtils.isNull(kVar.WE().getTid())) {
                    if (view.getId() != e.this.ejQ.getView().getId()) {
                        if (e.this.ejQ.getHeaderImg() == null || view.getId() != e.this.ejQ.getHeaderImg().getId()) {
                            if (e.this.ejQ.akS() == null || view.getId() != e.this.ejQ.akS().getId()) {
                                if (e.this.ejQ.cmk == null || e.this.ejQ.cmk.getBarNameTv() == null || view.getId() != e.this.ejQ.cmk.getBarNameTv().getId()) {
                                    if (e.this.ejQ.cmX == null || e.this.ejQ.cmX.bey == null || view.getId() != e.this.ejQ.cmX.bey.getId()) {
                                        if (e.this.ejQ.akR() != null && view.getId() == e.this.ejQ.akR().getId()) {
                                            TiebaStatic.log(kVar.kC("c12202"));
                                            return;
                                        }
                                        return;
                                    }
                                    TiebaStatic.log(kVar.alM());
                                    return;
                                }
                                TiebaStatic.log(kVar.alM());
                                return;
                            }
                            TiebaStatic.log(kVar.kB("c12191"));
                            return;
                        }
                        TiebaStatic.log(kVar.kB("c12191"));
                        return;
                    }
                    TiebaStatic.log(kVar.kB("c12192"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aDb();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a<n> onCreateViewHolder(ViewGroup viewGroup) {
        this.ejQ = new n(this.mPageContext);
        this.ejQ.currentPageType = 2;
        if (this.ejQ.cmk != null) {
            this.ejQ.cmk.aQE = 2;
        }
        if (this.ejQ.cmX != null && this.ejQ.cmX.bez != null) {
            this.ejQ.cmX.bez.aQE = 2;
        }
        this.ejQ.j(this.bII);
        return new com.baidu.tieba.card.a.a<>(this.ejQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<n> aVar) {
        if (kVar == null || aVar == null || aVar.alY() == null) {
            return null;
        }
        kVar.lD(i + 1);
        r.alt().a(kVar.kA("c12190"));
        if (kVar.threadData != null) {
            kVar.threadData.aQz = this.cardShowType;
        }
        aVar.alY().a(kVar);
        aVar.alY().b(this.egi);
        aVar.alY().a(this.bPd);
        return aVar.getView();
    }

    private void aDb() {
        com.baidu.tieba.card.data.k.cZY = "c10705";
        com.baidu.tieba.card.data.k.cZZ = "c10730";
        com.baidu.tieba.card.data.k.daa = "c10731";
        com.baidu.tieba.card.data.k.dab = "c10704";
        com.baidu.tieba.card.data.k.dac = "c10755";
        com.baidu.tieba.card.data.k.dad = "c10710";
        com.baidu.tieba.card.data.k.dae = "c10736";
        com.baidu.tieba.card.data.k.daf = "c10737";
        com.baidu.tieba.card.data.k.dag = "c10711";
        com.baidu.tieba.card.data.k.dah = "c10758";
        com.baidu.tieba.card.data.k.dai = "c10757";
    }

    public void setEventCallback(c.a aVar) {
        this.bPd = aVar;
    }

    public void setCardShowType(int i) {
        this.cardShowType = i;
    }
}
