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
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<l, com.baidu.tieba.card.a.a<o>> {
    public BdUniqueId aSv;
    private c.a aYN;
    private v dmZ;
    private o dqG;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aYN = null;
        this.dmZ = new v<l>() { // from class: com.baidu.tieba.homepage.personalize.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, l lVar) {
                s.abU().cB(true);
                if (view != null && e.this.dqG != null && e.this.dqG.getView() != null && lVar != null && lVar.Ox() != null && !StringUtils.isNull(lVar.Ox().getTid())) {
                    if (view.getId() != e.this.dqG.getView().getId()) {
                        if (e.this.dqG.getHeaderImg() == null || view.getId() != e.this.dqG.getHeaderImg().getId()) {
                            if (e.this.dqG.abv() == null || view.getId() != e.this.dqG.abv().getId()) {
                                if (e.this.dqG.bvH == null || e.this.dqG.bvH.getBarNameTv() == null || view.getId() != e.this.dqG.bvH.getBarNameTv().getId()) {
                                    if (e.this.dqG.abu() != null && view.getId() == e.this.dqG.abu().getId()) {
                                        TiebaStatic.log(lVar.kb("c12202"));
                                        return;
                                    }
                                    return;
                                }
                                TiebaStatic.log(lVar.acg());
                                return;
                            }
                            TiebaStatic.log(lVar.ka("c12191"));
                            return;
                        }
                        TiebaStatic.log(lVar.ka("c12191"));
                        return;
                    }
                    TiebaStatic.log(lVar.ka("c12192"));
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
    public com.baidu.tieba.card.a.a<o> onCreateViewHolder(ViewGroup viewGroup) {
        this.dqG = new o(this.mPageContext);
        this.dqG.currentPageType = 2;
        if (this.dqG.bvH != null) {
            this.dqG.bvH.anM = 2;
        }
        this.dqG.k(this.aSv);
        return new com.baidu.tieba.card.a.a<>(this.dqG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<o> aVar) {
        if (lVar == null || aVar == null || aVar.acs() == null) {
            return null;
        }
        lVar.iE(i + 1);
        s.abU().a(lVar.jZ("c12190"));
        aVar.acs().a(lVar);
        aVar.acs().b(this.dmZ);
        aVar.acs().a(this.aYN);
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
