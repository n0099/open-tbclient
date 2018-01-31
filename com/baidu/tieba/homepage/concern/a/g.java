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
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<l, com.baidu.tieba.card.a.a<t>> {
    public BdUniqueId bGE;
    private l cSN;
    private t dIe;
    private v ebW;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ebW = new v<be>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                l lVar = g.this.cSN;
                if (view != null && g.this.dIe != null && g.this.dIe.getView() != null && lVar != null && lVar.VM() != null && !StringUtils.isNull(lVar.VM().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((g.this.dIe.getHeaderImg() != null && view.getId() == g.this.dIe.getHeaderImg().getId()) || (g.this.dIe.akj() != null && view.getId() == g.this.dIe.akj().getId())) {
                        akVar.s("obj_locate", 1);
                    } else {
                        akVar.s("obj_locate", 2);
                    }
                    akVar.s("obj_type", 5);
                    akVar.aa("tid", lVar.threadData.getTid());
                    akVar.f(ImageViewerConfig.FORUM_ID, lVar.threadData.getFid());
                    akVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ac */
    public com.baidu.tieba.card.a.a<t> onCreateViewHolder(ViewGroup viewGroup) {
        this.dIe = new t(this.mPageContext);
        this.dIe.j(this.bGE);
        this.dIe.eE(false);
        this.dIe.setIsFromConcern(true);
        this.dIe.b(this.ebW);
        this.dIe.currentPageType = 1;
        if (this.dIe.ciT != null) {
            this.dIe.ciT.bbX = 1;
        }
        if (this.dIe.cVR != null) {
            this.dIe.cVR.cWu = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.dIe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<t> aVar) {
        if (lVar == null || aVar == null || aVar.alp() == null) {
            return null;
        }
        this.cSN = lVar;
        lVar.lH(i + 1);
        s.akK().a(lVar.kr("c12351"));
        be beVar = new be(lVar.VM());
        beVar.stType = "personalize_page";
        beVar.aPg = 1;
        beVar.aPh = 4;
        aVar.alp().a(beVar);
        return aVar.getView();
    }
}
