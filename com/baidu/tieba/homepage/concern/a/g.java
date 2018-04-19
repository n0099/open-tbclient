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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f {
    public BdUniqueId aTr;
    private String bvX;
    private k cmc;
    private ab dAS;
    private x dea;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dAS = new ab<be>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, be beVar) {
                k kVar = g.this.cmc;
                if (view2 != null && g.this.dea != null && g.this.dea.getView() != null && kVar != null && kVar.Pe() != null && !StringUtils.isNull(kVar.Pe().getTid())) {
                    al alVar = new al("c12352");
                    if ((g.this.dea.getHeaderImg() == null || view2.getId() != g.this.dea.getHeaderImg().getId()) && (g.this.dea.afc() == null || view2.getId() != g.this.dea.afc().getId())) {
                        if (view2.getId() == g.this.dea.cqk.getId()) {
                            alVar.r("obj_locate", 3);
                        } else {
                            alVar.r("obj_locate", 2);
                        }
                    } else {
                        alVar.r("obj_locate", 1);
                    }
                    alVar.r("obj_type", 5);
                    alVar.ac("tid", kVar.threadData.getTid());
                    alVar.f(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(alVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dea = new x(this.mPageContext);
        this.dea.j(this.aTr);
        this.dea.eq(false);
        this.dea.setIsFromConcern(true);
        this.dea.b(this.dAS);
        this.dea.currentPageType = 1;
        if (this.dea.bwk != null) {
            this.dea.bwk.abV = 1;
        }
        if (this.dea.bwZ != null && this.dea.bwZ.apG != null) {
            this.dea.bwZ.apG.abV = 1;
        }
        if (this.dea.cqk != null) {
            this.dea.cqk.cqV = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.dea);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || aVar == null || aVar.afY() == null) {
            return null;
        }
        this.cmc = kVar;
        kVar.iN(i + 1);
        v.afy().a(kVar.kC("c12351"));
        be beVar = new be(kVar.Pe());
        beVar.stType = "personalize_page";
        beVar.abT = 9;
        beVar.abU = 4;
        if (aVar.afY() instanceof com.baidu.tieba.a.e) {
            aVar.afY().setPage(this.bvX);
        }
        aVar.afY().a(beVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void hY(String str) {
        this.bvX = str;
    }
}
