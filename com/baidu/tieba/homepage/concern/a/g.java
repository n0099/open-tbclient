package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
/* loaded from: classes6.dex */
public class g extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f {
    public BdUniqueId bdE;
    private k cSs;
    private String caw;
    private x dQB;
    private ad eqD;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eqD = new ad<bc>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                k kVar = g.this.cSs;
                if (view != null && g.this.dQB != null && g.this.dQB.getView() != null && kVar != null && kVar.ZR() != null && !StringUtils.isNull(kVar.ZR().getTid())) {
                    am amVar = new am("c12352");
                    if ((g.this.dQB.getHeaderImg() == null || view.getId() != g.this.dQB.getHeaderImg().getId()) && (g.this.dQB.apf() == null || view.getId() != g.this.dQB.apf().getId())) {
                        if (view.getId() == g.this.dQB.cWl.getId()) {
                            amVar.x("obj_locate", 3);
                        } else {
                            amVar.x("obj_locate", 2);
                        }
                    } else {
                        amVar.x("obj_locate", 1);
                    }
                    amVar.x("obj_type", 5);
                    amVar.aA("tid", kVar.threadData.getTid());
                    amVar.i(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
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
        this.dQB = new x(this.mPageContext);
        this.dQB.j(this.bdE);
        this.dQB.fq(false);
        this.dQB.setIsFromConcern(true);
        this.dQB.b(this.eqD);
        this.dQB.currentPageType = 1;
        if (this.dQB.caJ != null) {
            this.dQB.caJ.avL = 1;
        }
        if (this.dQB.cbw != null && this.dQB.cbw.aKi != null) {
            this.dQB.cbw.aKi.avL = 1;
        }
        if (this.dQB.cWl != null) {
            this.dQB.cWl.cWY = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.dQB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || aVar == null || aVar.aqe() == null) {
            return null;
        }
        this.cSs = kVar;
        kVar.kC(i + 1);
        v.apD().a(kVar.mK("c12351"));
        bc bcVar = new bc(kVar.ZR());
        bcVar.stType = "personalize_page";
        bcVar.avJ = 9;
        bcVar.avK = 4;
        bcVar.avM = 4;
        if (aVar.aqe() instanceof com.baidu.tieba.a.e) {
            aVar.aqe().setPage(this.caw);
        }
        aVar.aqe().a(bcVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void jK(String str) {
        this.caw = str;
    }
}
