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
    public BdUniqueId aSv;
    private l bZe;
    private t cNT;
    private v dmZ;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dmZ = new v<be>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                l lVar = g.this.bZe;
                if (view != null && g.this.cNT != null && g.this.cNT.getView() != null && lVar != null && lVar.Ox() != null && !StringUtils.isNull(lVar.Ox().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((g.this.cNT.getHeaderImg() != null && view.getId() == g.this.cNT.getHeaderImg().getId()) || (g.this.cNT.abv() != null && view.getId() == g.this.cNT.abv().getId())) {
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
        this.cNT = new t(this.mPageContext);
        this.cNT.k(this.aSv);
        this.cNT.dQ(false);
        this.cNT.setIsFromConcern(true);
        this.cNT.b(this.dmZ);
        this.cNT.currentPageType = 1;
        if (this.cNT.bvH != null) {
            this.cNT.bvH.anM = 1;
        }
        if (this.cNT.cci != null) {
            this.cNT.cci.ccL = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.cNT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<t> aVar) {
        if (lVar == null || aVar == null || aVar.acs() == null) {
            return null;
        }
        this.bZe = lVar;
        lVar.iE(i + 1);
        s.abU().a(lVar.jY("c12351"));
        be beVar = new be(lVar.Ox());
        beVar.stType = "personalize_page";
        beVar.aaL = 1;
        beVar.aaM = 4;
        aVar.acs().a(beVar);
        return aVar.getView();
    }
}
