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
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e>> implements com.baidu.tieba.a.f {
    private String YA;
    public BdUniqueId cnX;
    private ab<com.baidu.tieba.homepage.concern.b.b> eEv;
    private com.baidu.tieba.homepage.concern.view.e fGy;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.eEv = new ab<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.fGy != null) {
                    am amVar = new am("c12407");
                    amVar.k(ImageViewerConfig.FORUM_ID, bVar.eNM.getFid());
                    amVar.bJ("tid", bVar.eNM.getTid());
                    amVar.T("obj_type", 4);
                    amVar.bJ(VideoPlayActivityConfig.OBJ_ID, bVar.fHa.getUserId());
                    if ((a.this.fGy.fHr == null || view.getId() != a.this.fGy.fHr.getId()) && (a.this.fGy.dqu.getHeaderImg() == null || view.getId() != a.this.fGy.dqu.getHeaderImg().getId())) {
                        if (a.this.fGy.fHq != null && view.getId() == a.this.fGy.fHq.getId()) {
                            amVar.T("obj_locate", 3);
                        } else {
                            amVar.T("obj_locate", 2);
                        }
                    } else {
                        amVar.T("obj_locate", 1);
                    }
                    amVar.T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.bly());
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.fGy = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.cnX != null) {
            this.fGy.k(this.cnX);
        }
        return new com.baidu.tieba.card.a.a<>(this.fGy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.fHa == null || aVar == null || StringUtils.isNull(bVar.fHa.getName()) || StringUtils.isNull(bVar.fHa.getUserId())) {
            return null;
        }
        if (aVar.aRi() instanceof com.baidu.tieba.a.e) {
            aVar.aRi().setPage(this.YA);
        }
        aVar.aRi().a(bVar);
        aVar.aRi().d(this.eEv);
        aVar.aRi().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        t.aQF().b(new am("c12353").k("uid", TbadkCoreApplication.getCurrentAccountId()).bJ(VideoPlayActivityConfig.OBJ_ID, bVar.fHa.getUserId()).T("obj_type", 4).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.bly()).bJ("tid", bVar.eNM.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void qL(String str) {
        this.YA = str;
    }
}
