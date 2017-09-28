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
    public BdUniqueId aPx;
    private com.baidu.tieba.homepage.concern.view.e cVS;
    private x<com.baidu.tieba.homepage.concern.b.b> cVT;
    private TbPageContext<?> mG;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.cVT = new x<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.cVS != null) {
                    ak akVar = new ak("c12407");
                    akVar.f("fid", bVar.bfa.getFid());
                    akVar.ad("tid", bVar.bfa.getTid());
                    akVar.r("obj_type", 4);
                    akVar.ad("obj_id", bVar.cWv.getUserId());
                    if ((a.this.cVS.cWM == null || view.getId() != a.this.cVS.cWM.getId()) && (a.this.cVS.cKB == null || view.getId() != a.this.cVS.cKB.getId())) {
                        if (a.this.cVS.cWK != null && view.getId() == a.this.cVS.cWK.getId()) {
                            akVar.r("obj_locate", 3);
                        } else {
                            akVar.r("obj_locate", 2);
                        }
                    } else {
                        akVar.r("obj_locate", 1);
                    }
                    akVar.r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.apa());
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mG = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: B */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.cVS = new com.baidu.tieba.homepage.concern.view.e(this.mG);
        if (this.aPx != null) {
            this.cVS.k(this.aPx);
        }
        return new com.baidu.tieba.card.a.a<>(this.cVS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.cWv == null || aVar == null || StringUtils.isNull(bVar.cWv.getName()) || StringUtils.isNull(bVar.cWv.getUserId())) {
            return null;
        }
        aVar.Yr().a(bVar);
        aVar.Yr().b(this.cVT);
        aVar.Yr().d(this.mG, TbadkCoreApplication.getInst().getSkinType());
        u.XR().a(new ak("c12353").f(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccountId()).ad("obj_id", bVar.cWv.getUserId()).r("obj_type", 4).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.apa()).ad("tid", bVar.bfa.getTid()));
        return aVar.getView();
    }
}
