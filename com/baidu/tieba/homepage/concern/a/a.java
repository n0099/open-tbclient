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
    public BdUniqueId bdH;
    private String caz;
    private com.baidu.tieba.homepage.concern.view.e etu;
    private ad<com.baidu.tieba.homepage.concern.b.b> etv;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.etv = new ad<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.etu != null) {
                    am amVar = new am("c12407");
                    amVar.i(ImageViewerConfig.FORUM_ID, bVar.dzM.getFid());
                    amVar.aA("tid", bVar.dzM.getTid());
                    amVar.x("obj_type", 4);
                    amVar.aA(VideoPlayActivityConfig.OBJ_ID, bVar.etW.getUserId());
                    if ((a.this.etu.euo == null || view.getId() != a.this.etu.euo.getId()) && (a.this.etu.caL.getHeaderImg() == null || view.getId() != a.this.etu.caL.getHeaderImg().getId())) {
                        if (a.this.etu.eum != null && view.getId() == a.this.etu.eum.getId()) {
                            amVar.x("obj_locate", 3);
                        } else {
                            amVar.x("obj_locate", 2);
                        }
                    } else {
                        amVar.x("obj_locate", 1);
                    }
                    amVar.x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aKY());
                    TiebaStatic.log(amVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.etu = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.bdH != null) {
            this.etu.j(this.bdH);
        }
        return new com.baidu.tieba.card.a.a<>(this.etu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.etW == null || aVar == null || StringUtils.isNull(bVar.etW.getName()) || StringUtils.isNull(bVar.etW.getUserId())) {
            return null;
        }
        if (aVar.aqT() instanceof com.baidu.tieba.a.e) {
            aVar.aqT().setPage(this.caz);
        }
        aVar.aqT().a(bVar);
        aVar.aqT().b(this.etv);
        aVar.aqT().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.aqs().a(new am("c12353").i("uid", TbadkCoreApplication.getCurrentAccountId()).aA(VideoPlayActivityConfig.OBJ_ID, bVar.etW.getUserId()).x("obj_type", 4).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aKY()).aA("tid", bVar.dzM.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void jL(String str) {
        this.caz = str;
    }
}
