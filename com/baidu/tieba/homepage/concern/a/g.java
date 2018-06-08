package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f {
    public BdUniqueId aQJ;
    private String bER;
    private k cvO;
    private ab dNe;
    private x dou;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dNe = new ab<be>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, be beVar) {
                k kVar = g.this.cvO;
                if (view != null && g.this.dou != null && g.this.dou.getView() != null && kVar != null && kVar.Sz() != null && !StringUtils.isNull(kVar.Sz().getTid())) {
                    am amVar = new am("c12352");
                    if ((g.this.dou.getHeaderImg() == null || view.getId() != g.this.dou.getHeaderImg().getId()) && (g.this.dou.aiL() == null || view.getId() != g.this.dou.aiL().getId())) {
                        if (view.getId() == g.this.dou.czT.getId()) {
                            amVar.r("obj_locate", 3);
                        } else {
                            amVar.r("obj_locate", 2);
                        }
                    } else {
                        amVar.r("obj_locate", 1);
                    }
                    amVar.r("obj_type", 5);
                    amVar.ah("tid", kVar.threadData.getTid());
                    amVar.f(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    amVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dou = new x(this.mPageContext);
        this.dou.j(this.aQJ);
        this.dou.ev(false);
        this.dou.setIsFromConcern(true);
        this.dou.b(this.dNe);
        this.dou.currentPageType = 1;
        if (this.dou.bFe != null) {
            this.dou.bFe.aka = 1;
        }
        if (this.dou.bFT != null && this.dou.bFT.axN != null) {
            this.dou.bFT.axN.aka = 1;
        }
        if (this.dou.czT != null) {
            this.dou.czT.cAF = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.dou);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || aVar == null || aVar.ajG() == null) {
            return null;
        }
        this.cvO = kVar;
        kVar.iN(i + 1);
        v.ajh().a(kVar.li("c12351"));
        be beVar = new be(kVar.Sz());
        beVar.stType = "personalize_page";
        beVar.ajY = 9;
        beVar.ajZ = 4;
        if (aVar.ajG() instanceof com.baidu.tieba.a.e) {
            aVar.ajG().setPage(this.bER);
        }
        aVar.ajG().a(beVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void iy(String str) {
        this.bER = str;
    }
}
