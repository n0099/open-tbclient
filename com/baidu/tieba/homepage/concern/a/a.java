package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e>> implements com.baidu.tieba.a.f {
    public BdUniqueId aRF;
    private String bHB;
    private com.baidu.tieba.homepage.concern.view.e dTi;
    private ad<com.baidu.tieba.homepage.concern.b.b> dTj;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.dTj = new ad<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.dTi != null) {
                    an anVar = new an("c12407");
                    anVar.f(ImageViewerConfig.FORUM_ID, bVar.dbA.getFid());
                    anVar.af("tid", bVar.dbA.getTid());
                    anVar.r("obj_type", 4);
                    anVar.af(VideoPlayActivityConfig.OBJ_ID, bVar.dTI.getUserId());
                    if ((a.this.dTi.dUa == null || view.getId() != a.this.dTi.dUa.getId()) && (a.this.dTi.bHN.getHeaderImg() == null || view.getId() != a.this.dTi.bHN.getHeaderImg().getId())) {
                        if (a.this.dTi.dTY != null && view.getId() == a.this.dTi.dTY.getId()) {
                            anVar.r("obj_locate", 3);
                        } else {
                            anVar.r("obj_locate", 2);
                        }
                    } else {
                        anVar.r("obj_locate", 1);
                    }
                    anVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aDs());
                    TiebaStatic.log(anVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.dTi = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.aRF != null) {
            this.dTi.j(this.aRF);
        }
        return new com.baidu.tieba.card.a.a<>(this.dTi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.dTI == null || aVar == null || StringUtils.isNull(bVar.dTI.getName()) || StringUtils.isNull(bVar.dTI.getUserId())) {
            return null;
        }
        if (aVar.ajz() instanceof com.baidu.tieba.a.e) {
            aVar.ajz().setPage(this.bHB);
        }
        aVar.ajz().a(bVar);
        aVar.ajz().b(this.dTj);
        aVar.ajz().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.aiY().a(new an("c12353").f("uid", TbadkCoreApplication.getCurrentAccountId()).af(VideoPlayActivityConfig.OBJ_ID, bVar.dTI.getUserId()).r("obj_type", 4).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aDs()).af("tid", bVar.dbA.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void iA(String str) {
        this.bHB = str;
    }
}
