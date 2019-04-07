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
    public BdUniqueId cnZ;
    private ab eEg;
    private com.baidu.tieba.homepage.concern.view.a fGq;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.eEg = new ab<j>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, j jVar) {
                if (view != null && c.this.fGq != null && c.this.fGq.getView() != null && jVar != null && jVar.WO() != null && !StringUtils.isNull(jVar.WO().getTid())) {
                    boolean z = view == c.this.fGq.getHeaderImg();
                    am amVar = new am("c12352");
                    amVar.T("obj_locate", z ? 1 : 2);
                    amVar.bJ("obj_type", jVar.aQP());
                    amVar.bJ("tid", jVar.threadData.getTid());
                    amVar.k(ImageViewerConfig.FORUM_ID, jVar.threadData.getFid());
                    amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(amVar);
                    if (view == c.this.fGq.dqy.getCommentContainer() || view == c.this.fGq.drn.bTB.getCommentContainer()) {
                        am amVar2 = new am("c12942");
                        amVar2.T("obj_locate", 7);
                        amVar2.T("obj_type", 5);
                        amVar2.bJ("tid", jVar.WO().getTid());
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
        this.fGq = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext);
        if (this.cnZ != null) {
            this.fGq.k(this.cnZ);
        }
        return new com.baidu.tieba.card.a.a<>(this.fGq);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (jVar == null || aVar == null || aVar.aRg() == null) {
            return null;
        }
        jVar.oo(i + 1);
        t.aQD().b(jVar.tF("c12351"));
        if (aVar.aRg() instanceof com.baidu.tieba.a.e) {
            aVar.aRg().setPage(this.YA);
        }
        aVar.aRg().a(jVar);
        aVar.aRg().d(this.eEg);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void qM(String str) {
        this.YA = str;
    }
}
