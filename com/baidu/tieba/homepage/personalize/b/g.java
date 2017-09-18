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
    public BdUniqueId aOu;
    private h.a alv;
    private x cZy;
    private r ddl;
    private TbPageContext<?> mF;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alv = null;
        this.cZy = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.b.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.Yj().cC(true);
                if (view != null && g.this.ddl != null && g.this.ddl.getView() != null && lVar != null && lVar.MR() != null && !StringUtils.isNull(lVar.MR().getTid())) {
                    if (view.getId() != g.this.ddl.getView().getId()) {
                        if (g.this.ddl.getHeaderImg() == null || view.getId() != g.this.ddl.getHeaderImg().getId()) {
                            if (g.this.ddl.XO() == null || view.getId() != g.this.ddl.XO().getId()) {
                                if (g.this.ddl.bly == null || g.this.ddl.bly.getBarNameTv() == null || view.getId() != g.this.ddl.bly.getBarNameTv().getId()) {
                                    if (g.this.ddl.XN() != null && view.getId() == g.this.ddl.XN().getId()) {
                                        TiebaStatic.log(lVar.jE("c12202"));
                                        return;
                                    }
                                    return;
                                }
                                TiebaStatic.log(lVar.Yx());
                                return;
                            }
                            TiebaStatic.log(lVar.jD("c12191"));
                            return;
                        }
                        TiebaStatic.log(lVar.jD("c12191"));
                        return;
                    }
                    TiebaStatic.log(lVar.jD("c12192"));
                }
            }
        };
        this.mF = tbPageContext;
        ard();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.ddl = new r(this.mF);
        this.ddl.l(this.aOu);
        return new com.baidu.tieba.card.a.a<>(this.ddl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (lVar == null || aVar == null || aVar.YJ() == null) {
            return null;
        }
        lVar.hJ(i + 1);
        u.Yj().a(lVar.jC("c12190"));
        aVar.YJ().a(lVar);
        aVar.YJ().b(this.cZy);
        aVar.YJ().a(this.alv);
        return aVar.getView();
    }

    private void ard() {
        com.baidu.tieba.card.data.l.bNO = "c10705";
        com.baidu.tieba.card.data.l.bNP = "c10730";
        com.baidu.tieba.card.data.l.bNQ = "c10731";
        com.baidu.tieba.card.data.l.bNR = "c10704";
        com.baidu.tieba.card.data.l.bNS = "c10755";
        com.baidu.tieba.card.data.l.bNT = "c10710";
        com.baidu.tieba.card.data.l.bNU = "c10736";
        com.baidu.tieba.card.data.l.bNV = "c10737";
        com.baidu.tieba.card.data.l.bNW = "c10711";
        com.baidu.tieba.card.data.l.bNX = "c10758";
        com.baidu.tieba.card.data.l.bNY = "c10757";
    }

    public void setEventCallback(h.a aVar) {
        this.alv = aVar;
    }
}
