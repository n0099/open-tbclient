package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e>> {
    public BdUniqueId aPk;
    private com.baidu.tieba.homepage.concern.view.e cVG;
    private x<com.baidu.tieba.homepage.concern.b.b> cVH;
    private TbPageContext<?> mH;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.cVH = new x<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.cVG != null) {
                    ak akVar = new ak("c12407");
                    akVar.f("fid", bVar.beM.getFid());
                    akVar.ac("tid", bVar.beM.getTid());
                    akVar.r("obj_type", 4);
                    akVar.ac("obj_id", bVar.cWj.getUserId());
                    if ((a.this.cVG.cWA == null || view.getId() != a.this.cVG.cWA.getId()) && (a.this.cVG.cKp == null || view.getId() != a.this.cVG.cKp.getId())) {
                        if (a.this.cVG.cWy != null && view.getId() == a.this.cVG.cWy.getId()) {
                            akVar.r("obj_locate", 3);
                        } else {
                            akVar.r("obj_locate", 2);
                        }
                    } else {
                        akVar.r("obj_locate", 1);
                    }
                    akVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aoV());
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mH = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.cVG = new com.baidu.tieba.homepage.concern.view.e(this.mH);
        if (this.aPk != null) {
            this.cVG.k(this.aPk);
        }
        return new com.baidu.tieba.card.a.a<>(this.cVG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.cWj == null || aVar == null || StringUtils.isNull(bVar.cWj.getName()) || StringUtils.isNull(bVar.cWj.getUserId())) {
            return null;
        }
        aVar.Yn().a(bVar);
        aVar.Yn().b(this.cVH);
        aVar.Yn().d(this.mH, TbadkCoreApplication.getInst().getSkinType());
        u.XN().a(new ak("c12353").f(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccountId()).ac("obj_id", bVar.cWj.getUserId()).r("obj_type", 4).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.aoV()).ac("tid", bVar.beM.getTid()));
        return aVar.getView();
    }
}
