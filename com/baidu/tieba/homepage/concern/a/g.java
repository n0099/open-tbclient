package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<l, com.baidu.tieba.card.a.a<t>> {
    public BdUniqueId bGo;
    private l cNR;
    private t dDi;
    private v ear;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ear = new v<bf>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, bf bfVar) {
                l lVar = g.this.cNR;
                if (view != null && g.this.dDi != null && g.this.dDi.getView() != null && lVar != null && lVar.VW() != null && !StringUtils.isNull(lVar.VW().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((g.this.dDi.getHeaderImg() != null && view.getId() == g.this.dDi.getHeaderImg().getId()) || (g.this.dDi.ajb() != null && view.getId() == g.this.dDi.ajb().getId())) {
                        akVar.s("obj_locate", 1);
                    } else {
                        akVar.s("obj_locate", 2);
                    }
                    akVar.s("obj_type", 5);
                    akVar.ab("tid", lVar.threadData.getTid());
                    akVar.f(ImageViewerConfig.FORUM_ID, lVar.threadData.getFid());
                    akVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<t> onCreateViewHolder(ViewGroup viewGroup) {
        this.dDi = new t(this.mPageContext);
        this.dDi.j(this.bGo);
        this.dDi.ey(false);
        this.dDi.setIsFromConcern(true);
        this.dDi.b(this.ear);
        this.dDi.currentPageType = 1;
        if (this.dDi.ciE != null) {
            this.dDi.ciE.bbP = 1;
        }
        if (this.dDi.cQU != null) {
            this.dDi.cQU.cRx = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.dDi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<t> aVar) {
        if (lVar == null || aVar == null || aVar.akh() == null) {
            return null;
        }
        this.cNR = lVar;
        lVar.lE(i + 1);
        s.ajC().a(lVar.kc("c12351"));
        bf bfVar = new bf(lVar.VW());
        bfVar.stType = "personalize_page";
        bfVar.aPe = 1;
        bfVar.aPf = 4;
        aVar.akh().a(bfVar);
        return aVar.getView();
    }
}
