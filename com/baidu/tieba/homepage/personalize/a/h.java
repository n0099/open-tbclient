package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.v;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<l, com.baidu.tieba.card.a.a<t>> {
    public BdUniqueId aSv;
    private c.a aYN;
    private l bZe;
    private t cNT;
    private v dmZ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYN = null;
        this.dmZ = new v<be>() { // from class: com.baidu.tieba.homepage.personalize.a.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                l lVar = h.this.bZe;
                s.abU().cB(true);
                if (view != null && h.this.cNT != null && h.this.cNT.getView() != null && lVar != null && lVar.Ox() != null && !StringUtils.isNull(lVar.Ox().getTid())) {
                    if (view.getId() != h.this.cNT.getView().getId()) {
                        if (h.this.cNT.getHeaderImg() == null || view.getId() != h.this.cNT.getHeaderImg().getId()) {
                            if (h.this.cNT.abv() != null && view.getId() == h.this.cNT.abv().getId()) {
                                TiebaStatic.log(lVar.ach());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(lVar.ach());
                        return;
                    }
                    TiebaStatic.log(lVar.kd("c12642"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aul();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.card.a.a<t> onCreateViewHolder(ViewGroup viewGroup) {
        this.cNT = new t(this.mPageContext);
        this.cNT.currentPageType = 2;
        if (this.cNT.bvH != null) {
            this.cNT.bvH.anM = 2;
        }
        if (this.cNT.cci != null) {
            this.cNT.cci.ccL = 2;
        }
        this.cNT.k(this.aSv);
        this.cNT.b(this.dmZ);
        return new com.baidu.tieba.card.a.a<>(this.cNT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<t> aVar) {
        if (lVar == null || lVar.Ox() == null || aVar == null || aVar.acs() == null) {
            return null;
        }
        this.bZe = lVar;
        lVar.iE(i + 1);
        s.abU().a(lVar.kc("c12641"));
        if (lVar.XE != null && lVar.XE.size() > 0) {
            lVar.Ox().a(lVar.XE);
        }
        be beVar = new be(lVar.Ox());
        beVar.stType = "personalize_page";
        beVar.aaL = 1;
        beVar.aaM = 3;
        aVar.acs().a(this.aYN);
        aVar.acs().a(beVar);
        return aVar.getView();
    }

    private void aul() {
        l.cds = "c10705";
        l.cdt = "c10730";
        l.cdu = "c10731";
        l.cdv = "c10704";
        l.cdw = "c10755";
        l.cdx = "c10710";
        l.cdy = "c10736";
        l.cdz = "c10737";
        l.cdA = "c10711";
        l.cdB = "c10758";
        l.cdC = "c10757";
    }

    public void setEventCallback(c.a aVar) {
        this.aYN = aVar;
    }
}
