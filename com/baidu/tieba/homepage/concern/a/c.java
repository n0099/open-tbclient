package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.u;
import com.baidu.tieba.card.x;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<k, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a>> {
    public BdUniqueId aPy;
    private x deu;
    private com.baidu.tieba.homepage.concern.view.a dey;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.deu = new x<k>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.x
            public void a(View view, k kVar) {
                if (view != null && c.this.dey != null && c.this.dey.getView() != null && kVar != null && kVar.NA() != null && !StringUtils.isNull(kVar.NA().getTid())) {
                    boolean z = view == c.this.dey.getHeaderImg();
                    ak akVar = new ak("c12352");
                    akVar.r("obj_locate", z ? 1 : 2);
                    akVar.ac("obj_type", kVar.aap());
                    akVar.ac("tid", kVar.blt.getTid());
                    akVar.f(ImageViewerConfig.FORUM_ID, kVar.blt.getFid());
                    akVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
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
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.dey = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext);
        if (this.aPy != null) {
            this.dey.k(this.aPy);
        }
        return new com.baidu.tieba.card.a.a<>(this.dey);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, k kVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (kVar == null || aVar == null || aVar.aaJ() == null) {
            return null;
        }
        kVar.ih(i + 1);
        u.aaj().a(kVar.jR("c12351"));
        aVar.aaJ().a(kVar);
        aVar.aaJ().b(this.deu);
        return aVar.getView();
    }
}
