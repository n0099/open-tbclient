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
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.v;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.widget.ListView.a<l, com.baidu.tieba.card.a.a<t>> {
    public BdUniqueId aSB;
    private l bZm;
    private t cOi;
    private v doj;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.doj = new v<be>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                l lVar = g.this.bZm;
                if (view != null && g.this.cOi != null && g.this.cOi.getView() != null && lVar != null && lVar.Ox() != null && !StringUtils.isNull(lVar.Ox().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((g.this.cOi.getHeaderImg() != null && view.getId() == g.this.cOi.getHeaderImg().getId()) || (g.this.cOi.abw() != null && view.getId() == g.this.cOi.abw().getId())) {
                        akVar.r("obj_locate", 1);
                    } else {
                        akVar.r("obj_locate", 2);
                    }
                    akVar.r("obj_type", 5);
                    akVar.ac("tid", lVar.threadData.getTid());
                    akVar.f(ImageViewerConfig.FORUM_ID, lVar.threadData.getFid());
                    akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.card.a.a<t> onCreateViewHolder(ViewGroup viewGroup) {
        this.cOi = new t(this.mPageContext);
        this.cOi.k(this.aSB);
        this.cOi.dR(false);
        this.cOi.setIsFromConcern(true);
        this.cOi.b(this.doj);
        this.cOi.currentPageType = 1;
        if (this.cOi.bvM != null) {
            this.cOi.bvM.anR = 1;
        }
        if (this.cOi.ccq != null) {
            this.cOi.ccq.ccU = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.cOi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<t> aVar) {
        if (lVar == null || aVar == null || aVar.acB() == null) {
            return null;
        }
        this.bZm = lVar;
        lVar.iG(i + 1);
        s.abW().a(lVar.jW("c12351"));
        be beVar = new be(lVar.Ox());
        beVar.stType = "personalize_page";
        beVar.aaI = 1;
        beVar.aaJ = 4;
        aVar.acB().a(beVar);
        return aVar.getView();
    }
}
