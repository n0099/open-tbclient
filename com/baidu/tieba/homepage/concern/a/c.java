package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.j;
import com.baidu.tieba.card.v;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<j, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a>> implements com.baidu.tieba.a.f {
    public BdUniqueId aTr;
    private String bvX;
    private ab dAP;
    private com.baidu.tieba.homepage.concern.view.a dAT;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.dAP = new ab<j>() { // from class: com.baidu.tieba.homepage.concern.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, j jVar) {
                if (view2 != null && c.this.dAT != null && c.this.dAT.getView() != null && jVar != null && jVar.Pe() != null && !StringUtils.isNull(jVar.Pe().getTid())) {
                    boolean z = view2 == c.this.dAT.getHeaderImg();
                    al alVar = new al("c12352");
                    alVar.r("obj_locate", z ? 1 : 2);
                    alVar.ac("obj_type", jVar.afL());
                    alVar.ac("tid", jVar.threadData.getTid());
                    alVar.f(ImageViewerConfig.FORUM_ID, jVar.threadData.getFid());
                    alVar.ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "1");
                    TiebaStatic.log(alVar);
                    if (view2 == c.this.dAT.bwk.getCommentContainer() || view2 == c.this.dAT.bwZ.apG.getCommentContainer()) {
                        al alVar2 = new al("c12942");
                        alVar2.r("obj_locate", 7);
                        alVar2.r("obj_type", 5);
                        alVar2.ac("tid", jVar.Pe().getTid());
                        TiebaStatic.log(alVar2);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> onCreateViewHolder(ViewGroup viewGroup) {
        this.dAT = new com.baidu.tieba.homepage.concern.view.a(this.mPageContext);
        if (this.aTr != null) {
            this.dAT.j(this.aTr);
        }
        return new com.baidu.tieba.card.a.a<>(this.dAT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, j jVar, com.baidu.tieba.card.a.a<com.baidu.tieba.homepage.concern.view.a> aVar) {
        if (jVar == null || aVar == null || aVar.afY() == null) {
            return null;
        }
        jVar.iN(i + 1);
        v.afy().a(jVar.kB("c12351"));
        if (aVar.afY() instanceof com.baidu.tieba.a.e) {
            aVar.afY().setPage(this.bvX);
        }
        aVar.afY().a(jVar);
        aVar.afY().b(this.dAP);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void hY(String str) {
        this.bvX = str;
    }
}
