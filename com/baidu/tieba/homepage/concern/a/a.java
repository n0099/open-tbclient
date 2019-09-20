package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l>> implements com.baidu.tieba.a.f {
    private String WM;
    public BdUniqueId cyA;
    private ab faX;
    private com.baidu.tieba.card.l gfb;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.faX = new ab<com.baidu.tieba.card.data.j>() { // from class: com.baidu.tieba.homepage.concern.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.j jVar) {
                if (view != null && a.this.gfb != null && a.this.gfb.getView() != null && jVar != null && jVar.acC() != null && !StringUtils.isNull(jVar.acC().getTid())) {
                    boolean z = view == a.this.gfb.aZY();
                    an anVar = new an("c12352");
                    anVar.P("obj_locate", z ? 1 : 2);
                    anVar.bT("obj_type", jVar.baF());
                    anVar.bT("tid", jVar.threadData.getTid());
                    anVar.n("fid", jVar.threadData.getFid());
                    anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(anVar);
                    if (view == a.this.gfb.dHf.getCommentContainer() || view == a.this.gfb.dHg.cdA.getCommentContainer()) {
                        an anVar2 = new an("c12942");
                        anVar2.P("obj_locate", 7);
                        anVar2.P("obj_type", 5);
                        anVar2.bT("tid", jVar.acC().getTid());
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
    /* renamed from: aq */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> onCreateViewHolder(ViewGroup viewGroup) {
        this.gfb = new com.baidu.tieba.card.l(this.mPageContext);
        this.gfb.dP(true);
        if (this.cyA != null) {
            this.gfb.l(this.cyA);
        }
        return new com.baidu.tieba.card.a.a<>(this.gfb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.card.l> aVar) {
        if (jVar == null || aVar == null || aVar.baX() == null) {
            return null;
        }
        jVar.pN(i + 1);
        t.bat().c(jVar.wc("c12351"));
        if (aVar.baX() instanceof com.baidu.tieba.a.e) {
            aVar.baX().setPage(this.WM);
        }
        aVar.baX().a(jVar);
        aVar.baX().d(this.faX);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void sy(String str) {
        this.WM = str;
    }
}
