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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e>> implements com.baidu.tieba.a.f {
    public BdUniqueId aTr;
    private String bvX;
    private com.baidu.tieba.homepage.concern.view.e dAR;
    private ab<com.baidu.tieba.homepage.concern.b.b> dAS;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.dAS = new ab<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view2 != null && a.this.dAR != null) {
                    al alVar = new al("c12407");
                    alVar.f(ImageViewerConfig.FORUM_ID, bVar.cQx.getFid());
                    alVar.ac("tid", bVar.cQx.getTid());
                    alVar.r("obj_type", 4);
                    alVar.ac(VideoPlayActivityConfig.OBJ_ID, bVar.dBt.getUserId());
                    if ((a.this.dAR.dBK == null || view2.getId() != a.this.dAR.dBK.getId()) && (a.this.dAR.bwj.getHeaderImg() == null || view2.getId() != a.this.dAR.bwj.getHeaderImg().getId())) {
                        if (a.this.dAR.dBI != null && view2.getId() == a.this.dAR.dBI.getId()) {
                            alVar.r("obj_locate", 3);
                        } else {
                            alVar.r("obj_locate", 2);
                        }
                    } else {
                        alVar.r("obj_locate", 1);
                    }
                    alVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.axo());
                    TiebaStatic.log(alVar);
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
        this.dAR = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.aTr != null) {
            this.dAR.j(this.aTr);
        }
        return new com.baidu.tieba.card.a.a<>(this.dAR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.dBt == null || aVar == null || StringUtils.isNull(bVar.dBt.getName()) || StringUtils.isNull(bVar.dBt.getUserId())) {
            return null;
        }
        if (aVar.afY() instanceof com.baidu.tieba.a.e) {
            aVar.afY().setPage(this.bvX);
        }
        aVar.afY().a(bVar);
        aVar.afY().b(this.dAS);
        aVar.afY().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        v.afy().a(new al("c12353").f("uid", TbadkCoreApplication.getCurrentAccountId()).ac(VideoPlayActivityConfig.OBJ_ID, bVar.dBt.getUserId()).r("obj_type", 4).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.axo()).ac("tid", bVar.cQx.getTid()));
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void hY(String str) {
        this.bvX = str;
    }
}
