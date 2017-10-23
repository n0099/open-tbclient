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
    public BdUniqueId aPk;
    private c.a aVu;
    private x cVH;
    private r cZm;
    private TbPageContext<?> mH;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aVu = null;
        this.cVH = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.XN().cA(true);
                if (view != null && g.this.cZm != null && g.this.cZm.getView() != null && lVar != null && lVar.Nd() != null && !StringUtils.isNull(lVar.Nd().getTid())) {
                    if (view.getId() != g.this.cZm.getView().getId()) {
                        if (g.this.cZm.getHeaderImg() == null || view.getId() != g.this.cZm.getHeaderImg().getId()) {
                            if (g.this.cZm.Xq() == null || view.getId() != g.this.cZm.Xq().getId()) {
                                if (g.this.cZm.bmV == null || g.this.cZm.bmV.getBarNameTv() == null || view.getId() != g.this.cZm.bmV.getBarNameTv().getId()) {
                                    if (g.this.cZm.Xp() != null && view.getId() == g.this.cZm.Xp().getId()) {
                                        TiebaStatic.log(lVar.jw("c12202"));
                                        return;
                                    }
                                    return;
                                }
                                TiebaStatic.log(lVar.Yb());
                                return;
                            }
                            TiebaStatic.log(lVar.jv("c12191"));
                            return;
                        }
                        TiebaStatic.log(lVar.jv("c12191"));
                        return;
                    }
                    TiebaStatic.log(lVar.jv("c12192"));
                }
            }
        };
        this.mH = tbPageContext;
        apE();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.cZm = new r(this.mH);
        this.cZm.k(this.aPk);
        return new com.baidu.tieba.card.a.a<>(this.cZm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (lVar == null || aVar == null || aVar.Yn() == null) {
            return null;
        }
        lVar.hQ(i + 1);
        u.XN().a(lVar.ju("c12190"));
        aVar.Yn().a(lVar);
        aVar.Yn().b(this.cVH);
        aVar.Yn().a(this.aVu);
        return aVar.getView();
    }

    private void apE() {
        com.baidu.tieba.card.data.l.bNh = "c10705";
        com.baidu.tieba.card.data.l.bNi = "c10730";
        com.baidu.tieba.card.data.l.bNj = "c10731";
        com.baidu.tieba.card.data.l.bNk = "c10704";
        com.baidu.tieba.card.data.l.bNl = "c10755";
        com.baidu.tieba.card.data.l.bNm = "c10710";
        com.baidu.tieba.card.data.l.bNn = "c10736";
        com.baidu.tieba.card.data.l.bNo = "c10737";
        com.baidu.tieba.card.data.l.bNp = "c10711";
        com.baidu.tieba.card.data.l.bNq = "c10758";
        com.baidu.tieba.card.data.l.bNr = "c10757";
    }

    public void setEventCallback(c.a aVar) {
        this.aVu = aVar;
    }
}
