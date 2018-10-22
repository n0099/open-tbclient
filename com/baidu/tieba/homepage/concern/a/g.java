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
    public BdUniqueId aZt;
    private String bVS;
    private k cKF;
    private x dIU;
    private ad eip;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eip = new ad<bc>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                k kVar = g.this.cKF;
                if (view != null && g.this.dIU != null && g.this.dIU.getView() != null && kVar != null && kVar.YB() != null && !StringUtils.isNull(kVar.YB().getTid())) {
                    am amVar = new am("c12352");
                    if ((g.this.dIU.getHeaderImg() == null || view.getId() != g.this.dIU.getHeaderImg().getId()) && (g.this.dIU.anS() == null || view.getId() != g.this.dIU.anS().getId())) {
                        if (view.getId() == g.this.dIU.cOy.getId()) {
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
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<x> onCreateViewHolder(ViewGroup viewGroup) {
        this.dIU = new x(this.mPageContext);
        this.dIU.j(this.aZt);
        this.dIU.fe(false);
        this.dIU.setIsFromConcern(true);
        this.dIU.b(this.eip);
        this.dIU.currentPageType = 1;
        if (this.dIU.bWf != null) {
            this.dIU.bWf.ary = 1;
        }
        if (this.dIU.bWS != null && this.dIU.bWS.aFS != null) {
            this.dIU.bWS.aFS.ary = 1;
        }
        if (this.dIU.cOy != null) {
            this.dIU.cOy.cPl = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.dIU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || aVar == null || aVar.aoQ() == null) {
            return null;
        }
        this.cKF = kVar;
        kVar.jT(i + 1);
        v.aop().a(kVar.mk("c12351"));
        bc bcVar = new bc(kVar.YB());
        bcVar.stType = "personalize_page";
        bcVar.arw = 9;
        bcVar.arx = 4;
        bcVar.arz = 4;
        if (aVar.aoQ() instanceof com.baidu.tieba.a.e) {
            aVar.aoQ().setPage(this.bVS);
        }
        aVar.aoQ().a(bcVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void jq(String str) {
        this.bVS = str;
    }
}
