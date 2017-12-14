package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.s;
import com.baidu.tieba.card.v;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e>> {
    public BdUniqueId aSy;
    private com.baidu.tieba.homepage.concern.view.e doe;
    private v<com.baidu.tieba.homepage.concern.b.b> dof;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.dof = new v<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.doe != null) {
                    ak akVar = new ak("c12407");
                    akVar.f(ImageViewerConfig.FORUM_ID, bVar.cBz.getFid());
                    akVar.ac("tid", bVar.cBz.getTid());
                    akVar.r("obj_type", 4);
                    akVar.ac("obj_id", bVar.doG.getUserId());
                    if ((a.this.doe.doX == null || view.getId() != a.this.doe.doX.getId()) && (a.this.doe.bvE.getHeaderImg() == null || view.getId() != a.this.doe.bvE.getHeaderImg().getId())) {
                        if (a.this.doe.doU != null && view.getId() == a.this.doe.doU.getId()) {
                            akVar.r("obj_locate", 3);
                        } else {
                            akVar.r("obj_locate", 2);
                        }
                    } else {
                        akVar.r("obj_locate", 1);
                    }
                    akVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.atN());
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: U */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.doe = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.aSy != null) {
            this.doe.k(this.aSy);
        }
        return new com.baidu.tieba.card.a.a<>(this.doe);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.doG == null || aVar == null || StringUtils.isNull(bVar.doG.getName()) || StringUtils.isNull(bVar.doG.getUserId())) {
            return null;
        }
        aVar.acC().a(bVar);
        aVar.acC().b(this.dof);
        aVar.acC().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        s.abX().a(new ak("c12353").f("uid", TbadkCoreApplication.getCurrentAccountId()).ac("obj_id", bVar.doG.getUserId()).r("obj_type", 4).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.atN()).ac("tid", bVar.cBz.getTid()));
        return aVar.getView();
    }
}
