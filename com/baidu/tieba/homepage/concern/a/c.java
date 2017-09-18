package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a>> {
    public BdUniqueId aOu;
    private com.baidu.tieba.homepage.concern.view.a cZC;
    private x cZy;
    private TbPageContext<?> mF;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cZy = new x<k>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, k kVar) {
                if (view != null && c.this.cZC != null && c.this.cZC.getView() != null && kVar != null && kVar.MR() != null && !StringUtils.isNull(kVar.MR().getTid())) {
                    boolean z = view == c.this.cZC.getHeaderImg();
                    ak akVar = new ak("c12352");
                    akVar.r("obj_locate", z ? 1 : 2);
                    akVar.ad("obj_type", kVar.Yp());
                    akVar.ad("tid", kVar.threadData.getTid());
                    akVar.f("fid", kVar.threadData.getFid());
                    akVar.ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
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
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.cZC = new com.baidu.tieba.homepage.concern.view.a(this.mF);
        if (this.aOu != null) {
            this.cZC.l(this.aOu);
        }
        return new com.baidu.tieba.card.a.a<>(this.cZC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (kVar == null || aVar == null || aVar.YJ() == null) {
            return null;
        }
        kVar.hJ(i + 1);
        u.Yj().a(kVar.jB("c12351"));
        aVar.YJ().a(kVar);
        aVar.YJ().b(this.cZy);
        return aVar.getView();
    }
}
