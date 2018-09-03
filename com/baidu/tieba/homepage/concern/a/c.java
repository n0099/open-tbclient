package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<j, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a>> implements com.baidu.tieba.a.f {
    public BdUniqueId aRC;
    private String bHB;
    private ad dTe;
    private com.baidu.tieba.homepage.concern.view.a dTi;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dTe = new ad<j>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, j jVar) {
                if (view != null && c.this.dTi != null && c.this.dTi.getView() != null && jVar != null && jVar.Tg() != null && !StringUtils.isNull(jVar.Tg().getTid())) {
                    boolean z = view == c.this.dTi.getHeaderImg();
                    an anVar = new an("c12352");
                    anVar.r("obj_locate", z ? 1 : 2);
                    anVar.ae("obj_type", jVar.ajo());
                    anVar.ae("tid", jVar.threadData.getTid());
                    anVar.f(ImageViewerConfig.FORUM_ID, jVar.threadData.getFid());
                    anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(anVar);
                    if (view == c.this.dTi.bHO.getCommentContainer() || view == c.this.dTi.bIC.ayo.getCommentContainer()) {
                        an anVar2 = new an("c12942");
                        anVar2.r("obj_locate", 7);
                        anVar2.r("obj_type", 5);
                        anVar2.ae("tid", jVar.Tg().getTid());
                        TiebaStatic.log(anVar2);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.dTi = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext);
        if (this.aRC != null) {
            this.dTi.j(this.aRC);
        }
        return new com.baidu.tieba.card.a.a<>(this.dTi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (jVar == null || aVar == null || aVar.ajC() == null) {
            return null;
        }
        jVar.iW(i + 1);
        v.ajb().a(jVar.lf("c12351"));
        if (aVar.ajC() instanceof com.baidu.tieba.a.e) {
            aVar.ajC().setPage(this.bHB);
        }
        aVar.ajC().a(jVar);
        aVar.ajC().b(this.dTe);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void iB(String str) {
        this.bHB = str;
    }
}
