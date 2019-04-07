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
    public BdUniqueId cnZ;
    private ab<com.baidu.tieba.homepage.concern.b.b> eEg;
    private com.baidu.tieba.homepage.concern.view.e fGm;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.eEg = new ab<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.fGm != null) {
                    am amVar = new am("c12407");
                    amVar.k(ImageViewerConfig.FORUM_ID, bVar.eNy.getFid());
                    amVar.bJ("tid", bVar.eNy.getTid());
                    amVar.T("obj_type", 4);
                    amVar.bJ(VideoPlayActivityConfig.OBJ_ID, bVar.fGO.getUserId());
                    if ((a.this.fGm.fHf == null || view.getId() != a.this.fGm.fHf.getId()) && (a.this.fGm.dqx.getHeaderImg() == null || view.getId() != a.this.fGm.dqx.getHeaderImg().getId())) {
                        if (a.this.fGm.fHe != null && view.getId() == a.this.fGm.fHe.getId()) {
                            amVar.T("obj_locate", 3);
                        } else {
                            amVar.T("obj_locate", 2);
                        }
                    } else {
                        amVar.T("obj_locate", 1);
                    }
                    amVar.T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.blv());
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
        this.fGm = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.cnZ != null) {
            this.fGm.k(this.cnZ);
        }
        return new com.baidu.tieba.card.a.a<>(this.fGm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.fGO == null || aVar == null || StringUtils.isNull(bVar.fGO.getName()) || StringUtils.isNull(bVar.fGO.getUserId())) {
            return null;
        }
        if (aVar.aRg() instanceof com.baidu.tieba.a.e) {
            aVar.aRg().setPage(this.YA);
        }
        aVar.aRg().a(bVar);
        aVar.aRg().d(this.eEg);
        aVar.aRg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        t.aQD().b(new am("c12353").k("uid", TbadkCoreApplication.getCurrentAccountId()).bJ(VideoPlayActivityConfig.OBJ_ID, bVar.fGO.getUserId()).T("obj_type", 4).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.blv()).bJ("tid", bVar.eNy.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void qM(String str) {
        this.YA = str;
    }
}
