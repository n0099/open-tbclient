package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.t;
import com.baidu.tieba.card.v;
/* loaded from: classes4.dex */
public class g extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<v>> implements com.baidu.tieba.a.f {
    private String YA;
    public BdUniqueId cnZ;
    private ab eEg;
    private k ehY;
    private v fGB;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eEg = new ab<bh>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bh bhVar) {
                k kVar = g.this.ehY;
                if (view != null && g.this.fGB != null && g.this.fGB.getView() != null && kVar != null && kVar.WO() != null && !StringUtils.isNull(kVar.WO().getTid())) {
                    am amVar = new am("c12352");
                    if ((g.this.fGB.getHeaderImg() == null || view.getId() != g.this.fGB.getHeaderImg().getId()) && (g.this.fGB.aQk() == null || view.getId() != g.this.fGB.aQk().getId())) {
                        if (view.getId() == g.this.fGB.ejm.getId()) {
                            amVar.T("obj_locate", 3);
                        } else {
                            amVar.T("obj_locate", 2);
                        }
                    } else {
                        amVar.T("obj_locate", 1);
                    }
                    amVar.T("obj_type", 5);
                    amVar.bJ("tid", kVar.threadData.getTid());
                    amVar.k(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a<v> onCreateViewHolder(ViewGroup viewGroup) {
        this.fGB = new v(this.mPageContext);
        this.fGB.k(this.cnZ);
        this.fGB.hN(false);
        this.fGB.setIsFromConcern(true);
        this.fGB.d(this.eEg);
        this.fGB.currentPageType = 1;
        if (this.fGB.dqy != null) {
            this.fGB.dqy.bSJ = 1;
        }
        if (this.fGB.drn != null && this.fGB.drn.bTB != null) {
            this.fGB.drn.bTB.bSJ = 1;
        }
        if (this.fGB.ejm != null) {
            this.fGB.ejm.ejX = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.fGB);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<v> aVar) {
        if (kVar == null || aVar == null || aVar.aRg() == null) {
            return null;
        }
        this.ehY = kVar;
        kVar.oo(i + 1);
        t.aQD().b(kVar.tG("c12351"));
        bh bhVar = new bh(kVar.WO());
        bhVar.stType = "personalize_page";
        bhVar.bDX = 9;
        bhVar.bDY = 4;
        bhVar.bDZ = 4;
        if (aVar.aRg() instanceof com.baidu.tieba.a.e) {
            aVar.aRg().setPage(this.YA);
        }
        aVar.aRg().a(bhVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void qM(String str) {
        this.YA = str;
    }
}
