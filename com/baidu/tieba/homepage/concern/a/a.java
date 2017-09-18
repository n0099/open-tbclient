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
    public BdUniqueId aOu;
    private com.baidu.tieba.homepage.concern.view.e cZx;
    private x<com.baidu.tieba.homepage.concern.b.b> cZy;
    private TbPageContext<?> mF;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity().getBaseContext(), bdUniqueId);
        this.cZy = new x<com.baidu.tieba.homepage.concern.b.b>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, com.baidu.tieba.homepage.concern.b.b bVar) {
                if (view != null && a.this.cZx != null) {
                    ak akVar = new ak("c12407");
                    akVar.f("fid", bVar.bdn.getFid());
                    akVar.ad("tid", bVar.bdn.getTid());
                    akVar.r("obj_type", 4);
                    akVar.ad("obj_id", bVar.cZS.getUserId());
                    if ((a.this.cZx.daj == null || view.getId() != a.this.cZx.daj.getId()) && (a.this.cZx.cSv == null || view.getId() != a.this.cZx.cSv.getId())) {
                        if (a.this.cZx.dah != null && view.getId() == a.this.cZx.dah.getId()) {
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
        this.cZx = new com.baidu.tieba.homepage.concern.view.e(this.mF);
        if (this.aOu != null) {
            this.cZx.l(this.aOu);
        }
        return new com.baidu.tieba.card.a.a<>(this.cZx);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.b.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.e> aVar) {
        if (bVar.cZS == null || aVar == null || StringUtils.isNull(bVar.cZS.getName()) || StringUtils.isNull(bVar.cZS.getUserId())) {
            return null;
        }
        aVar.YJ().a(bVar);
        aVar.YJ().b(this.cZy);
        aVar.YJ().d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        u.Yj().a(new ak("c12353").f(SapiAccountManager.SESSION_UID, bVar.cZS.getId()));
        return aVar.getView();
    }
}
