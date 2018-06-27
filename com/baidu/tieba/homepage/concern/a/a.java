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
    private String bGM;
    private com.baidu.tieba.homepage.concern.view.e dQv;
    private ad<com.baidu.tieba.homepage.concern.b.b> dQw;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.dQw = new ad<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.dQv != null) {
                    an anVar = new an("c12407");
                    anVar.f(ImageViewerConfig.FORUM_ID, bVar.cYJ.getFid());
                    anVar.ah("tid", bVar.cYJ.getTid());
                    anVar.r("obj_type", 4);
                    anVar.ah(VideoPlayActivityConfig.OBJ_ID, bVar.dQV.getUserId());
                    if ((a.this.dQv.dRn == null || view.getId() != a.this.dQv.dRn.getId()) && (a.this.dQv.bGY.getHeaderImg() == null || view.getId() != a.this.dQv.bGY.getHeaderImg().getId())) {
                        if (a.this.dQv.dRl != null && view.getId() == a.this.dQv.dRl.getId()) {
                            anVar.r("obj_locate", 3);
                        } else {
                            anVar.r("obj_locate", 2);
                        }
                    } else {
                        anVar.r("obj_locate", 1);
                    }
                    anVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aCK());
                    TiebaStatic.log(anVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: X */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.dQv = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.aRF != null) {
            this.dQv.j(this.aRF);
        }
        return new com.baidu.tieba.card.a.a<>(this.dQv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.dQV == null || aVar == null || StringUtils.isNull(bVar.dQV.getName()) || StringUtils.isNull(bVar.dQV.getUserId())) {
            return null;
        }
        if (aVar.aja() instanceof com.baidu.tieba.a.e) {
            aVar.aja().setPage(this.bGM);
        }
        aVar.aja().a(bVar);
        aVar.aja().b(this.dQw);
        aVar.aja().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.aiz().a(new an("c12353").f("uid", TbadkCoreApplication.getCurrentAccountId()).ah(VideoPlayActivityConfig.OBJ_ID, bVar.dQV.getUserId()).r("obj_type", 4).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aCK()).ah("tid", bVar.cYJ.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void iD(String str) {
        this.bGM = str;
    }
}
