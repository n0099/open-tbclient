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
    public BdUniqueId aPk;
    private x cVH;
    private com.baidu.tieba.homepage.concern.view.a cVL;
    private TbPageContext<?> mH;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.cVH = new x<k>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, k kVar) {
                if (view != null && c.this.cVL != null && c.this.cVL.getView() != null && kVar != null && kVar.Nd() != null && !StringUtils.isNull(kVar.Nd().getTid())) {
                    boolean z = view == c.this.cVL.getHeaderImg();
                    ak akVar = new ak("c12352");
                    akVar.r("obj_locate", z ? 1 : 2);
                    akVar.ac("obj_type", kVar.XT());
                    akVar.ac("tid", kVar.threadData.getTid());
                    akVar.f("fid", kVar.threadData.getFid());
                    akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
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
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.cVL = new com.baidu.tieba.homepage.concern.view.a(this.mH);
        if (this.aPk != null) {
            this.cVL.k(this.aPk);
        }
        return new com.baidu.tieba.card.a.a<>(this.cVL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (kVar == null || aVar == null || aVar.Yn() == null) {
            return null;
        }
        kVar.hQ(i + 1);
        u.XN().a(kVar.js("c12351"));
        aVar.Yn().a(kVar);
        aVar.Yn().b(this.cVH);
        return aVar.getView();
    }
}
