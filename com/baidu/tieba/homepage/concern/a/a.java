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
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e>> implements com.baidu.tieba.a.f {
    public BdUniqueId aUU;
    private String bNq;
    private com.baidu.tieba.homepage.concern.view.e eau;
    private ad<com.baidu.tieba.homepage.concern.b.b> eav;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.eav = new ad<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.eau != null) {
                    am amVar = new am("c12407");
                    amVar.g(ImageViewerConfig.FORUM_ID, bVar.dhr.getFid());
                    amVar.al("tid", bVar.dhr.getTid());
                    amVar.w("obj_type", 4);
                    amVar.al(VideoPlayActivityConfig.OBJ_ID, bVar.eaW.getUserId());
                    if ((a.this.eau.ebo == null || view.getId() != a.this.eau.ebo.getId()) && (a.this.eau.bNC.getHeaderImg() == null || view.getId() != a.this.eau.bNC.getHeaderImg().getId())) {
                        if (a.this.eau.ebm != null && view.getId() == a.this.eau.ebm.getId()) {
                            amVar.w("obj_locate", 3);
                        } else {
                            amVar.w("obj_locate", 2);
                        }
                    } else {
                        amVar.w("obj_locate", 1);
                    }
                    amVar.w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aFC());
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
        this.eau = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.aUU != null) {
            this.eau.j(this.aUU);
        }
        return new com.baidu.tieba.card.a.a<>(this.eau);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.eaW == null || aVar == null || StringUtils.isNull(bVar.eaW.getName()) || StringUtils.isNull(bVar.eaW.getUserId())) {
            return null;
        }
        if (aVar.aln() instanceof com.baidu.tieba.a.e) {
            aVar.aln().setPage(this.bNq);
        }
        aVar.aln().a(bVar);
        aVar.aln().b(this.eav);
        aVar.aln().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.akM().a(new am("c12353").g("uid", TbadkCoreApplication.getCurrentAccountId()).al(VideoPlayActivityConfig.OBJ_ID, bVar.eaW.getUserId()).w("obj_type", 4).w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aFC()).al("tid", bVar.dhr.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void jd(String str) {
        this.bNq = str;
    }
}
