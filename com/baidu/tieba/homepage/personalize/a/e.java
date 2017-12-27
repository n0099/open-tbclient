package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.widget.ListView.a<l, com.baidu.tieba.card.a.a<o>> {
    public BdUniqueId bGo;
    private c.a bMG;
    private v ear;
    private o edV;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.bMG = null;
        this.ear = new v<l>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, l lVar) {
                s.ajC().df(true);
                if (view != null && e.this.edV != null && e.this.edV.getView() != null && lVar != null && lVar.VW() != null && !StringUtils.isNull(lVar.VW().getTid())) {
                    if (view.getId() != e.this.edV.getView().getId()) {
                        if (e.this.edV.getHeaderImg() == null || view.getId() != e.this.edV.getHeaderImg().getId()) {
                            if (e.this.edV.ajb() == null || view.getId() != e.this.edV.ajb().getId()) {
                                if (e.this.edV.ciE == null || e.this.edV.ciE.getBarNameTv() == null || view.getId() != e.this.edV.ciE.getBarNameTv().getId()) {
                                    if (e.this.edV.aja() != null && view.getId() == e.this.edV.aja().getId()) {
                                        TiebaStatic.log(lVar.kf("c12202"));
                                        return;
                                    }
                                    return;
                                }
                                TiebaStatic.log(lVar.ajV());
                                return;
                            }
                            TiebaStatic.log(lVar.ke("c12191"));
                            return;
                        }
                        TiebaStatic.log(lVar.ke("c12191"));
                        return;
                    }
                    TiebaStatic.log(lVar.ke("c12192"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        aBx();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<o> onCreateViewHolder(ViewGroup viewGroup) {
        this.edV = new o(this.mPageContext);
        this.edV.currentPageType = 2;
        if (this.edV.ciE != null) {
            this.edV.ciE.bbP = 2;
        }
        this.edV.j(this.bGo);
        return new com.baidu.tieba.card.a.a<>(this.edV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<o> aVar) {
        if (lVar == null || aVar == null || aVar.akh() == null) {
            return null;
        }
        lVar.lE(i + 1);
        s.ajC().a(lVar.kd("c12190"));
        aVar.akh().a(lVar);
        aVar.akh().b(this.ear);
        aVar.akh().a(this.bMG);
        return aVar.getView();
    }

    private void aBx() {
        l.cSo = "c10705";
        l.cSp = "c10730";
        l.cSq = "c10731";
        l.cSr = "c10704";
        l.cSs = "c10755";
        l.cSt = "c10710";
        l.cSu = "c10736";
        l.cSv = "c10737";
        l.cSw = "c10711";
        l.cSx = "c10758";
        l.cSy = "c10757";
    }

    public void setEventCallback(c.a aVar) {
        this.bMG = aVar;
    }
}
