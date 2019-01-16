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
    public BdUniqueId bes;
    private k cVT;
    private String cbk;
    private x dTY;
    private ad eub;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eub = new ad<bc>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                k kVar = g.this.cVT;
                if (view != null && g.this.dTY != null && g.this.dTY.getView() != null && kVar != null && kVar.aaq() != null && !StringUtils.isNull(kVar.aaq().getTid())) {
                    am amVar = new am("c12352");
                    if ((g.this.dTY.getHeaderImg() == null || view.getId() != g.this.dTY.getHeaderImg().getId()) && (g.this.dTY.aqs() == null || view.getId() != g.this.dTY.aqs().getId())) {
                        if (view.getId() == g.this.dTY.cZM.getId()) {
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
        this.dTY = new x(this.mPageContext);
        this.dTY.j(this.bes);
        this.dTY.fv(false);
        this.dTY.setIsFromConcern(true);
        this.dTY.b(this.eub);
        this.dTY.currentPageType = 1;
        if (this.dTY.cbx != null) {
            this.dTY.cbx.awo = 1;
        }
        if (this.dTY.cck != null && this.dTY.cck.aKM != null) {
            this.dTY.cck.aKM.awo = 1;
        }
        if (this.dTY.cZM != null) {
            this.dTY.cZM.daB = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.dTY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || aVar == null || aVar.arr() == null) {
            return null;
        }
        this.cVT = kVar;
        kVar.kP(i + 1);
        v.aqP().a(kVar.nd("c12351"));
        bc bcVar = new bc(kVar.aaq());
        bcVar.stType = "personalize_page";
        bcVar.awm = 9;
        bcVar.awn = 4;
        bcVar.awp = 4;
        if (aVar.arr() instanceof com.baidu.tieba.a.e) {
            aVar.arr().setPage(this.cbk);
        }
        aVar.arr().a(bcVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void kb(String str) {
        this.cbk = str;
    }
}
