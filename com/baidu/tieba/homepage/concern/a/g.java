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
    public BdUniqueId aSy;
    private l bZi;
    private t cOe;
    private v dof;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dof = new v<be>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                l lVar = g.this.bZi;
                if (view != null && g.this.cOe != null && g.this.cOe.getView() != null && lVar != null && lVar.Ox() != null && !StringUtils.isNull(lVar.Ox().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((g.this.cOe.getHeaderImg() != null && view.getId() == g.this.cOe.getHeaderImg().getId()) || (g.this.cOe.abw() != null && view.getId() == g.this.cOe.abw().getId())) {
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
        this.cOe = new t(this.mPageContext);
        this.cOe.k(this.aSy);
        this.cOe.dR(false);
        this.cOe.setIsFromConcern(true);
        this.cOe.b(this.dof);
        this.cOe.currentPageType = 1;
        if (this.cOe.bvI != null) {
            this.cOe.bvI.anO = 1;
        }
        if (this.cOe.ccm != null) {
            this.cOe.ccm.ccQ = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.cOe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<t> aVar) {
        if (lVar == null || aVar == null || aVar.acC() == null) {
            return null;
        }
        this.bZi = lVar;
        lVar.iG(i + 1);
        s.abX().a(lVar.jW("c12351"));
        be beVar = new be(lVar.Ox());
        beVar.stType = "personalize_page";
        beVar.aaF = 1;
        beVar.aaG = 4;
        aVar.acC().a(beVar);
        return aVar.getView();
    }
}
