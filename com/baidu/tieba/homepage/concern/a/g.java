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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.r;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<s>> {
    public BdUniqueId bIv;
    private k cVw;
    public int cardShowType;
    private s dKT;
    private v efW;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cardShowType = 0;
        this.efW = new v<be>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                k kVar = g.this.cVw;
                if (view != null && g.this.dKT != null && g.this.dKT.getView() != null && kVar != null && kVar.WD() != null && !StringUtils.isNull(kVar.WD().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((g.this.dKT.getHeaderImg() == null || view.getId() != g.this.dKT.getHeaderImg().getId()) && (g.this.dKT.akR() == null || view.getId() != g.this.dKT.akR().getId())) {
                        if (view.getId() == g.this.dKT.cYq.getId()) {
                            akVar.s("obj_locate", 3);
                        } else {
                            akVar.s("obj_locate", 2);
                        }
                    } else {
                        akVar.s("obj_locate", 1);
                    }
                    akVar.s("obj_type", 5);
                    akVar.ab("tid", kVar.threadData.getTid());
                    akVar.f(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
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
    /* renamed from: ad */
    public com.baidu.tieba.card.a.a<s> onCreateViewHolder(ViewGroup viewGroup) {
        this.dKT = new s(this.mPageContext);
        this.dKT.j(this.bIv);
        this.dKT.eL(false);
        this.dKT.setIsFromConcern(true);
        this.dKT.b(this.efW);
        this.dKT.currentPageType = 1;
        if (this.dKT.clX != null) {
            this.dKT.clX.aQt = 1;
        }
        if (this.dKT.cmL != null && this.dKT.cmL.bem != null) {
            this.dKT.cmL.bem.aQt = 1;
        }
        if (this.dKT.cYq != null) {
            this.dKT.cYq.cYV = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.dKT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<s> aVar) {
        if (kVar == null || aVar == null || aVar.alX() == null) {
            return null;
        }
        this.cVw = kVar;
        kVar.lD(i + 1);
        r.als().a(kVar.kz("c12351"));
        be beVar = new be(kVar.WD());
        beVar.stType = "personalize_page";
        beVar.aQr = 9;
        beVar.aQs = 4;
        beVar.threadData.aQo = this.cardShowType;
        aVar.alX().a(beVar);
        return aVar.getView();
    }
}
