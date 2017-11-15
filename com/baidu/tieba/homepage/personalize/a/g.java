package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.tieba.card.a.a<r>> {
    public BdUniqueId aPy;
    private c.a aVM;
    private x deu;
    private r dhW;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVM = null;
        this.deu = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.aaj().cw(true);
                if (view != null && g.this.dhW != null && g.this.dhW.getView() != null && lVar != null && lVar.NA() != null && !StringUtils.isNull(lVar.NA().getTid())) {
                    if (view.getId() != g.this.dhW.getView().getId()) {
                        if (g.this.dhW.getHeaderImg() == null || view.getId() != g.this.dhW.getHeaderImg().getId()) {
                            if (g.this.dhW.ZM() == null || view.getId() != g.this.dhW.ZM().getId()) {
                                if (g.this.dhW.boM == null || g.this.dhW.boM.getBarNameTv() == null || view.getId() != g.this.dhW.boM.getBarNameTv().getId()) {
                                    if (g.this.dhW.ZL() != null && view.getId() == g.this.dhW.ZL().getId()) {
                                        TiebaStatic.log(lVar.jV("c12202"));
                                        return;
                                    }
                                    return;
                                }
                                TiebaStatic.log(lVar.aax());
                                return;
                            }
                            TiebaStatic.log(lVar.jU("c12191"));
                            return;
                        }
                        TiebaStatic.log(lVar.jU("c12191"));
                        return;
                    }
                    TiebaStatic.log(lVar.jU("c12192"));
                }
            }
        };
        this.mPageContext = tbPageContext;
        ast();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.dhW = new r(this.mPageContext);
        this.dhW.k(this.aPy);
        return new com.baidu.tieba.card.a.a<>(this.dhW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (lVar == null || aVar == null || aVar.aaJ() == null) {
            return null;
        }
        lVar.ih(i + 1);
        u.aaj().a(lVar.jT("c12190"));
        aVar.aaJ().a(lVar);
        aVar.aaJ().b(this.deu);
        aVar.aaJ().a(this.aVM);
        return aVar.getView();
    }

    private void ast() {
        com.baidu.tieba.card.data.l.bUY = "c10705";
        com.baidu.tieba.card.data.l.bUZ = "c10730";
        com.baidu.tieba.card.data.l.bVa = "c10731";
        com.baidu.tieba.card.data.l.bVb = "c10704";
        com.baidu.tieba.card.data.l.bVc = "c10755";
        com.baidu.tieba.card.data.l.bVd = "c10710";
        com.baidu.tieba.card.data.l.bVe = "c10736";
        com.baidu.tieba.card.data.l.bVf = "c10737";
        com.baidu.tieba.card.data.l.bVg = "c10711";
        com.baidu.tieba.card.data.l.bVh = "c10758";
        com.baidu.tieba.card.data.l.bVi = "c10757";
    }

    public void setEventCallback(c.a aVar) {
        this.aVM = aVar;
    }
}
