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
    public BdUniqueId aRC;
    private String bHB;
    private com.baidu.tieba.homepage.concern.view.e dTd;
    private ad<com.baidu.tieba.homepage.concern.b.b> dTe;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.dTe = new ad<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.dTd != null) {
                    an anVar = new an("c12407");
                    anVar.f(ImageViewerConfig.FORUM_ID, bVar.dbw.getFid());
                    anVar.ae("tid", bVar.dbw.getTid());
                    anVar.r("obj_type", 4);
                    anVar.ae(VideoPlayActivityConfig.OBJ_ID, bVar.dTD.getUserId());
                    if ((a.this.dTd.dTV == null || view.getId() != a.this.dTd.dTV.getId()) && (a.this.dTd.bHN.getHeaderImg() == null || view.getId() != a.this.dTd.bHN.getHeaderImg().getId())) {
                        if (a.this.dTd.dTT != null && view.getId() == a.this.dTd.dTT.getId()) {
                            anVar.r("obj_locate", 3);
                        } else {
                            anVar.r("obj_locate", 2);
                        }
                    } else {
                        anVar.r("obj_locate", 1);
                    }
                    anVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aDp());
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
        this.dTd = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.aRC != null) {
            this.dTd.j(this.aRC);
        }
        return new com.baidu.tieba.card.a.a<>(this.dTd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.dTD == null || aVar == null || StringUtils.isNull(bVar.dTD.getName()) || StringUtils.isNull(bVar.dTD.getUserId())) {
            return null;
        }
        if (aVar.ajC() instanceof com.baidu.tieba.a.e) {
            aVar.ajC().setPage(this.bHB);
        }
        aVar.ajC().a(bVar);
        aVar.ajC().b(this.dTe);
        aVar.ajC().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.ajb().a(new an("c12353").f("uid", TbadkCoreApplication.getCurrentAccountId()).ae(VideoPlayActivityConfig.OBJ_ID, bVar.dTD.getUserId()).r("obj_type", 4).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aDp()).ae("tid", bVar.dbw.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void iB(String str) {
        this.bHB = str;
    }
}
