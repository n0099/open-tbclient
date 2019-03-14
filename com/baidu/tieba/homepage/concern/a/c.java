package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.widget.ListView.a<j, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a>> implements com.baidu.tieba.a.f {
    private String YA;
    public BdUniqueId cnX;
    private ab eEv;
    private com.baidu.tieba.homepage.concern.view.a fGC;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eEv = new ab<j>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, j jVar) {
                if (view != null && c.this.fGC != null && c.this.fGC.getView() != null && jVar != null && jVar.WR() != null && !StringUtils.isNull(jVar.WR().getTid())) {
                    boolean z = view == c.this.fGC.getHeaderImg();
                    am amVar = new am("c12352");
                    amVar.T("obj_locate", z ? 1 : 2);
                    amVar.bJ("obj_type", jVar.aQR());
                    amVar.bJ("tid", jVar.threadData.getTid());
                    amVar.k(ImageViewerConfig.FORUM_ID, jVar.threadData.getFid());
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(amVar);
                    if (view == c.this.fGC.dqv.getCommentContainer() || view == c.this.fGC.drk.bTz.getCommentContainer()) {
                        am amVar2 = new am("c12942");
                        amVar2.T("obj_locate", 7);
                        amVar2.T("obj_type", 5);
                        amVar2.bJ("tid", jVar.WR().getTid());
                        TiebaStatic.log(amVar2);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.fGC = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext);
        if (this.cnX != null) {
            this.fGC.k(this.cnX);
        }
        return new com.baidu.tieba.card.a.a<>(this.fGC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (jVar == null || aVar == null || aVar.aRi() == null) {
            return null;
        }
        jVar.os(i + 1);
        t.aQF().b(jVar.tG("c12351"));
        if (aVar.aRi() instanceof com.baidu.tieba.a.e) {
            aVar.aRi().setPage(this.YA);
        }
        aVar.aRi().a(jVar);
        aVar.aRi().d(this.eEv);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void qL(String str) {
        this.YA = str;
    }
}
