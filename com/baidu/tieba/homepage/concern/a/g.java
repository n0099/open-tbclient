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
    private String bWE;
    public BdUniqueId bag;
    private k cLL;
    private x dJY;
    private ad ejJ;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ejJ = new ad<bc>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                k kVar = g.this.cLL;
                if (view != null && g.this.dJY != null && g.this.dJY.getView() != null && kVar != null && kVar.YL() != null && !StringUtils.isNull(kVar.YL().getTid())) {
                    am amVar = new am("c12352");
                    if ((g.this.dJY.getHeaderImg() == null || view.getId() != g.this.dJY.getHeaderImg().getId()) && (g.this.dJY.ant() == null || view.getId() != g.this.dJY.ant().getId())) {
                        if (view.getId() == g.this.dJY.cPE.getId()) {
                            amVar.x("obj_locate", 3);
                        } else {
                            amVar.x("obj_locate", 2);
                        }
                    } else {
                        amVar.x("obj_locate", 1);
                    }
                    amVar.x("obj_type", 5);
                    amVar.ax("tid", kVar.threadData.getTid());
                    amVar.h(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
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
        this.dJY = new x(this.mPageContext);
        this.dJY.j(this.bag);
        this.dJY.fp(false);
        this.dJY.setIsFromConcern(true);
        this.dJY.b(this.ejJ);
        this.dJY.currentPageType = 1;
        if (this.dJY.bWR != null) {
            this.dJY.bWR.asl = 1;
        }
        if (this.dJY.bXE != null && this.dJY.bXE.aGI != null) {
            this.dJY.bXE.aGI.asl = 1;
        }
        if (this.dJY.cPE != null) {
            this.dJY.cPE.cQr = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.dJY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || aVar == null || aVar.aor() == null) {
            return null;
        }
        this.cLL = kVar;
        kVar.km(i + 1);
        v.anQ().a(kVar.ml("c12351"));
        bc bcVar = new bc(kVar.YL());
        bcVar.stType = "personalize_page";
        bcVar.asj = 9;
        bcVar.ask = 4;
        bcVar.asm = 4;
        if (aVar.aor() instanceof com.baidu.tieba.a.e) {
            aVar.aor().setPage(this.bWE);
        }
        aVar.aor().a(bcVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void js(String str) {
        this.bWE = str;
    }
}
