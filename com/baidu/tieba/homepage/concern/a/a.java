package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.b.b, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e>> {
    public BdUniqueId aOx;
    private com.baidu.tieba.homepage.concern.view.e cYD;
    private x<com.baidu.tieba.homepage.concern.b.b> cYE;
    private TbPageContext<?> mF;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.cYE = new x<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.cYD != null) {
                    ak akVar = new ak("c12407");
                    akVar.f("fid", bVar.bdq.getFid());
                    akVar.ad("tid", bVar.bdq.getTid());
                    akVar.r("obj_type", 4);
                    akVar.ad("obj_id", bVar.cYY.getUserId());
                    if ((a.this.cYD.cZp == null || view.getId() != a.this.cYD.cZp.getId()) && (a.this.cYD.cRB == null || view.getId() != a.this.cYD.cRB.getId())) {
                        if (a.this.cYD.cZn != null && view.getId() == a.this.cYD.cZn.getId()) {
                            akVar.r("obj_locate", 3);
                        } else {
                            akVar.r("obj_locate", 2);
                        }
                    } else {
                        akVar.r("obj_locate", 1);
                    }
                    TiebaStatic.log(akVar);
                }
            }
        };
        this.mF = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: z */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> onCreateViewHolder(ViewGroup viewGroup) {
        this.cYD = new com.baidu.tieba.homepage.concern.view.e(this.mF);
        if (this.aOx != null) {
            this.cYD.l(this.aOx);
        }
        return new com.baidu.tieba.card.a.a<>(this.cYD);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.cYY == null || aVar == null || StringUtils.isNull(bVar.cYY.getName()) || StringUtils.isNull(bVar.cYY.getUserId())) {
            return null;
        }
        aVar.Yy().a(bVar);
        aVar.Yy().b(this.cYE);
        aVar.Yy().d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        u.XY().a(new ak("c12353").f(SapiAccountManager.SESSION_UID, bVar.cYY.getId()));
        return aVar.getView();
    }
}
