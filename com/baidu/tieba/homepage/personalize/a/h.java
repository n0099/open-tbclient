package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class h extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, com.baidu.tieba.card.a.a<s>> {
    public BdUniqueId bII;
    private c.a bPd;
    private com.baidu.tieba.card.data.k cVI;
    private int cardShowType;
    private s dLf;
    private v egi;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bPd = null;
        this.cardShowType = 0;
        this.egi = new v<be>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                com.baidu.tieba.card.data.k kVar = h.this.cVI;
                r.alt().dk(true);
                if (view != null && h.this.dLf != null && h.this.dLf.getView() != null && kVar != null && kVar.WE() != null && !StringUtils.isNull(kVar.WE().getTid())) {
                    if (view.getId() != h.this.dLf.getView().getId()) {
                        if (h.this.dLf.getHeaderImg() == null || view.getId() != h.this.dLf.getHeaderImg().getId()) {
                            if (h.this.dLf.akS() == null || view.getId() != h.this.dLf.akS().getId()) {
                                if (h.this.dLf.cmX != null && h.this.dLf.cmX.bey != null && view.getId() == h.this.dLf.cmX.bey.getId()) {
                                    TiebaStatic.log(kVar.alM());
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(kVar.alN());
                            return;
                        }
                        TiebaStatic.log(kVar.alN());
                        return;
                    }
                    TiebaStatic.log(kVar.kE("c12642"));
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
    public com.baidu.tieba.card.a.a<s> onCreateViewHolder(ViewGroup viewGroup) {
        this.dLf = new s(this.mPageContext);
        this.dLf.currentPageType = 2;
        if (this.dLf.cmk != null) {
            this.dLf.cmk.aQE = 2;
        }
        if (this.dLf.cmX != null && this.dLf.cmX.bez != null) {
            this.dLf.cmX.bez.aQE = 2;
        }
        if (this.dLf.cYC != null) {
            this.dLf.cYC.cZh = 2;
        }
        this.dLf.j(this.bII);
        this.dLf.b(this.egi);
        return new com.baidu.tieba.card.a.a<>(this.dLf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, com.baidu.tieba.card.a.a<s> aVar) {
        if (kVar == null || kVar.WE() == null || aVar == null || aVar.alY() == null) {
            return null;
        }
        this.cVI = kVar;
        kVar.lD(i + 1);
        r.alt().a(kVar.kD("c12641"));
        if (kVar.aNr != null && kVar.aNr.size() > 0) {
            kVar.WE().a(kVar.aNr);
        }
        be beVar = new be(kVar.WE());
        beVar.stType = "personalize_page";
        beVar.aQC = 1;
        beVar.aQD = 3;
        aVar.alY().a(this.bPd);
        beVar.threadData.aQz = this.cardShowType;
        aVar.alY().a(beVar);
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
