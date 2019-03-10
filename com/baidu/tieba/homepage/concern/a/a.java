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
    private String Yz;
    public BdUniqueId cnX;
    private ab<com.baidu.tieba.homepage.concern.b.b> eEz;
    private com.baidu.tieba.homepage.concern.view.e fGz;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.eEz = new ab<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.fGz != null) {
                    am amVar = new am("c12407");
                    amVar.k(ImageViewerConfig.FORUM_ID, bVar.eNQ.getFid());
                    amVar.bJ("tid", bVar.eNQ.getTid());
                    amVar.T("obj_type", 4);
                    amVar.bJ(VideoPlayActivityConfig.OBJ_ID, bVar.fHb.getUserId());
                    if ((a.this.fGz.fHs == null || view.getId() != a.this.fGz.fHs.getId()) && (a.this.fGz.dqy.getHeaderImg() == null || view.getId() != a.this.fGz.dqy.getHeaderImg().getId())) {
                        if (a.this.fGz.fHr != null && view.getId() == a.this.fGz.fHr.getId()) {
                            amVar.T("obj_locate", 3);
                        } else {
                            amVar.T("obj_locate", 2);
                        }
                    } else {
                        amVar.T("obj_locate", 1);
                    }
                    amVar.T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.blz());
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
        this.fGz = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.cnX != null) {
            this.fGz.k(this.cnX);
        }
        return new com.baidu.tieba.card.a.a<>(this.fGz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.fHb == null || aVar == null || StringUtils.isNull(bVar.fHb.getName()) || StringUtils.isNull(bVar.fHb.getUserId())) {
            return null;
        }
        if (aVar.aRj() instanceof com.baidu.tieba.a.e) {
            aVar.aRj().setPage(this.Yz);
        }
        aVar.aRj().a(bVar);
        aVar.aRj().d(this.eEz);
        aVar.aRj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        t.aQG().b(new am("c12353").k("uid", TbadkCoreApplication.getCurrentAccountId()).bJ(VideoPlayActivityConfig.OBJ_ID, bVar.fHb.getUserId()).T("obj_type", 4).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.blz()).bJ("tid", bVar.eNQ.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void qN(String str) {
        this.Yz = str;
    }
}
