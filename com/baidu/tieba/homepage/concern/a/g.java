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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.v;
import com.baidu.tieba.card.x;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<x>> implements com.baidu.tieba.a.f {
    public BdUniqueId aTs;
    private String bwO;
    private k cnj;
    private ab dBW;
    private x dff;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dBW = new ab<be>() { // from class: com.baidu.tieba.homepage.concern.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, be beVar) {
                k kVar = g.this.cnj;
                if (view2 != null && g.this.dff != null && g.this.dff.getView() != null && kVar != null && kVar.Pb() != null && !StringUtils.isNull(kVar.Pb().getTid())) {
                    al alVar = new al("c12352");
                    if ((g.this.dff.getHeaderImg() == null || view2.getId() != g.this.dff.getHeaderImg().getId()) && (g.this.dff.afc() == null || view2.getId() != g.this.dff.afc().getId())) {
                        if (view2.getId() == g.this.dff.crr.getId()) {
                            alVar.r("obj_locate", 3);
                        } else {
                            alVar.r("obj_locate", 2);
                        }
                    } else {
                        alVar.r("obj_locate", 1);
                    }
                    alVar.r("obj_type", 5);
                    alVar.ac("tid", kVar.threadData.getTid());
                    alVar.f(ImageViewerConfig.FORUM_ID, kVar.threadData.getFid());
                    alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(alVar);
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
        this.dff = new x(this.mPageContext);
        this.dff.j(this.aTs);
        this.dff.er(false);
        this.dff.setIsFromConcern(true);
        this.dff.b(this.dBW);
        this.dff.currentPageType = 1;
        if (this.dff.bxb != null) {
            this.dff.bxb.abW = 1;
        }
        if (this.dff.bxQ != null && this.dff.bxQ.apG != null) {
            this.dff.bxQ.apG.abW = 1;
        }
        if (this.dff.crr != null) {
            this.dff.crr.csc = 1;
        }
        return new com.baidu.tieba.card.a.a<>(this.dff);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<x> aVar) {
        if (kVar == null || aVar == null || aVar.afY() == null) {
            return null;
        }
        this.cnj = kVar;
        kVar.iM(i + 1);
        v.afy().a(kVar.kF("c12351"));
        be beVar = new be(kVar.Pb());
        beVar.stType = "personalize_page";
        beVar.abU = 9;
        beVar.abV = 4;
        if (aVar.afY() instanceof com.baidu.tieba.a.e) {
            aVar.afY().setPage(this.bwO);
        }
        aVar.afY().a(beVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void hZ(String str) {
        this.bwO = str;
    }
}
