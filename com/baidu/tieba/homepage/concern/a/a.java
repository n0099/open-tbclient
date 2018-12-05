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
    public BdUniqueId bdE;
    private String caw;
    private com.baidu.tieba.homepage.concern.view.e eqC;
    private ad<com.baidu.tieba.homepage.concern.b.b> eqD;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.eqD = new ad<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.eqC != null) {
                    am amVar = new am("c12407");
                    amVar.i(ImageViewerConfig.FORUM_ID, bVar.dwZ.getFid());
                    amVar.aA("tid", bVar.dwZ.getTid());
                    amVar.x("obj_type", 4);
                    amVar.aA(VideoPlayActivityConfig.OBJ_ID, bVar.ere.getUserId());
                    if ((a.this.eqC.erx == null || view.getId() != a.this.eqC.erx.getId()) && (a.this.eqC.caI.getHeaderImg() == null || view.getId() != a.this.eqC.caI.getHeaderImg().getId())) {
                        if (a.this.eqC.erv != null && view.getId() == a.this.eqC.erv.getId()) {
                            amVar.x("obj_locate", 3);
                        } else {
                            amVar.x("obj_locate", 2);
                        }
                    } else {
                        amVar.x("obj_locate", 1);
                    }
                    amVar.x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aKj());
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
        this.eqC = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.bdE != null) {
            this.eqC.j(this.bdE);
        }
        return new com.baidu.tieba.card.a.a<>(this.eqC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.ere == null || aVar == null || StringUtils.isNull(bVar.ere.getName()) || StringUtils.isNull(bVar.ere.getUserId())) {
            return null;
        }
        if (aVar.aqe() instanceof com.baidu.tieba.a.e) {
            aVar.aqe().setPage(this.caw);
        }
        aVar.aqe().a(bVar);
        aVar.aqe().b(this.eqD);
        aVar.aqe().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.apD().a(new am("c12353").i("uid", TbadkCoreApplication.getCurrentAccountId()).aA(VideoPlayActivityConfig.OBJ_ID, bVar.ere.getUserId()).x("obj_type", 4).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aKj()).aA("tid", bVar.dwZ.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void jK(String str) {
        this.caw = str;
    }
}
