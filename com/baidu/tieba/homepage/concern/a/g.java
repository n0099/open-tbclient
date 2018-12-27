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
    public BdUniqueId bdH;
    private k cVi;
    private String caz;
    private x dTs;
    private ad etv;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.etv = new ad<bc>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, bc bcVar) {
                k kVar = g.this.cVi;
                if (view != null && g.this.dTs != null && g.this.dTs.getView() != null && kVar != null && kVar.ZT() != null && !StringUtils.isNull(kVar.ZT().getTid())) {
                    am amVar = new am("c12352");
                    if ((g.this.dTs.getHeaderImg() == null || view.getId() != g.this.dTs.getHeaderImg().getId()) && (g.this.dTs.apV() == null || view.getId() != g.this.dTs.apV().getId())) {
                        if (view.getId() == g.this.dTs.cZb.getId()) {
                            amVar.x("obj_locate", 3);
                        } else {
                            amVar.x("obj_locate", 2);
                        }
                    } else {
                        amVar.x("obj_locate", 1);
                    }
                    amVar.x("obj_type", 5);
                    amVar.aA("tid", kVar.threadData.getTid());
                    amVar.i(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
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
        this.dTs = new x(this.mPageContext);
        this.dTs.j(this.bdH);
        this.dTs.fs(false);
        this.dTs.setIsFromConcern(true);
        this.dTs.b(this.etv);
        this.dTs.currentPageType = 1;
        if (this.dTs.caM != null) {
            this.dTs.caM.avM = 1;
        }
        if (this.dTs.cbz != null && this.dTs.cbz.aKk != null) {
            this.dTs.cbz.aKk.avM = 1;
        }
        if (this.dTs.cZb != null) {
            this.dTs.cZb.cZO = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.dTs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || aVar == null || aVar.aqT() == null) {
            return null;
        }
        this.cVi = kVar;
        kVar.kP(i + 1);
        v.aqs().a(kVar.mN("c12351"));
        bc bcVar = new bc(kVar.ZT());
        bcVar.stType = "personalize_page";
        bcVar.avK = 9;
        bcVar.avL = 4;
        bcVar.avN = 4;
        if (aVar.aqT() instanceof com.baidu.tieba.a.e) {
            aVar.aqT().setPage(this.caz);
        }
        aVar.aqT().a(bcVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void jL(String str) {
        this.caz = str;
    }
}
