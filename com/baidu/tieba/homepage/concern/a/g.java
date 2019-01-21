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
    public BdUniqueId beu;
    private k cVU;
    private String cbl;
    private x dTZ;
    private ad euc;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.euc = new ad<bc>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                k kVar = g.this.cVU;
                if (view != null && g.this.dTZ != null && g.this.dTZ.getView() != null && kVar != null && kVar.aaq() != null && !StringUtils.isNull(kVar.aaq().getTid())) {
                    am amVar = new am("c12352");
                    if ((g.this.dTZ.getHeaderImg() == null || view.getId() != g.this.dTZ.getHeaderImg().getId()) && (g.this.dTZ.aqs() == null || view.getId() != g.this.dTZ.aqs().getId())) {
                        if (view.getId() == g.this.dTZ.cZN.getId()) {
                            amVar.y("obj_locate", 3);
                        } else {
                            amVar.y("obj_locate", 2);
                        }
                    } else {
                        amVar.y("obj_locate", 1);
                    }
                    amVar.y("obj_type", 5);
                    amVar.aB("tid", kVar.threadData.getTid());
                    amVar.i(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(amVar);
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
        this.dTZ = new x(this.mPageContext);
        this.dTZ.j(this.beu);
        this.dTZ.fv(false);
        this.dTZ.setIsFromConcern(true);
        this.dTZ.b(this.euc);
        this.dTZ.currentPageType = 1;
        if (this.dTZ.cby != null) {
            this.dTZ.cby.awp = 1;
        }
        if (this.dTZ.ccl != null && this.dTZ.ccl.aKN != null) {
            this.dTZ.ccl.aKN.awp = 1;
        }
        if (this.dTZ.cZN != null) {
            this.dTZ.cZN.daC = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.dTZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || aVar == null || aVar.arr() == null) {
            return null;
        }
        this.cVU = kVar;
        kVar.kP(i + 1);
        v.aqP().a(kVar.nd("c12351"));
        bc bcVar = new bc(kVar.aaq());
        bcVar.stType = "personalize_page";
        bcVar.awn = 9;
        bcVar.awo = 4;
        bcVar.awq = 4;
        if (aVar.arr() instanceof com.baidu.tieba.a.e) {
            aVar.arr().setPage(this.cbl);
        }
        aVar.arr().a(bcVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbl = str;
    }
}
