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
    public BdUniqueId aRF;
    private String bGM;
    private com.baidu.tieba.homepage.concern.view.a dQA;
    private ad dQw;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dQw = new ad<j>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ad
            public void a(View view, j jVar) {
                if (view != null && c.this.dQA != null && c.this.dQA.getView() != null && jVar != null && jVar.SV() != null && !StringUtils.isNull(jVar.SV().getTid())) {
                    boolean z = view == c.this.dQA.getHeaderImg();
                    an anVar = new an("c12352");
                    anVar.r("obj_locate", z ? 1 : 2);
                    anVar.ah("obj_type", jVar.aiM());
                    anVar.ah("tid", jVar.threadData.getTid());
                    anVar.f(ImageViewerConfig.FORUM_ID, jVar.threadData.getFid());
                    anVar.ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(anVar);
                    if (view == c.this.dQA.bGZ.getCommentContainer() || view == c.this.dQA.bHN.ayE.getCommentContainer()) {
                        an anVar2 = new an("c12942");
                        anVar2.r("obj_locate", 7);
                        anVar2.r("obj_type", 5);
                        anVar2.ah("tid", jVar.SV().getTid());
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
    /* renamed from: X */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.dQA = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext);
        if (this.aRF != null) {
            this.dQA.j(this.aRF);
        }
        return new com.baidu.tieba.card.a.a<>(this.dQA);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (jVar == null || aVar == null || aVar.aja() == null) {
            return null;
        }
        jVar.iL(i + 1);
        v.aiz().a(jVar.le("c12351"));
        if (aVar.aja() instanceof com.baidu.tieba.a.e) {
            aVar.aja().setPage(this.bGM);
        }
        aVar.aja().a(jVar);
        aVar.aja().b(this.dQw);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void iD(String str) {
        this.bGM = str;
    }
}
