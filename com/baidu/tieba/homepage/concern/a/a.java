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
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e>> implements com.baidu.tieba.a.f {
    public BdUniqueId aQJ;
    private String bER;
    private com.baidu.tieba.homepage.concern.view.e dNd;
    private ab<com.baidu.tieba.homepage.concern.b.b> dNe;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.dNe = new ab<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.dNd != null) {
                    am amVar = new am("c12407");
                    amVar.f(ImageViewerConfig.FORUM_ID, bVar.daI.getFid());
                    amVar.ah("tid", bVar.daI.getTid());
                    amVar.r("obj_type", 4);
                    amVar.ah(VideoPlayActivityConfig.OBJ_ID, bVar.dND.getUserId());
                    if ((a.this.dNd.dNW == null || view.getId() != a.this.dNd.dNW.getId()) && (a.this.dNd.bFd.getHeaderImg() == null || view.getId() != a.this.dNd.bFd.getHeaderImg().getId())) {
                        if (a.this.dNd.dNU != null && view.getId() == a.this.dNd.dNU.getId()) {
                            amVar.r("obj_locate", 3);
                        } else {
                            amVar.r("obj_locate", 2);
                        }
                    } else {
                        amVar.r("obj_locate", 1);
                    }
                    amVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aCg());
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.dNd = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.aQJ != null) {
            this.dNd.j(this.aQJ);
        }
        return new com.baidu.tieba.card.a.a<>(this.dNd);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.dND == null || aVar == null || StringUtils.isNull(bVar.dND.getName()) || StringUtils.isNull(bVar.dND.getUserId())) {
            return null;
        }
        if (aVar.ajG() instanceof com.baidu.tieba.a.e) {
            aVar.ajG().setPage(this.bER);
        }
        aVar.ajG().a(bVar);
        aVar.ajG().b(this.dNe);
        aVar.ajG().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.ajh().a(new am("c12353").f("uid", TbadkCoreApplication.getCurrentAccountId()).ah(VideoPlayActivityConfig.OBJ_ID, bVar.dND.getUserId()).r("obj_type", 4).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aCg()).ah("tid", bVar.daI.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void iy(String str) {
        this.bER = str;
    }
}
