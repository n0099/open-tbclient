package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.v;
/* loaded from: classes4.dex */
public class g extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<v>> implements com.baidu.tieba.a.f {
    private String YA;
    public BdUniqueId cnX;
    private ab eEv;
    private k eim;
    private v fGN;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eEv = new ab<bh>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                k kVar = g.this.eim;
                if (view != null && g.this.fGN != null && g.this.fGN.getView() != null && kVar != null && kVar.WR() != null && !StringUtils.isNull(kVar.WR().getTid())) {
                    am amVar = new am("c12352");
                    if ((g.this.fGN.getHeaderImg() == null || view.getId() != g.this.fGN.getHeaderImg().getId()) && (g.this.fGN.aQm() == null || view.getId() != g.this.fGN.aQm().getId())) {
                        if (view.getId() == g.this.fGN.ejA.getId()) {
                            amVar.T("obj_locate", 3);
                        } else {
                            amVar.T("obj_locate", 2);
                        }
                    } else {
                        amVar.T("obj_locate", 1);
                    }
                    amVar.T("obj_type", 5);
                    amVar.bJ("tid", kVar.threadData.getTid());
                    amVar.k(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a<v> onCreateViewHolder(ViewGroup viewGroup) {
        this.fGN = new v(this.mPageContext);
        this.fGN.k(this.cnX);
        this.fGN.hN(false);
        this.fGN.setIsFromConcern(true);
        this.fGN.d(this.eEv);
        this.fGN.currentPageType = 1;
        if (this.fGN.dqv != null) {
            this.fGN.dqv.bSH = 1;
        }
        if (this.fGN.drk != null && this.fGN.drk.bTz != null) {
            this.fGN.drk.bTz.bSH = 1;
        }
        if (this.fGN.ejA != null) {
            this.fGN.ejA.ekl = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.fGN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<v> aVar) {
        if (kVar == null || aVar == null || aVar.aRi() == null) {
            return null;
        }
        this.eim = kVar;
        kVar.os(i + 1);
        t.aQF().b(kVar.tH("c12351"));
        bh bhVar = new bh(kVar.WR());
        bhVar.stType = "personalize_page";
        bhVar.bDU = 9;
        bhVar.bDV = 4;
        bhVar.bDW = 4;
        if (aVar.aRi() instanceof com.baidu.tieba.a.e) {
            aVar.aRi().setPage(this.YA);
        }
        aVar.aRi().a(bhVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void qL(String str) {
        this.YA = str;
    }
}
