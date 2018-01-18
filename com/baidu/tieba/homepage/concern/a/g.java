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
    public BdUniqueId bGw;
    private l cSs;
    private t dHJ;
    private v ebB;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ebB = new v<be>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, be beVar) {
                l lVar = g.this.cSs;
                if (view != null && g.this.dHJ != null && g.this.dHJ.getView() != null && lVar != null && lVar.VK() != null && !StringUtils.isNull(lVar.VK().getTid())) {
                    ak akVar = new ak("c12352");
                    if ((g.this.dHJ.getHeaderImg() != null && view.getId() == g.this.dHJ.getHeaderImg().getId()) || (g.this.dHJ.ake() != null && view.getId() == g.this.dHJ.ake().getId())) {
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
    /* renamed from: ac */
    public com.baidu.tieba.card.a.a<t> onCreateViewHolder(ViewGroup viewGroup) {
        this.dHJ = new t(this.mPageContext);
        this.dHJ.j(this.bGw);
        this.dHJ.eC(false);
        this.dHJ.setIsFromConcern(true);
        this.dHJ.b(this.ebB);
        this.dHJ.currentPageType = 1;
        if (this.dHJ.ciL != null) {
            this.dHJ.ciL.bbP = 1;
        }
        if (this.dHJ.cVw != null) {
            this.dHJ.cVw.cVZ = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.dHJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.tieba.card.a.a<t> aVar) {
        if (lVar == null || aVar == null || aVar.alk() == null) {
            return null;
        }
        this.cSs = lVar;
        lVar.lH(i + 1);
        s.akF().a(lVar.kk("c12351"));
        be beVar = new be(lVar.VK());
        beVar.stType = "personalize_page";
        beVar.aPd = 1;
        beVar.aPe = 4;
        aVar.alk().a(beVar);
        return aVar.getView();
    }
}
