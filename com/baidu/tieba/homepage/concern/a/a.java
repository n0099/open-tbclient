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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.v;
/* loaded from: classes6.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e>> implements com.baidu.tieba.a.f {
    public BdUniqueId aZt;
    private String bVS;
    private com.baidu.tieba.homepage.concern.view.e ein;
    private ad<com.baidu.tieba.homepage.concern.b.b> eio;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.eio = new ad<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.ein != null) {
                    am amVar = new am("c12407");
                    amVar.h(ImageViewerConfig.FORUM_ID, bVar.dpv.getFid());
                    amVar.ax("tid", bVar.dpv.getTid());
                    amVar.x("obj_type", 4);
                    amVar.ax(VideoPlayActivityConfig.OBJ_ID, bVar.eiP.getUserId());
                    if ((a.this.ein.ejh == null || view.getId() != a.this.ein.ejh.getId()) && (a.this.ein.bWe.getHeaderImg() == null || view.getId() != a.this.ein.bWe.getHeaderImg().getId())) {
                        if (a.this.ein.ejf != null && view.getId() == a.this.ein.ejf.getId()) {
                            amVar.x("obj_locate", 3);
                        } else {
                            amVar.x("obj_locate", 2);
                        }
                    } else {
                        amVar.x("obj_locate", 1);
                    }
                    amVar.x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aIU());
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
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.ein = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.aZt != null) {
            this.ein.j(this.aZt);
        }
        return new com.baidu.tieba.card.a.a<>(this.ein);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.eiP == null || aVar == null || StringUtils.isNull(bVar.eiP.getName()) || StringUtils.isNull(bVar.eiP.getUserId())) {
            return null;
        }
        if (aVar.aoP() instanceof com.baidu.tieba.a.e) {
            aVar.aoP().setPage(this.bVS);
        }
        aVar.aoP().a(bVar);
        aVar.aoP().b(this.eio);
        aVar.aoP().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.aoo().a(new am("c12353").h("uid", TbadkCoreApplication.getCurrentAccountId()).ax(VideoPlayActivityConfig.OBJ_ID, bVar.eiP.getUserId()).x("obj_type", 4).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aIU()).ax("tid", bVar.dpv.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void jq(String str) {
        this.bVS = str;
    }
}
