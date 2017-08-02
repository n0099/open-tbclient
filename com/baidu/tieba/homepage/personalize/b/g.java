package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<r>> {
    public BdUniqueId aNy;
    private h.a akI;
    private TbPageContext<?> ako;
    private x cOT;
    private r cSv;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akI = null;
        this.cOT = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.b.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.Ww().cA(true);
                if (view != null && g.this.cSv != null && g.this.cSv.getView() != null && lVar != null && lVar.MA() != null && !StringUtils.isNull(lVar.MA().getTid())) {
                    if (view.getId() != g.this.cSv.getView().getId()) {
                        if (g.this.cSv.getHeaderImg() == null || view.getId() != g.this.cSv.getHeaderImg().getId()) {
                            if (g.this.cSv.Wc() == null || view.getId() != g.this.cSv.Wc().getId()) {
                                if (g.this.cSv.bjP == null || g.this.cSv.bjP.getBarNameTv() == null || view.getId() != g.this.cSv.bjP.getBarNameTv().getId()) {
                                    if (g.this.cSv.Wb() != null && view.getId() == g.this.cSv.Wb().getId()) {
                                        TiebaStatic.log(lVar.ji("c12202"));
                                        return;
                                    }
                                    return;
                                }
                                TiebaStatic.log(lVar.WL());
                                return;
                            }
                            TiebaStatic.log(lVar.jh("c12191"));
                            return;
                        }
                        TiebaStatic.log(lVar.jh("c12191"));
                        return;
                    }
                    TiebaStatic.log(lVar.jh("c12192"));
                }
            }
        };
        this.ako = tbPageContext;
        aov();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: w */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.cSv = new r(this.ako);
        this.cSv.j(this.aNy);
        return new com.baidu.tieba.card.a.a<>(this.cSv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (lVar == null || aVar == null || aVar.WX() == null) {
            return null;
        }
        lVar.hu(i + 1);
        u.Ww().a(lVar.jg("c12190"));
        aVar.WX().a(lVar);
        aVar.WX().a(this.cOT);
        aVar.WX().a(this.akI);
        return aVar.getView();
    }

    private void aov() {
        com.baidu.tieba.card.data.l.bIl = "c10705";
        com.baidu.tieba.card.data.l.bIm = "c10730";
        com.baidu.tieba.card.data.l.bIn = "c10731";
        com.baidu.tieba.card.data.l.bIo = "c10704";
        com.baidu.tieba.card.data.l.bIp = "c10755";
        com.baidu.tieba.card.data.l.bIq = "c10710";
        com.baidu.tieba.card.data.l.bIr = "c10736";
        com.baidu.tieba.card.data.l.bIs = "c10737";
        com.baidu.tieba.card.data.l.bIt = "c10711";
        com.baidu.tieba.card.data.l.bIu = "c10758";
        com.baidu.tieba.card.data.l.bIv = "c10757";
    }

    public void setEventCallback(h.a aVar) {
        this.akI = aVar;
    }
}
