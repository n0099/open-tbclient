package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e>> {
    public BdUniqueId aPy;
    private com.baidu.tieba.homepage.concern.view.e det;
    private x<com.baidu.tieba.homepage.concern.b.b> deu;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.deu = new x<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.det != null) {
                    ak akVar = new ak("c12407");
                    akVar.f(ImageViewerConfig.FORUM_ID, bVar.bfM.getFid());
                    akVar.ac("tid", bVar.bfM.getTid());
                    akVar.r("obj_type", 4);
                    akVar.ac("obj_id", bVar.deT.getUserId());
                    if ((a.this.det.dfk == null || view.getId() != a.this.det.dfk.getId()) && (a.this.det.cTU == null || view.getId() != a.this.det.cTU.getId())) {
                        if (a.this.det.dfh != null && view.getId() == a.this.det.dfh.getId()) {
                            akVar.r("obj_locate", 3);
                        } else {
                            akVar.r("obj_locate", 2);
                        }
                    } else {
                        akVar.r("obj_locate", 1);
                    }
                    akVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.arK());
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.det = new com.baidu.tieba.homepage.concern.view.e(this.mPageContext);
        if (this.aPy != null) {
            this.det.k(this.aPy);
        }
        return new com.baidu.tieba.card.a.a<>(this.det);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.deT == null || aVar == null || StringUtils.isNull(bVar.deT.getName()) || StringUtils.isNull(bVar.deT.getUserId())) {
            return null;
        }
        aVar.aaJ().a(bVar);
        aVar.aaJ().b(this.deu);
        aVar.aaJ().d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        u.aaj().a(new ak("c12353").f(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccountId()).ac("obj_id", bVar.deT.getUserId()).r("obj_type", 4).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.arK()).ac("tid", bVar.bfM.getTid()));
        return aVar.getView();
    }
}
