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
    public BdUniqueId aOO;
    private h.a amd;
    private x cSl;
    private r cVN;
    private TbPageContext<?> oW;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.amd = null;
        this.cSl = new x<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.b.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                u.WU().cA(true);
                if (view != null && g.this.cVN != null && g.this.cVN.getView() != null && lVar != null && lVar.MF() != null && !StringUtils.isNull(lVar.MF().getTid())) {
                    if (view.getId() != g.this.cVN.getView().getId()) {
                        if (g.this.cVN.getHeaderImg() == null || view.getId() != g.this.cVN.getHeaderImg().getId()) {
                            if (g.this.cVN.WA() == null || view.getId() != g.this.cVN.WA().getId()) {
                                if (g.this.cVN.ble == null || g.this.cVN.ble.getBarNameTv() == null || view.getId() != g.this.cVN.ble.getBarNameTv().getId()) {
                                    if (g.this.cVN.Wz() != null && view.getId() == g.this.cVN.Wz().getId()) {
                                        TiebaStatic.log(lVar.jr("c12202"));
                                        return;
                                    }
                                    return;
                                }
                                TiebaStatic.log(lVar.Xj());
                                return;
                            }
                            TiebaStatic.log(lVar.jq("c12191"));
                            return;
                        }
                        TiebaStatic.log(lVar.jq("c12191"));
                        return;
                    }
                    TiebaStatic.log(lVar.jq("c12192"));
                }
            }
        };
        this.oW = tbPageContext;
        api();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: x */
    public com.baidu.tieba.card.a.a<r> onCreateViewHolder(ViewGroup viewGroup) {
        this.cVN = new r(this.oW);
        this.cVN.j(this.aOO);
        return new com.baidu.tieba.card.a.a<>(this.cVN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.tieba.card.a.a<r> aVar) {
        if (lVar == null || aVar == null || aVar.Xv() == null) {
            return null;
        }
        lVar.hw(i + 1);
        u.WU().a(lVar.jp("c12190"));
        aVar.Xv().a(lVar);
        aVar.Xv().b(this.cSl);
        aVar.Xv().a(this.amd);
        return aVar.getView();
    }

    private void api() {
        com.baidu.tieba.card.data.l.bKf = "c10705";
        com.baidu.tieba.card.data.l.bKg = "c10730";
        com.baidu.tieba.card.data.l.bKh = "c10731";
        com.baidu.tieba.card.data.l.bKi = "c10704";
        com.baidu.tieba.card.data.l.bKj = "c10755";
        com.baidu.tieba.card.data.l.bKk = "c10710";
        com.baidu.tieba.card.data.l.bKl = "c10736";
        com.baidu.tieba.card.data.l.bKm = "c10737";
        com.baidu.tieba.card.data.l.bKn = "c10711";
        com.baidu.tieba.card.data.l.bKo = "c10758";
        com.baidu.tieba.card.data.l.bKp = "c10757";
    }

    public void setEventCallback(h.a aVar) {
        this.amd = aVar;
    }
}
