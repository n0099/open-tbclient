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
    private String bWE;
    public BdUniqueId bag;
    private com.baidu.tieba.homepage.concern.view.e ejI;
    private ad<com.baidu.tieba.homepage.concern.b.b> ejJ;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.ejJ = new ad<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.ejI != null) {
                    am amVar = new am("c12407");
                    amVar.h(ImageViewerConfig.FORUM_ID, bVar.dqz.getFid());
                    amVar.ax("tid", bVar.dqz.getTid());
                    amVar.x("obj_type", 4);
                    amVar.ax(VideoPlayActivityConfig.OBJ_ID, bVar.ekk.getUserId());
                    if ((a.this.ejI.ekC == null || view.getId() != a.this.ejI.ekC.getId()) && (a.this.ejI.bWQ.getHeaderImg() == null || view.getId() != a.this.ejI.bWQ.getHeaderImg().getId())) {
                        if (a.this.ejI.ekA != null && view.getId() == a.this.ejI.ekA.getId()) {
                            amVar.x("obj_locate", 3);
                        } else {
                            amVar.x("obj_locate", 2);
                        }
                    } else {
                        amVar.x("obj_locate", 1);
                    }
                    amVar.x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aIs());
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
        this.ejI = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.bag != null) {
            this.ejI.j(this.bag);
        }
        return new com.baidu.tieba.card.a.a<>(this.ejI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.ekk == null || aVar == null || StringUtils.isNull(bVar.ekk.getName()) || StringUtils.isNull(bVar.ekk.getUserId())) {
            return null;
        }
        if (aVar.aor() instanceof com.baidu.tieba.a.e) {
            aVar.aor().setPage(this.bWE);
        }
        aVar.aor().a(bVar);
        aVar.aor().b(this.ejJ);
        aVar.aor().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.anQ().a(new am("c12353").h("uid", TbadkCoreApplication.getCurrentAccountId()).ax(VideoPlayActivityConfig.OBJ_ID, bVar.ekk.getUserId()).x("obj_type", 4).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aIs()).ax("tid", bVar.dqz.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void js(String str) {
        this.bWE = str;
    }
}
